package c.jdbc;

import java.sql.*;

public class DBConnect {
	private Connection con;
	private Statement st;
	PreparedStatement stmt = null;
	private ResultSet rs;
	
	private String conData = "jdbc:mysql://localhost:3389/carlosmoran_schmngmnt";
	private String dbUser = "root";
	private String dbPass = "root";
	
	public DBConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(conData, dbUser, dbPass);
			st= con.createStatement();
		} catch (SQLException ex) {
			// TODO sql exception
		} catch (ClassNotFoundException ex) {
			// TODO class not found exception
		} catch (Exception ex) {
			// TODO generic exception
		}
	}
	
	
}
