package c.window;

import javax.swing.JFrame;

import javax.swing.JLabel;

import c.log.Log;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CreateWindow {

	public JFrame frmCreate;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { CreateWindow window = new
	 * CreateWindow(); window.frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the application.
	 */
	public String type;
	public int t;
	
	public CreateWindow(int t) {
		this.t = t;
		if(t==1) {
			type = "profesor";
		} else {
			type = "alumno";
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCreate = new JFrame();
		frmCreate.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				Log.debug("Ventana Crear "+type+" cerrada");
			}
		});
		frmCreate.setVisible(false);
		frmCreate.setTitle("Crear "+type);
		frmCreate.setBounds(100, 100, 788, 429);
		frmCreate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCreate.getContentPane().setLayout(null);
		
		
		
		JLabel lblInfoCreate = new JLabel("Crear "+type);
		lblInfoCreate.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblInfoCreate.setBounds(253, 11, 234, 41);
		frmCreate.getContentPane().add(lblInfoCreate);
	}
}
