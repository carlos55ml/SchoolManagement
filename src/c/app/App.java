package c.app;

import java.sql.*;

import c.jdbc.DBConnect;
import c.window.Ventana;

public class App {
	static Ventana ventana;
	static DBConnect db;

	public static void init(Ventana v) {
		ventana = v;

	}

	public static void setDb(DBConnect d) {
		db = d;
	}

	public static void testApp() {
		System.out.println("Testing app...");
		ResultSet rs = db.executeQuery("SELECT * FROM alumnos");
		if (rs != null) {
			try {
				while (rs.next()) {
					// para obtener info de cada columna
					String id = rs.getString("id");
					String nombre = rs.getString("nombre");
					String apellido1 = rs.getString("apellido1");
					String apellido2 = rs.getString("apellido2");

					System.out.println("--------\nid: " + id + "\nNombre: " + nombre + "\napellido1: " + apellido1
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
			System.out.println("No results");
		}
	}
}
