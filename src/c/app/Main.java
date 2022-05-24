package c.app;

import java.awt.EventQueue;

import c.jdbc.DBConnect;
import c.window.Ventana;

public class Main {
	public static DBConnect db;

	public static void main(String[] args) {
		System.out.println("App started...");
		db = new DBConnect();
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);
					App.init(window);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		App.setDb(db);
		App.testApp();

	}
	
	

}
