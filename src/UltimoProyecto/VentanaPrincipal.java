package UltimoProyecto;

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

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(String nombreUsuario) {
		setTitle("DUNGEONS & DRAGONS");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jose_\\eclipse-workspace\\Ventanas\\dnd.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario: " + nombreUsuario);
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
		lblUsuario.setBounds(308, 20, 215, 87);
		contentPane.add(lblUsuario);
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAtras.setBounds(640, 501, 136, 51);
//		btnAtras.addActionListener(new MiEvento());
		btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Login frame = new Login();
				frame.setVisible(true);
				
			}
		});
		
		
		contentPane.add(btnAtras);
		
		JButton btnNewButton = new JButton("Generador de desafío");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(199, 365, 204, 51);
		contentPane.add(btnNewButton);
		
		JButton btnGeneradorDeBotn = new JButton("Generador de botín");
		btnGeneradorDeBotn.setFont(new Font("Arial", Font.PLAIN, 15));
		btnGeneradorDeBotn.setBounds(413, 365, 204, 51);
		contentPane.add(btnGeneradorDeBotn);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jose_\\Downloads\\icono-perfil-usuario-estilo-plano-ilustracion-vector (1).jpg"));
		lblNewLabel.setBounds(297, 117, 220, 220);
		contentPane.add(lblNewLabel);
		
		
		
		setVisible(true);
	}
}
