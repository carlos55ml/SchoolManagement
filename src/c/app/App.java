package c.app;

import java.sql.*;

import c.jdbc.DBConnect;
import c.window.Ventana;

public class App {
	static Ventana ventana;
	static DBConnect db;
	
	public static void init(Ventana v, DBConnect d) {
		ventana = v;
		db = d;
	}
	
	public static void testApp() {
		ResultSet rs = db.executeQuery("SELECT * FROM alumnosaa");
		try {
			while (rs.next()) {
				// para obtener info de cada columna
				String id = rs.getString("id");
				String nombre = rs.getString("nombre");
				String apellido1 = rs.getString("apellido1");
				String apellido2 = rs.getString("apellido2");

				System.out.println("--------\nid: " + id + "\nNombre: " + nombre + "\napellido1: " + apellido1 + "\nApellido2: "+ apellido2);

			}
		} catch (SQLException e) {
			// TODO SQLEXCEPTION
			e.printStackTrace();
		}
	}
}
