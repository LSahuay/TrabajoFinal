package miApp;


import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

/**
 * Esta clase representa la ventana principal de la aplicación.
 */
public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblFondo = new JLabel("");

	/**
     * Constructor de la clase VentanaPrincipal.
     *
     * @param nombreUsuario El nombre del usuario que ha iniciado sesión.
     */
	public VentanaPrincipal(String nombreUsuario) {
		setTitle("DUNGEONS & DRAGONS");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jose_\\eclipse-workspace\\Ventanas\\dnd.jpg"));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 672);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario: " + nombreUsuario);
		lblUsuario.setForeground(new Color(192, 192, 192));
		lblUsuario.setBackground(new Color(192, 192, 192));
		lblUsuario.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
		lblUsuario.setBounds(188, 10, 215, 87);
		contentPane.add(lblUsuario);

		JButton btnAtras = new JButton("Atrás");
		btnAtras.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAtras.setBounds(444, 563, 136, 51);
//		btnAtras.addActionListener(new MiEvento());
		btnAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Login frame = new Login();
				frame.setVisible(true);
				dispose();

			}
		});


		contentPane.add(btnAtras);

		JButton btnNewButton = new JButton("Generador de desafío");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(83, 365, 204, 51);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VDesafio frame = new VDesafio(nombreUsuario);
				frame.setVisible(true);
				frame.setUsuario(nombreUsuario);
				dispose();
				
			}
		});

		JButton btnGeneradorDeBotn = new JButton("Generador de botín");
		btnGeneradorDeBotn.setFont(new Font("Arial", Font.PLAIN, 15));
		btnGeneradorDeBotn.setBounds(307, 365, 204, 51);
		contentPane.add(btnGeneradorDeBotn);
		lblFondo.setIcon(new ImageIcon("C:\\Users\\luisj\\Desktop\\img_proyecto_programacion\\Principal.jpg"));
		lblFondo.setBounds(0, 10, 597, 644);
		contentPane.add(lblFondo);
		btnGeneradorDeBotn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VTesoros frame = new VTesoros(nombreUsuario);
				frame.setVisible(true);
				frame.setUsuario(nombreUsuario);
				dispose();

			}
		});



		setVisible(true);
	}
}
