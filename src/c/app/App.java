package c.app;

import java.sql.*;

import c.jdbc.DBConnect;
import c.log.Log;
import c.window.*;

public class App {
	static MainWindow mainWindow;
	static CreateWindow tcp, tca;
	static DBConnect db;

	public static void init(MainWindow v, CreateWindow cp, CreateWindow ca) {
		mainWindow = v;
		tcp = cp;
		tca = ca;

	}

	public static void setDb(DBConnect d) {
		db = d;
	}
	
	public static void createProf() {
		Log.debug("Opening CreateProf Window");
		tcp.frmCreate.setVisible(true);
	}
	
	public static void createAlum() {
		Log.debug("Opening CreateAlumn Window");
		tca.frmCreate.setVisible(true);
	}
	
	public static ResultSet fetchProf() {
		ResultSet rs = db.executeQuery("SELECT * FROM profesores");
		db.stClose();
		return rs;
	}
	
	public static int getNumProfs() {
		ResultSet rs = fetchProf();
		if (rs==null) {
			Log.warn("No profs found");
			return 0;
		}
		try {
			rs.last();
			return rs.getRow();
		} catch (SQLException ex) {
			Log.error("SQL Exception trying to get number of profs");
			return 0;
		}
	}
	
	public static ResultSet fetchAlumn() {
		ResultSet rs = db.executeQuery("SELECT * FROM alumnos");
		db.stClose();
		return rs;
	}
	
	public static int getNumAlumn() {
		int r = 0;
		ResultSet rs = fetchAlumn();
		
		if (rs==null) {
			Log.warn("No alumns found");
			return 0;
		}
		try {
			rs.last();
			r = rs.getRow();
			return r;
		} catch (SQLException ex) {
			Log.error("SQL Exception trying to get number of alumn");
			return 0;
		}
	}

	public static void testApp() {
		Log.debug("Test Metod Started");
		ResultSet rs = db.executeQuery("SELECT * FROM alumnos");
		if (rs != null) {
			try {
				Log.debug("Found " + " result(s).");
				while (rs.next()) {
					String id = rs.getString("id");
					String nombre = rs.getString("nombre");
					String apellido1 = rs.getString("apellido1");
					String apellido2 = rs.getString("apellido2");
					
					System.out.print("--------\nid: " + id + "\nNombre: " + nombre + "\napellido1: " + apellido1 + "\nApellido2: " + apellido2);

				}
			} catch (SQLException e) {
				// TODO SQLEXCEPTION
				e.printStackTrace();
			} catch (Exception ex) {
				// TODO generic exception
				System.out.println("GENERIC EXCEPTION");
			}
		} else {
			Log.debug("No results.");
		}

		db.stClose();
	}
}
