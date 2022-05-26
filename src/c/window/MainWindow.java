package c.window;

import javax.swing.*;

import c.app.App;
import c.log.Log;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow {

	public JFrame frame;
	private JTextField tfProfCount;
	private JTextField tfCountAlum;

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 815, 516);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblInfoProfesores = new JLabel("Profesores:");
		lblInfoProfesores.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblInfoProfesores.setBounds(90, 76, 127, 43);
		frame.getContentPane().add(lblInfoProfesores);
		
		JButton btnPCreate = new JButton("Crear Nuevo");
		btnPCreate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPCreate.setBounds(103, 129, 191, 43);
		frame.getContentPane().add(btnPCreate);
		
		JButton btnPMostrarTodos = new JButton("Mostrar Todos");
		btnPMostrarTodos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPMostrarTodos.setBounds(103, 192, 191, 43);
		frame.getContentPane().add(btnPMostrarTodos);
		
		JButton btnActualizarProfesor = new JButton("Actualizar Profesor");
		btnActualizarProfesor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnActualizarProfesor.setBounds(103, 261, 187, 43);
		frame.getContentPane().add(btnActualizarProfesor);
		
		JButton btnBorrarProfesor = new JButton("Borrar Profesor");
		btnBorrarProfesor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBorrarProfesor.setBounds(107, 330, 187, 43);
		frame.getContentPane().add(btnBorrarProfesor);
		
		tfProfCount = new JTextField();
		tfProfCount.setEditable(false);
		tfProfCount.setBounds(228, 82, 86, 33);
		frame.getContentPane().add(tfProfCount);
		tfProfCount.setColumns(10);
		
		JLabel lblInfoAlumnos = new JLabel("Alumnos:");
		lblInfoAlumnos.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblInfoAlumnos.setBounds(492, 76, 127, 43);
		frame.getContentPane().add(lblInfoAlumnos);
		
		JButton btnACreate = new JButton("Crear Nuevo");
		btnACreate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnACreate.setBounds(505, 129, 191, 43);
		frame.getContentPane().add(btnACreate);
		
		JButton btnAMostrarTodos = new JButton("Mostrar Todos");
		btnAMostrarTodos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAMostrarTodos.setBounds(505, 192, 191, 43);
		frame.getContentPane().add(btnAMostrarTodos);
		
		JButton btnActualizarAlumno = new JButton("Actualizar Alumno");
		btnActualizarAlumno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnActualizarAlumno.setBounds(505, 261, 187, 43);
		frame.getContentPane().add(btnActualizarAlumno);
		
		JButton btnBorrarAlumno = new JButton("Borrar Alumno");
		btnBorrarAlumno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBorrarAlumno.setBounds(509, 330, 187, 43);
		frame.getContentPane().add(btnBorrarAlumno);
		
		tfCountAlum = new JTextField();
		tfCountAlum.setEditable(false);
		tfCountAlum.setColumns(10);
		tfCountAlum.setBounds(630, 82, 86, 33);
		frame.getContentPane().add(tfCountAlum);
		
		
		btnPCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				App.createProf();
				
			}
			
		});
		
		btnACreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
			
		});
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				Log.debug("Main Window Opened");
				tfProfCount.setText(""+App.getNumProfs());
				tfCountAlum.setText(""+App.getNumAlumn());
				
			}
		});
		
	}
}
