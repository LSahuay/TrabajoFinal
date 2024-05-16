package UltimoProyecto;


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
import javax.swing.SwingConstants;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblFondo = new JLabel("New label");

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(String nombreUsuario) {
		setTitle("DUNGEONS & DRAGONS");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jose_\\eclipse-workspace\\Ventanas\\dnd.jpg"));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario: " + nombreUsuario);
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setBackground(new Color(0, 0, 0, 150));
		lblUsuario.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
		lblUsuario.setBounds(188, 10, 215, 87);
		lblUsuario.setOpaque(true);
		contentPane.add(lblUsuario);

		JButton btnAtras = new JButton("Atrás");
		btnAtras.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAtras.setBounds(500, 607, 87, 27);
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
				VDesafio frame = new VDesafio();
				frame.setVisible(true);
				dispose();
				
			}
		});

		JButton btnGeneradorDeBotn = new JButton("Generador de botín");
		btnGeneradorDeBotn.setFont(new Font("Arial", Font.PLAIN, 15));
		btnGeneradorDeBotn.setBounds(307, 365, 204, 51);
		contentPane.add(btnGeneradorDeBotn);
		lblFondo.setIcon(new ImageIcon("C:\\Users\\jose_\\Desktop\\Cosas Varias\\de21c37d-f75a-4c7f-b246-b54bee5631bd.jpeg"));
		lblFondo.setBounds(0, 0, 597, 644);
		contentPane.add(lblFondo);
		btnGeneradorDeBotn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VTesoros frame = new VTesoros();
				frame.setVisible(true);
				dispose();

			}
		});



		setVisible(true);
	}
}
