package miApp;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("New label");

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(String nombreUsuario) {
		setTitle("DUNGEONS & DRAGONS");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jose_\\eclipse-workspace\\Ventanas\\dnd.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 681);
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
		btnAtras.setBounds(451, 583, 136, 51);
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
		
		JButton btnGeneradorDeBotn = new JButton("Generador de botín");
		btnGeneradorDeBotn.setFont(new Font("Arial", Font.PLAIN, 15));
		btnGeneradorDeBotn.setBounds(307, 365, 204, 51);
		contentPane.add(btnGeneradorDeBotn);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jose_\\Desktop\\de21c37d-f75a-4c7f-b246-b54bee5631bd.jpeg"));
		lblNewLabel.setBounds(0, 0, 611, 644);
		contentPane.add(lblNewLabel);
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
