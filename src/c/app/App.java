package c.app;

import java.sql.*;

import c.jdbc.DBConnect;
import c.log.Log;
import c.window.MainWindow;

public class App {
	static MainWindow mainWindow;
	static DBConnect db;

	public static void init(MainWindow v) {
		mainWindow = v;

	}

	public static void setDb(DBConnect d) {
		db = d;
	}

	public static void testApp() {
		Log.debug("Test Metod Started");
		ResultSet rs = db.executeQuery("SELECT * FROM alumnos");
		if (rs != null) {
			try {
				while (rs.next()) {
					String id = rs.getString("id");
					String nombre = rs.getString("nombre");
					String apellido1 = rs.getString("apellido1");
					String apellido2 = rs.getString("apellido2");

					Log.debug("--------\nid: " + id + "\nNombre: " + nombre + "\napellido1: " + apellido1
							+ "\nApellido2: " + apellido2);

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
