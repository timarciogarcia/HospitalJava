package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.JB_Patologia;

public class Dao_Patologia {

	public ArrayList<JB_Patologia> listarpatologia() {
		// obj que acessa javabeans
		ArrayList<JB_Patologia> patologia = new ArrayList<>();
		String ler = "Select IDpatologia,NOME,descricao from tbl_patologia where excluido is null order by nome";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(ler);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// var de apoio rebebe dados banco
				int nidpatologia = Integer.parseInt(rs.getString(1));
				String nnome = rs.getString(2);
				String ndescricao= rs.getString(3);

				// guarda no array
				patologia.add(new JB_Patologia(nidpatologia,nnome,ndescricao));
			}
			con.close();
			return patologia;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public void selecionarpatologia(JB_Patologia patologia) {
		String read2 = "Select IDpatologia,NOME,descricao from tbl_patologia where idpatologia=?";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, patologia.getIdpatologia());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				patologia.setIdpatologia(rs.getInt(1));
				patologia.setNome(rs.getString(2));
				patologia.setDescricao(rs.getString(3));				
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void updatepatologia(JB_Patologia patologia) {
		String altera = "update tbl_patologia set nome=?,descricao=? where idpatologia=?";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(altera);

			pst.setString(1, patologia.getNome());
			pst.setString(2, patologia.getDescricao());
			pst.setString(3, Integer.toString(patologia.getIdpatologia()));
			
			System.out.println(altera);
			
			
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void inserirpatologia(JB_Patologia patologia) {
		String Criar = "insert into tbl_patologia (nome,descricao) values(?,?)";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(Criar);
			pst.setString(1, patologia.getNome());
			pst.setString(2, patologia.getDescricao());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void removerpatologia(JB_Patologia patologia) {
		String delete = "update tbl_patologia set excluido=now() where idpatologia=?";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setInt(1, patologia.getIdpatologia());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
