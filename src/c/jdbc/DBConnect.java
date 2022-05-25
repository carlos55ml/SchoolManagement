package c.jdbc;

import java.sql.*;

import c.log.Log;

public class DBConnect {
	private Connection con;
	private Statement st;
	PreparedStatement stmt = null;
	private ResultSet rs;
	
	private String conData = "jdbc:mysql://localhost:3306/carlosmoran_schmngmnt";
	private String dbUser = "root";
	private String dbPass = "";
	
	public DBConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(conData, dbUser, dbPass);
			st = con.createStatement();
		} catch (SQLException ex) {
			// TODO sql exception
		} catch (ClassNotFoundException ex) {
			// TODO class not found exception
			System.out.println("CLASS NOT FOUND EXCEPTION");
		} catch (Exception ex) {
			// TODO generic exception
			System.out.println("GENERIC EXCEPTION");
		} finally {
			if (st==null) {
				Log.error("La app no ha podido conectarse a la base de datos. Cerrando CODIGO 99.");
				System.exit(99);
			}
		}
	}
	
	public int executeUpdate(String q) {
		try {
			Log.debug("Executing Update: "+q);
			return st.executeUpdate(q);
		} catch (SQLException e) {
			// TODO SQL EXCEPTION
			return 0;
		}
	}
	
	public ResultSet executeQuery(String q) {
		try {
			Log.debug("Executing Query: "+q);
			rs = st.executeQuery(q);
			return rs;
		} catch (SQLException e) {
			// TODO SQL EXCEPTION
			return null;
		}
	}
	
	public void stClose() {
		try {
			st.close();
			Log.debug("Closed ST");
		} catch (SQLException e) {
			// TODO SQL EXCEPTION
			e.printStackTrace();
		}
	}
	
	public void stmtClose() {
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO sql EXCEPTION
		}
	}
	
	
}
