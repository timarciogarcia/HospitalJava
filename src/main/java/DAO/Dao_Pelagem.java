package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.JB_Pelagem;

public class Dao_Pelagem {

	public ArrayList<JB_Pelagem> listarpelagem() {
		// obj que acessa javabeans
		ArrayList<JB_Pelagem> pelagem = new ArrayList<>();
		String ler = "Select IDpelagem,NOME from tbl_pelagem where excluido is null order by nome";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(ler);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// var de apoio rebebe dados banco
				int nidpelagem = Integer.parseInt(rs.getString(1));
				String nnome = rs.getString(2);

				// guarda no array
				pelagem.add(new JB_Pelagem(nidpelagem,nnome));
			}
			con.close();
			return pelagem;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public void selecionarpelagem(JB_Pelagem pelagem) {
		String read2 = "Select IDpelagem,NOME from tbl_pelagem where idpelagem=?";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, pelagem.getIdpelagem());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				pelagem.setIdpelagem(rs.getInt(1));
				pelagem.setNome(rs.getString(2));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void updatepelagem(JB_Pelagem pelagem) {
		String altera = "update tbl_pelagem set nome=? where idpelagem=?";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(altera);

			pst.setString(1, pelagem.getNome());
			pst.setString(2, Integer.toString(pelagem.getIdpelagem()));
			
			System.out.println(altera);
			
			
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void inserirpelagem(JB_Pelagem pelagem) {
		String Criar = "insert into tbl_pelagem (nome) values(?)";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(Criar);
			pst.setString(1, pelagem.getNome());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void removerpelagem(JB_Pelagem pelagem) {
		String delete = "update tbl_pelagem set excluido=now() where idpelagem=?";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setInt(1, pelagem.getIdpelagem());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
