package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao_Database {

	// Modulo de conexao
	/** The driver. */
	// parametros
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/petinfor?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "Pepo1969";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	// metodos
	public Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}	
}
