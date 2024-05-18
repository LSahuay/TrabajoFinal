package UltimoProyecto;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

public class VDesafio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private String usuario;


	/**
	 * Create the frame.
	 */
	public VDesafio(String nombreUsuario) {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 743, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(242, 158, 216, 66);
		contentPane.add(comboBox);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(242, 245, 216, 46);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(76, 422, 57, 46);
		contentPane.add(textField_2);

		JLabel lblNewLabel = new JLabel("Elige el tipo de criatura");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(0, 0, 0, 150));
		lblNewLabel.setBounds(109, 90, 123, 46);
		lblNewLabel.setOpaque(true);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Elige la criatura");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(0, 0, 0, 150));
		lblNewLabel_1.setBounds(147, 168, 85, 46);
		lblNewLabel_1.setOpaque(true);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Puntos de vida");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBackground(new Color(0, 0, 0, 150));
		lblNewLabel_2.setBounds(147, 244, 85, 46);
		lblNewLabel_2.setOpaque(true);
		contentPane.add(lblNewLabel_2);

		textField_3 = new JTextField();
		textField_3.setBounds(468, 245, 67, 46);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(242, 345, 216, 158);
		contentPane.add(textArea);

		JLabel lblNewLabel_3 = new JLabel("Valor de desafío");
		lblNewLabel_3.setBackground(new Color(0, 0, 0, 150));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(61, 380, 85, 32);
		lblNewLabel_3.setOpaque(true);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Ataques");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBackground(new Color(0, 0, 0, 150));
		lblNewLabel_4.setBounds(325, 303, 57, 32);
		lblNewLabel_4.setOpaque(true);
		contentPane.add(lblNewLabel_4);

		JButton btnNewButton_1 = new JButton("Atrás");
		btnNewButton_1.setBounds(634, 510, 85, 21);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal frame = new VentanaPrincipal(nombreUsuario);
				frame.setVisible(true);
				dispose();

			}
		});

		JLabel lblNewLabel_5 = new JLabel("Total");
		lblNewLabel_5.setBackground(new Color(0, 0, 0, 150));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(478, 203, 49, 32);
		lblNewLabel_5.setOpaque(true);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Genera el valor del desafío");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBackground(new Color(0, 0, 0, 150));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(229, 10, 256, 46);
		lblNewLabel_6.setOpaque(true);
		contentPane.add(lblNewLabel_6);

		JButton btnNewButton_2 = new JButton("Guardar criatura");
		btnNewButton_2.setBounds(468, 396, 128, 46);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Muestra un mensaje sin más. Un syso
				JOptionPane.showMessageDialog(null, "Criatura guardada",
						"Confirmación", JOptionPane.DEFAULT_OPTION);
				
			}
			
		});
		contentPane.add(btnNewButton_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(242, 82, 216, 66);
		contentPane.add(comboBox_1);
		
		JLabel lblFondo = new JLabel("New label");
		lblFondo.setIcon(new ImageIcon("C:\\Users\\jose_\\Downloads\\chris-dien-evergreen-beholder-sml.jpg"));
		lblFondo.setBounds(0, 2, 729, 539);
		contentPane.add(lblFondo);
	}



	public String setUsuario(String nombreUsuario) {
		this.usuario=nombreUsuario;
		
		return usuario;
	
		
	}
}
