package c.app;

import java.awt.EventQueue;

import c.jdbc.DBConnect;
import c.log.Log;
import c.window.MainWindow;

public class Main {
	public static DBConnect db;

	public static void main(String[] args) {
		Log.debug("App Started");
		db = new DBConnect();
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow mainWindow = new MainWindow();
					mainWindow.frame.setVisible(true);
					App.init(mainWindow);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		App.setDb(db);
		App.testApp();

	}
	
	

}
