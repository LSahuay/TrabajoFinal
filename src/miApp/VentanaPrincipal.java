package miApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class VentanaPrincipal extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel miPanel;

	public VentanaPrincipal(String nombreUsuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		miPanel = new JPanel();
		miPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(miPanel);
		miPanel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Uuario logueado: " + nombreUsuario);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsuario.setBounds(111, 30, 594, 77);
		miPanel.add(lblUsuario);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVolver.setBounds(661, 461, 115, 56);
		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Login frame = new Login();
				frame.setVisible(true);
				dispose();
				
			}
		});
		
		miPanel.add(btnVolver);
		
		setVisible(true);
	}


}
