package c.jdbc;

import java.sql.*;

public class DBConnect_template {
	
	private Connection con; // Para crear la conexion entre la aplicacion y la BD
	private Statement st; // Para establecer la conexion. Representa una sentencia SQL que ejecutará el
							// servidor de la BD
	PreparedStatement stmt = null; // Tambien representa una sentencia SQL, que permite configurar o parametrizar
									// facilmente valores en la consulta.
	private ResultSet rs; // Representa una tabla con el resultado que genera el SGBD tras ejecutar una
							// sentencia de consulta

	public DBConnect_template(){
			try {
				//aquí nos vamos a conectar a la BD. Para eso escribiremos este bloque: 
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				/*  Utilizamos la primera variable que decalramos anteriomente que nos servirá para almacenar la conexion con la BD.
				 *  A continuación de la libreria que estamos utilizando (jdbc:mysql) ponemos el host y el puerto que estamos utilizando. Esa información la tenemos disponible en nuestra aplicacion de servidor.
				 *  A continuación el nombre de la base de datos a la que nos vamos a conectar,
				 *  y por ultimo ponemos el valor del usuario y de la contraseña de dicha BD
				 */
				con = DriverManager.getConnection("jdbc:mysql://localhost:8889/PRUEBA_1", "root","root");
				
				//para establecer la conexion
				st= con.createStatement();
				
			}catch (Exception e){
				e.printStackTrace();
			}
		}

	// metodo para extraer la info de cada persona que se encuentra en la tabla
	public void getDatos() {
		try {
			// vamos a acceder a la informacion de cada persona que se encuentre en la tabla
			String query = "SELECT * FROM personas";
			rs = st.executeQuery(query);

			// creamos un bucle para recorrer

			while (rs.next()) {
				// para obtener info de cada columna
				String usuario = rs.getString("usuario");
				String nombre = rs.getString("nombre");
				String correo = rs.getString("correo");

				System.out.println("--------\nUsuario: " + usuario + "\nNombre: " + nombre + "\nCorreo: " + correo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // para cercionarnos que cerramos la BD
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}// Fin del metodo detDatos para mostrar toda la tabla

	public void InsertarPersonas() throws SQLException, NumberFormatException, IOException {
		try {
			
			int user;
			String name;
			String mail;

			// si insertamos los datos directamente desde el codigo
			/*
			 * String query =
			 * "INSERT INTO personas (usuario, nombre, correo) VALUES (5,Enrique, 'kike@mail.com')"
			 * ; st.executeUpdate(query);
			 */
//				st.executeQuery(query); //no utilizaríamos este método para ejecutar la sentencia. Debajo os dejo la explicacion detallada

			/**
			 * Una vez que tenemos la conexión preparamos la sentencia. Esto lo hacemos
			 * apoyándonos en la clase PreparedStatement. El PreparedStatement se utiliza
			 * cuando se va a realizar una sustitución de alguno de los valores de la
			 * condición, si no, se podría utilizar un Statement o directamente ejecutar la
			 * sentencia
			 */

			// Si queremos que el usuario nos de los datos sería así:
			System.out.println("\nVamos a proceder a Insertar una nueva persona:");

			System.out.println("\nIntroduzca el numero");
			user = Integer.parseInt(entrada.readLine());
			System.out.println("Introduzca el nombre");
			name = entrada.readLine();
			System.out.println("Introduzca el email");
			mail = entrada.readLine();

			stmt = con.prepareStatement("INSERT INTO personas VALUES (?,?,?)");
			stmt.setInt(1, user);
			stmt.setString(2, name);
			stmt.setString(3, mail);

			/*
			 * Ya solo nos quedará ejecutar la sentencia. Cuando la sentencia a ejecutar no
			 * devuelve un conjunto de resultados no debemos de usar executeQuery(), sino
			 * que deberemos de utilizar executeUpdate(). Esto es aplicable a INSERT, UPDATE
			 * y DELETE.
			 * 
			 */

			int retorno = stmt.executeUpdate();
			if (retorno > 0)
				System.out.println("Insertado correctamente");
			else {
				System.out.println("Error al Insertar");

			}

		} catch (SQLException sqle) {
			System.out.println("SQLState: " + sqle.getSQLState());
			System.out.println("SQLErrorCode: " + sqle.getErrorCode());
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					stmt.close();
					// con.close(); //Si solo fueramos a insertar, tendríamos que cerrar la BD, pero
					// en este caso no lo hacemos puesto que luego vamos a mostrar toda la tabla
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}// fin del metodo InsertarPersonas()

	public void ActualizarPersonas() {
		
		int user;
		String name = null;
		String mail = null;

		try {
			// si queremos actualizar directamente desde el codigo
			/*
			 * String query2 = "UPDATE personas SET nombre= 'Daniela' WHERE usuario=4";
			 * 
			 * // tambien se podría actualizar varios campos añadiendo una coma y poniendo
			 * el nuevo valor del otro campo: String query2 =
			 * "UPDATE personas SET nombre= 'Daniela', correo= 'daniela@mail.com' WHERE usuario=4"
			 * ;
			 * 
			 * st.executeUpdate(query2); System.out.println("Modificacion realizada");
			 */

			System.out.println("\nVamos a Modificar una persona pidiendo información:");
			System.out.println("\nIntroduzca el numero");
			user = Integer.parseInt(entrada.readLine());

			System.out.println("\nIntroduzca el nombre");
			name = entrada.readLine();

			System.out.println("\nIntroduzca el correo");
			mail = entrada.readLine();

			stmt = con.prepareStatement("UPDATE personas SET nombre=?, correo=? WHERE usuario=?");
			stmt.setString(1, name);
			stmt.setString(2, mail);
			stmt.setInt(3, user);

			// Dicho método devolverá el número de filas que se han actualizado. Será un
			// valor entero de 0 al número de filas actualizadas.
			int retorno = stmt.executeUpdate();
			if (retorno > 0)
				System.out.println("Valores actualizados correctamente");
			else {
				System.out.println("ERROR al actualizar");
			}

		} catch (SQLException sqle) {
			System.out.println("SQLState: " + sqle.getSQLState());
			System.out.println("SQLErrorCode: " + sqle.getErrorCode());
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					stmt.close();
					// con.close(); //Si solo fueramos a insertar, tendríamos que cerrar la BD, pero
					// en este caso no lo hacemos puesto que luego vamos a mostrar toda la tabla
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}// fin del metodo ActualizarPersonas()

	public void EliminarPersonas() {
		
		int user;

		try {
			// si queremos eliminar directamente desde el codigo
			/*
			 * String query = "DELETE FROM personas WHERE usuario=10";
			 * st.executeUpdate(query); System.out.println("Eliminación realizada");
			 * 
			 */
			System.out.println("\nUsted va a eliminar a una persona de la Base de Datos:");

			System.out.println("\nIntroduzca el numero del usuario a eliminar");
			user = Integer.parseInt(entrada.readLine());

			stmt = con.prepareStatement("DELETE FROM personas WHERE usuario=?");
			stmt.setInt(1, user);

			// Dicho método devolverá el número de filas que se han actualizado. Será un
			// valor entero de 0 al número de filas actualizadas.
			int retorno = stmt.executeUpdate();
			if (retorno > 0)
				System.out.println("Eliminacion realizada correctamente");

		} catch (SQLException sqle) {
			System.out.println("SQLState: " + sqle.getSQLState());
			System.out.println("SQLErrorCode: " + sqle.getErrorCode());
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					stmt.close();
					// con.close(); //Si solo fueramos a insertar, tendríamos que cerrar la BD, pero
					// en este caso no lo hacemos puesto que luego vamos a mostrar toda la tabla
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}// fin del metodo EliminarPersonas()
}
