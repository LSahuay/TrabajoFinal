package UltimoProyecto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class AddUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel miPanel;
	private JTextField txtUsuario;
	private JTextField txtPassword;
	private JTextField txtRepeatPassword;


	/**
	 * Create the frame.
	 */
	public AddUser() {
		setTitle("Create New User");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 419);
		miPanel = new JPanel();
		miPanel.setBackground(Color.DARK_GRAY);
		miPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(miPanel);
		miPanel.setLayout(null);

		JLabel lblUsername = new JLabel("Usuario");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(162, 80, 139, 41);
		miPanel.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(162, 140, 139, 41);
		miPanel.add(lblPassword);

		JLabel lblRepeatPassword = new JLabel("RepeatPassword");
		lblRepeatPassword.setForeground(Color.WHITE);
		lblRepeatPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 15));
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
		lblNewUser.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewUser.setForeground(Color.WHITE);
		lblNewUser.setBounds(222, 34, 131, 20);
		miPanel.add(lblNewUser);
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.setBounds(480, 351, 85, 21);
		btnAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Login frame = new Login();
				frame.setVisible(true);
				dispose();

			}
		});
		miPanel.add(btnAtras);

		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				validarUsuario();

			}
		});
	}

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
