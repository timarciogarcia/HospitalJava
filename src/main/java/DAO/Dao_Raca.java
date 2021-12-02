package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.JB_Especie;
import Model.JB_Raca;

public class Dao_Raca {

	
	public ArrayList<JB_Raca> listarRacas() {
		// obj que acessa javabeans
		ArrayList<JB_Raca> raca = new ArrayList<>();
		String ler = "SELECT tbl_raca.*, tbl_especie.nome from tbl_raca LEFT JOIN tbl_especie ON tbl_raca.idespecie = tbl_especie.idespecie where tbl_raca.excluido is null order by tbl_raca.nome";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(ler);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// var de apoio rebebe dados banco
				int nidraca = Integer.parseInt(rs.getString(1));
				int nidespecie = Integer.parseInt(rs.getString(2));
				String nnome = rs.getString(3);
				String nespecie = rs.getString(5);

				// guarda no array
				raca.add(new JB_Raca(nidraca, nidespecie, nnome, nespecie));
			}
			con.close();
			return raca;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void selecionarraca(JB_Raca raca) {
		String read2 = "SELECT tbl_raca.*, tbl_especie.nome from tbl_raca LEFT JOIN tbl_especie ON tbl_raca.idespecie = tbl_especie.idespecie where tbl_raca.idraca=?";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, raca.getIdraca());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				raca.setIdraca(rs.getInt(1));
				raca.setIdespecie(rs.getInt(2));
				raca.setNome(rs.getString(3));
				raca.setNomeEspecie(rs.getString(5));

			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void updateraca(JB_Raca raca) {
		String altera = "update tbl_raca set idespecie=?,nome=? where idraca=?";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(altera);

			pst.setString(1, Integer.toString(raca.getIdespecie()));
			pst.setString(2, raca.getNome());

			pst.setString(3, Integer.toString(raca.getIdraca()));

			System.out.println(altera);

			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void inserirraca(JB_Raca raca) {
		String Criar = "insert into tbl_raca (nome,idespecie) values(?,?)";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(Criar);
			pst.setString(1, raca.getNome());
			pst.setInt(2, raca.getIdespecie());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void removerraca(JB_Raca raca) {
		String delete = "Update tbl_raca set excluido=now()  where idraca=?";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(delete);

			pst.setInt(1, raca.getIdraca());

			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
