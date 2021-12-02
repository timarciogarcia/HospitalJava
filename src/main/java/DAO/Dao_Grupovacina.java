package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.JB_Grupovacina;

public class Dao_Grupovacina {

	public ArrayList<JB_Grupovacina> listargrupovacinas() {
		// obj que acessa javabeans
		ArrayList<JB_Grupovacina> grupovacina = new ArrayList<>();
		String ler = "Select IDgrupovacina,NOME from tbl_grupovacina where excluido is null order by nome";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(ler);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// var de apoio rebebe dados banco
				int nidgrupovacina = Integer.parseInt(rs.getString(1));
				String nnome = rs.getString(2);

				// guarda no array
				grupovacina.add(new JB_Grupovacina(nidgrupovacina,nnome));
			}
			con.close();
			return grupovacina;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public void selecionargrupovacina(JB_Grupovacina grupovacina) {
		String read2 = "Select IDgrupovacina,NOME from tbl_grupovacina where idgrupovacina=?";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, grupovacina.getIdgrupovacina());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				grupovacina.setIdgrupovacina(rs.getInt(1));
				grupovacina.setNome(rs.getString(2));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void updategrupovacina(JB_Grupovacina grupovacina) {
		String altera = "update tbl_grupovacina set nome=? where idgrupovacina=?";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(altera);

			pst.setString(1, grupovacina.getNome());
			pst.setString(2, Integer.toString(grupovacina.getIdgrupovacina()));
			
			System.out.println(altera);
			
			
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void inserirgrupovacina(JB_Grupovacina grupovacina) {
		String Criar = "insert into tbl_grupovacina (nome) values(?)";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(Criar);
			pst.setString(1, grupovacina.getNome());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void removergrupovacina(JB_Grupovacina grupovacina) {
		String delete = "update tbl_grupovacina set excluido=now() where idgrupovacina=?";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setInt(1, grupovacina.getIdgrupovacina());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
