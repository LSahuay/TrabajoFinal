package miApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 * Clase AddUser que proporciona una interfaz gráfica para crear un nuevo usuario.
 */
public class AddUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel miPanel;
	private JTextField txtUsuario;
	private JTextField txtPassword;
	private JTextField txtRepeatPassword;

    /**
     * Método principal para ejecutar la aplicación.
     * @param args Argumentos de línea de comandos.
     */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUser frame = new AddUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
     * Constructor de la clase AddUser.
     * Configura la interfaz gráfica para crear un nuevo usuario.
     */
	public AddUser() {
		setTitle("Create New User");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 419);
		miPanel = new JPanel();
		miPanel.setBackground(Color.DARK_GRAY);
		miPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(miPanel);
		miPanel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Usuario");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblUsername.setBounds(162, 80, 139, 41);
		miPanel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblPassword.setBounds(162, 140, 139, 41);
		miPanel.add(lblPassword);
		
		JLabel lblRepeatPassword = new JLabel("RepeatPassword");
		lblRepeatPassword.setForeground(Color.WHITE);
		lblRepeatPassword.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblRepeatPassword.setBounds(162, 199, 187, 36);
		miPanel.add(lblRepeatPassword);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(162, 121, 251, 20);
		miPanel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(162, 180, 251, 20);
		miPanel.add(txtPassword);
		
		txtRepeatPassword = new JTextField();
		txtRepeatPassword.setColumns(10);
		txtRepeatPassword.setBounds(162, 235, 251, 20);
		miPanel.add(txtRepeatPassword);
		
		JButton btnGuardar = new JButton("Guardar Usuario");
		btnGuardar.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		btnGuardar.setBounds(204, 294, 166, 41);
		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Muestra un mensaje sin más. Un syso
				JOptionPane.showMessageDialog(null, "Usuario guardado",
						"Confirmación de registro", JOptionPane.DEFAULT_OPTION);
				
			}
			
		});
		miPanel.add(btnGuardar);
		
		JLabel lblNewUser = new JLabel("Create New User");
		lblNewUser.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblNewUser.setForeground(Color.WHITE);
		lblNewUser.setBounds(192, 31, 191, 20);
		miPanel.add(lblNewUser);
		

		
		JButton btnatras = new JButton("Atras");
		btnatras.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		btnatras.setBackground(Color.WHITE);
		btnatras.setBounds(452, 327, 97, 33);
		btnatras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Login frame = new Login();
				frame.setVisible(true);
				dispose();

			}
		});
		miPanel.add(btnatras);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\luisj\\Desktop\\img_proyecto_programacion\\creaciondym.jpg"));
		lblNewLabel.setBounds(0, 0, 575, 382);
		miPanel.add(lblNewLabel);
		
		btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				validarUsuario();
				
			}
		});
	}
	
	/**
     * Método para validar los datos del usuario antes de guardarlos en la base de datos.
     * Verifica que el nombre de usuario no esté en blanco y que las contraseñas coincidan.
     */
		private void validarUsuario() {
			
			if(txtUsuario.getText().isBlank()) {
				System.out.println("Error");
			}else if(txtPassword.getText().equalsIgnoreCase(txtRepeatPassword.getText())) {
				BaseDatos bbdd = new BaseDatos();
				bbdd.addUser(txtUsuario.getText(),txtPassword.getText());
				bbdd.cerrarDB();
			}else {
				System.out.println("Las contraseñas no coinciden");
			}
		}
}
