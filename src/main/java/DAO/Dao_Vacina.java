package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.JB_Grupovacina;
import Model.JB_Vacina;

public class Dao_Vacina {

	public ArrayList<JB_Vacina> listarVacinas() {
		// obj que acessa javabeans
		ArrayList<JB_Vacina> vacina = new ArrayList<>();
		String ler = "SELECT tbl_vacina.idvacina, tbl_vacina.status, tbl_vacina.nome, tbl_vacina.idgrupovacina, tbl_vacina.laboratorio, tbl_grupovacina.nome, tbl_vacina.excluido from tbl_vacina LEFT JOIN tbl_grupovacina ON tbl_vacina.idgrupovacina = tbl_grupovacina.idgrupovacina where tbl_vacina.excluido is null order by tbl_vacina.nome";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(ler);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// var de apoio rebebe dados banco
				int nidvacina = Integer.parseInt(rs.getString(1));
				int nstatus = Integer.parseInt(rs.getString(2));
				String nnome = rs.getString(3);
				int nidgrupovacina = Integer.parseInt(rs.getString(4));
				String nlaboratorio = rs.getString(5);
				String nnomegrupovacina = rs.getString(6);

				// guarda no array
				vacina.add(new JB_Vacina(nidvacina, nstatus, nnome, nidgrupovacina, nlaboratorio, nnomegrupovacina ));
			}
			con.close();
			return vacina;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void selecionarvacina(JB_Vacina vacina) {
		String read2 = "SELECT tbl_vacina.idvacina, tbl_vacina.status, tbl_vacina.nome, tbl_vacina.idgrupovacina, tbl_vacina.laboratorio, tbl_grupovacina.nome from tbl_vacina LEFT JOIN tbl_vacina ON tbl_vacina.idgrupovacina = tbl_grupovacina.idgrupovacina  where tbl_vacina.idvacina=? order by tbl_vacina.nome";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, vacina.getIdvacina());			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				vacina.setIdvacina(rs.getInt(1));
				vacina.setStatus(rs.getInt(2));
				vacina.setNome(rs.getString(3));
				vacina.setIdgrupovacina(rs.getInt(4));
				vacina.setLaboratorio(rs.getString(5));
				vacina.setNomegrupovacina(rs.getString(6));

			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void updatevacina(JB_Vacina vacina) {
		String altera = "update tbl_vacina set status=?, nome=?, idgrupovacina=?, laboratorio=? where idvacina=?";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(altera);

			
			pst.setString(1, Integer.toString(vacina.getStatus()));
			pst.setString(2, vacina.getNome());
			pst.setString(3, Integer.toString(vacina.getIdgrupovacina()));
			pst.setString(4, vacina.getLaboratorio());
			pst.setString(5, Integer.toString(vacina.getIdvacina()));
			
			
			System.out.println(altera);

			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void inserirvacina(JB_Vacina vacina) {
		String Criar = "insert into tbl_vacina (status,nome,idgrupovacina,laboratorio) values(?,?,?,?)";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(Criar);
			
			pst.setInt(1, vacina.getStatus());
			pst.setString(2, vacina.getNome());
			pst.setInt(3, vacina.getIdgrupovacina());
			pst.setString(4, vacina.getLaboratorio());						
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void removervacina(JB_Vacina vacina) {
		String delete = "delete from tbl_vacina where idvacina=?";
		try {
			Dao_Database DB = new Dao_Database();
			Connection con = DB.conectar();
			PreparedStatement pst = con.prepareStatement(delete);

			pst.setInt(1, vacina.getIdvacina());

			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
