package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;

import Model.JB_Estado;

public class Dao_Estado {

	public ArrayList<JB_Estado> listarEstados() {
		// obj que acessa javabeans
		ArrayList<JB_Estado> estados = new ArrayList<>();
		String ler = "Select IDESTADO,UF,NOME,excluido from tbl_estado where excluido is null order by nome";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(ler);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// var de apoio rebebe dados banco
				int nidestado = Integer.parseInt(rs.getString(1));
				String nuf = rs.getString(2);
				String nnome = rs.getString(3);

				// guarda no array
				estados.add(new JB_Estado(nidestado,nuf,nnome));
			}
			con.close();
			return estados;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public void selecionarestado(JB_Estado estado) {
		String read2 = "Select IDESTADO,UF,NOME from tbl_estado where idestado=?";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, estado.getIdestado());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				estado.setIdestado(rs.getInt(1));
				estado.setUf(rs.getString(2));
				estado.setNome(rs.getString(3));
				
				System.out.println("so esse 1  " + rs.getInt(1));
				System.out.println("so esse 2  " + rs.getString(2));
				System.out.println("so esse 3  " + rs.getString(3));
				
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void updateestado(JB_Estado estado) {
		String altera = "update tbl_estado set nome=?, uf=? where idestado=?";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(altera);

			pst.setString(1, estado.getNome());
			pst.setString(2, estado.getUf());
			pst.setString(3, Integer.toString(estado.getIdestado()));
			
			System.out.println(altera);
			
			
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void inserirestadoo(JB_Estado estado) {
		String Criar = "insert into tbl_estado (uf,nome) values(?,?)";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(Criar);
			pst.setString(1, estado.getUf());
			pst.setString(2, estado.getNome());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void removerestado(JB_Estado estado) throws ParseException {
		/*String delete = "delete from tbl_estado where idestado=?";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(delete);

			pst.setInt(1, estado.getIdestado());
			
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}*/
		

		//SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");  
        /*String str = "10/10/2021";  
        Date data = (Date) formatador.parse(str);	
        System.out.println(data);*/
        
		String altera = "update tbl_estado set excluido=NOW() where idestado=?";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(altera);
			
			//System.out.println("*********" + estado.dataexclusao + "**********");
			//pst.setString(1, estado.dataexclusao );

			pst.setString(1, Integer.toString(estado.getIdestado()));
			
			System.out.println(altera);
			
			
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
