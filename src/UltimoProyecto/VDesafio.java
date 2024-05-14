package UltimoProyecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.JTree;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class VDesafio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;



	/**
	 * Create the frame.
	 */
	public VDesafio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(242, 111, 216, 66);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(242, 44, 216, 46);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(242, 198, 216, 46);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(76, 375, 57, 46);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel = new JLabel("Buscador");
		lblNewLabel.setBounds(147, 43, 85, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Elige la criatura");
		lblNewLabel_1.setBounds(147, 121, 85, 46);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Puntos de vida");
		lblNewLabel_2.setBounds(147, 197, 85, 46);
		contentPane.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(468, 198, 67, 46);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(242, 322, 216, 158);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(468, 44, 46, 46);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Valor de desafío");
		lblNewLabel_3.setBounds(70, 333, 74, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ataques");
		lblNewLabel_4.setBounds(322, 268, 46, 32);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("Atrás");
		btnNewButton_1.setBounds(632, 506, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("Total");
		lblNewLabel_5.setBounds(486, 162, 35, 32);
		contentPane.add(lblNewLabel_5);
	}
}
