package miApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollBar;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.Toolkit;

public class VTesoros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;



	/**
	 * Create the frame.
	 */
	public VTesoros() {
		setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jose_\\eclipse-workspace\\Ventanas\\dnd.jpg"));
		setTitle("DUNGEONS & DRAGONS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 975, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Generador de botín");
		lblTitle.setFont(new Font("Arial", Font.PLAIN, 25));
		lblTitle.setVerticalAlignment(SwingConstants.TOP);
		lblTitle.setBounds(361, 38, 223, 65);
		contentPane.add(lblTitle);
		
		JLabel lblValue = new JLabel("Introduce el valor deseado del botín");
		lblValue.setFont(new Font("Arial", Font.PLAIN, 15));
		lblValue.setBounds(21, 196, 254, 39);
		contentPane.add(lblValue);
		
		textField = new JTextField();
		textField.setBounds(57, 230, 163, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Atrás");
		btnNewButton.setBounds(87, 489, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Generar botín");
		btnNewButton_1.setBounds(86, 279, 99, 47);
		contentPane.add(btnNewButton_1);
		
		JList listDisponibles = new JList();
		listDisponibles.setBounds(275, 156, 309, 202);
		contentPane.add(listDisponibles);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setForeground(new Color(0, 128, 0));
		scrollBar.setBackground(new Color(0, 128, 0));
		scrollBar.setBounds(594, 156, 17, 200);
		contentPane.add(scrollBar);
		
		JList listBotin = new JList();
		listBotin.setBounds(621, 156, 309, 202);
		contentPane.add(listBotin);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setForeground(new Color(0, 128, 0));
		scrollBar_1.setBackground(new Color(0, 128, 0));
		scrollBar_1.setBounds(926, 158, 17, 200);
		contentPane.add(scrollBar_1);
		
		JLabel lblNewLabel = new JLabel("Objetos disponibles");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(361, 113, 147, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblBotn = new JLabel("Botín");
		lblBotn.setFont(new Font("Arial", Font.PLAIN, 15));
		lblBotn.setBounds(743, 113, 147, 29);
		contentPane.add(lblBotn);
		
		JButton btnNewButton_2 = new JButton("Limpiar lista");
		btnNewButton_2.setBounds(832, 368, 98, 47);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Valor total");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(621, 371, 99, 39);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(718, 372, 99, 39);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
