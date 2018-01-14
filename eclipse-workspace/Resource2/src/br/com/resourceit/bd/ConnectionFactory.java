package br.com.resourceit.bd;

import java.sql.*;

public class ConnectionFactory {
	//É criado como private para as classes não terem acesso. Devem ser em caixa alta, pois devido ao usar final sao declaradas constantes em caixa alta.
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/resource?useSSL=false";
	private static final String USER = "root";
	private static final String PASS = "swc123";

	public static Connection getConnection() {
		try	{
			try {
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return	DriverManager.getConnection(URL,USER,PASS);
		}	catch	(SQLException e) {
			throw new RuntimeException("Erro na conexão", e);
		}
	}
	public static void closeConnection(Connection con) {	
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void closeConnection(Connection con, PreparedStatement stmt) {	
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		closeConnection(con,stmt);
		try {
			if (rs != null) {
				rs.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
