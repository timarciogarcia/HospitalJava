package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.JB_Departamento;

public class Dao_Departamento {
	
	public ArrayList<JB_Departamento> listardepartamento() {
		ArrayList<JB_Departamento> departamento = new ArrayList<>();
		String ler = "Select IDDEPARTAMENTO,NOME from tbl_departamento where excluido is null order by nome";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(ler);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// var de apoio rebebe dados banco
				int nid = Integer.parseInt(rs.getString(1));
				String nome = rs.getString(2);

				// guarda no array
				departamento.add(new JB_Departamento(nid,nome));
			}
			con.close();
			System.out.println();
			return departamento;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public void selecionardepartamento(JB_Departamento departamento) {
		String read2 = "Select IDdepartamento,NOME from tbl_departamento where iddepartamento=?";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, departamento.getIddepartamento());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				departamento.setIddepartamento(rs.getInt(1));
				departamento.setNome(rs.getString(2));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void alterardepartamento(JB_Departamento departamento) {
		String altera = "update tbl_departamento set nome=? where iddepartamento=?";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(altera);
			pst.setString(1, departamento.getNome());
			pst.setString(2, Integer.toString(departamento.getIddepartamento()));
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void inserirdepartamento(JB_Departamento departamento) {
		String Criar = "insert into tbl_departamento (nome) values(?)";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(Criar);
			pst.setString(1, departamento.getNome());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void excluirdepartamento(JB_Departamento departamento) {
		String delete = "update tbl_departamento set excluido=now() where iddepartamento=?";
		try {
			System.out.println("rotina de exclusao");
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setInt(1, departamento.getIddepartamento());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
