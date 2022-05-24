package c.app;

import java.awt.EventQueue;

import c.jdbc.DBConnect;
import c.window.Ventana;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBConnect db = new DBConnect();
					Ventana window = new Ventana();
					window.frame.setVisible(true);
					App.init(window, db);
					App.testApp();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
	

}
