package miApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.plaf.synth.SynthScrollPaneUI;

/**
 * Clase BaseDatos que maneja la conexión y las operaciones con la base de datos.
 */
public class BaseDatos {

	private Connection conn;
	
	 /**
     * Constructor de la clase BaseDatos.
     * Establece la conexión con la base de datos MariaDB.
     */
	public BaseDatos() {
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/d&d",
					"root",
					"");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	/**
     * Método para verificar las credenciales de inicio de sesión en la base de datos.
     * @param user Nombre de usuario.
     * @param pass Contraseña del usuario.
     * @return true si las credenciales son correctas, false en caso contrario.
     */
	public boolean loginDB (String user, String pass) {
		boolean loginOK = false;
		
		String sql = "SELECT * FROM usuarios WHERE username ='" + user + 
							"' AND password = '"+ pass +"'";
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				loginOK = true;
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return loginOK;

	}
	/**
     * Método para cerrar la conexión con la base de datos.
     */
	public void cerrarDB() {
		if(conn != null) {
			try {
				conn.close();
			}catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	/**
     * Método para agregar un nuevo usuario a la base de datos.
     * @param username Nombre de usuario.
     * @param password Contraseña del usuario.
     */
	public void addUser(String text, String text2) {
		
		String sql ="INSERT INTO usuarios (username,password) VALUES(?,?)";

		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,text);//definimos el nombreUsuario
			pstmt.setString(2,text2);//definimos la contraseña
			
			int filasinsertadas = pstmt.executeUpdate();
			System.out.println("Filas insertadas " + filasinsertadas);
			System.out.println("Usuario creado correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	/**
     * Método para agregar un nuevo desafío a la base de datos.
     * @param desafio Nombre del desafío.
     * @param descripcion Descripción del desafío.
     */
	public void adddesafio(String text, String text2) {
		
		String sql ="INSERT INTO usuarios (username,password) VALUES(?,?)";

		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,text);//definimos el nombreUsuario
			pstmt.setString(2,text2);//definimos la contraseña
			
			int filasinsertadas = pstmt.executeUpdate();
			System.out.println("Filas insertadas " + filasinsertadas);
			System.out.println("Usuario creado correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	
}
