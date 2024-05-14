package miApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.plaf.synth.SynthScrollPaneUI;

public class BaseDatos {

	private Connection conn;
	
	public BaseDatos() {
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/ceinmark",
					"root",
					"");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
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
	public void cerrarDB() {
		if(conn != null) {
			try {
				conn.close();
			}catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

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
}
