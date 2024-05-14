package UltimoProyecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Toolkit;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Registro() {
		setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jose_\\eclipse-workspace\\Ventanas\\dnd.jpg"));
		setTitle("DUNGEONS & DRAGONS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Introduce el nombre de usuario");
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 15));
		lblUsuario.setBounds(23, 86, 229, 40);
		contentPane.add(lblUsuario);
		
		JLabel lblIntroduceLaContrasea = new JLabel("Introduce la contraseña");
		lblIntroduceLaContrasea.setFont(new Font("Arial", Font.PLAIN, 15));
		lblIntroduceLaContrasea.setBounds(23, 136, 229, 40);
		contentPane.add(lblIntroduceLaContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(246, 86, 248, 40);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(246, 136, 248, 34);
		contentPane.add(passwordField);
		
		JLabel lblTitle = new JLabel("Registro");
		lblTitle.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTitle.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
		lblTitle.setBounds(242, 10, 113, 40);
		contentPane.add(lblTitle);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(10, 304, 113, 56);
		contentPane.add(btnAtras);
		
		JLabel lblRepeatPass = new JLabel("Repite la contraseña");
		lblRepeatPass.setFont(new Font("Arial", Font.PLAIN, 15));
		lblRepeatPass.setBounds(23, 180, 222, 40);
		contentPane.add(lblRepeatPass);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(246, 180, 248, 34);
		contentPane.add(passwordField_1);
		
		JButton btnSave = new JButton("Registrarse");
		btnSave.setFont(new Font("Arial", Font.PLAIN, 15));
		btnSave.setBounds(291, 224, 157, 34);
		contentPane.add(btnSave);
		
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ValidarUsuario();
				
			}
		});
		
		
		setVisible(true);
	}
	
	private void ValidarUsuario() {
		
		String password = new String(passwordField.getPassword());
		String password_1 = new String(passwordField_1.getPassword());
		
		if(txtUsuario.getText().isBlank()) {
			System.out.println("Error");
		}else if(password.equalsIgnoreCase(password_1)) {
			BaseDatos bbdd = new BaseDatos();
			bbdd.Crear(password, password_1);
			
		}
		
	}
}
