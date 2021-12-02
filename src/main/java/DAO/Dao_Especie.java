package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.JB_Especie;

public class Dao_Especie {

	public ArrayList<JB_Especie> listarespecies() {
		// obj que acessa javabeans
		ArrayList<JB_Especie> especie = new ArrayList<>();
		String ler = "Select IDespecie,NOME from tbl_especie where excluido is null order by nome";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(ler);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// var de apoio rebebe dados banco
				int nidespecie = Integer.parseInt(rs.getString(1));
				String nnome = rs.getString(2);

				// guarda no array
				especie.add(new JB_Especie(nidespecie,nnome));
			}
			con.close();
			return especie;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public void selecionarespecie(JB_Especie especie) {
		String read2 = "Select IDespecie,NOME from tbl_especie where idespecie=?";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, especie.getIdespecie());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				especie.setIdespecie(rs.getInt(1));
				especie.setNome(rs.getString(2));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void updateespecie(JB_Especie especie) {
		String altera = "update tbl_especie set nome=? where idespecie=?";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(altera);

			pst.setString(1, especie.getNome());
			pst.setString(2, Integer.toString(especie.getIdespecie()));
			
			System.out.println(altera);
			
			
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void inserirespecie(JB_Especie especie) {
		String Criar = "insert into tbl_especie (nome) values(?)";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(Criar);
			pst.setString(1, especie.getNome());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void removerespecie(JB_Especie especie) {
		String delete = "update tbl_especie set excluido=now() where idespecie=?";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setInt(1, especie.getIdespecie());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
