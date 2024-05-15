package UltimoProyecto;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;


public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	//Atributos de mi ventana
	private JPanel miPanel;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Login frame = new Login();
		frame.setVisible(true);
	}

	
	public Login() {
		setTitle("Login Dungeons & Dragons");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 419);
		
		//Contenedor del frame
		miPanel = new JPanel();
		miPanel.setBackground(new Color(255, 255, 255));
		//Indicamos el contenedor del Frame
		setContentPane(miPanel);
		miPanel.setLayout(null);
		
		//Añadimos componentes al panel
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(162, 117, 120, 41);
		miPanel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(162, 189, 120, 33);
		miPanel.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBackground(new Color(220, 220, 220));
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUsername.setToolTipText("Introduce el nombre del usuario");
		txtUsername.setBounds(162, 159, 251, 20);
		miPanel.add(txtUsername);
		
		txtPassword = new JPasswordField();
		txtPassword.setBackground(new Color(220, 220, 220));
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPassword.setToolTipText("Introduce la contraseña");
		txtPassword.setBounds(162, 222, 251, 20);
		miPanel.add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogin.setBounds(242, 313, 91, 20);
		miPanel.add(btnLogin);
		
		JButton btnNewButton = new JButton("New usuario");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(231, 269, 112, 21);
		miPanel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\luisj\\eclipse-workspace\\Proyecto_Programacion_19\\img\\dragones y m.jpg"));
		lblNewLabel.setBounds(0, 0, 575, 382);
		miPanel.add(lblNewLabel);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AddUser nuevo = new AddUser();
				nuevo.setVisible(true);
				
			}
		});
		
		//creamos los escuchadores de los botonoes
		
		btnLogin.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Boton acceder pulsado");
				accederAPP();
			}
			
		});
	
	
	}

	protected void accederAPP() {

			String password = new String(txtPassword.getPassword());
			if(!(txtUsername.getText().isBlank() || password.isBlank())) {
				BaseDatos bbdd = new BaseDatos();
				if(bbdd.loginDB(txtUsername.getText(),password)){
					System.out.println("Acceso correcto");
					VentanaPrincipal vPrincipal = new VentanaPrincipal(txtUsername.getText());
					this.dispose();
//					vPrincipal.setVisible(true);
				}else {
					System.out.println("Accedo denegado");
				}
				bbdd.cerrarDB();
			}
			
	}
		
}