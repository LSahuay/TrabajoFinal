package miApp;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.management.loading.PrivateClassLoader;
import javax.swing.DefaultComboBoxModel;

public class VDesafio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_d;
	private Connection conn;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public VDesafio() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField_d = new JTextField();
		textField_d.setColumns(10);
		textField_d.setBounds(76, 422, 57, 46);
		contentPane.add(textField_d);

		JLabel lblNewLabel = new JLabel("Elige el tipo de criatura");
		lblNewLabel.setBounds(55, 92, 177, 46);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Elige la criatura");
		lblNewLabel_1.setBounds(55, 168, 177, 46);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Puntos de vida de la criatura");
		lblNewLabel_2.setBounds(55, 251, 177, 46);
		contentPane.add(lblNewLabel_2);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(242, 345, 216, 158);
		contentPane.add(textArea);

		JLabel lblNewLabel_3 = new JLabel("Valor de desafío");
		lblNewLabel_3.setBounds(70, 380, 74, 32);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Ataques");
		lblNewLabel_4.setBounds(322, 315, 46, 32);
		contentPane.add(lblNewLabel_4);

		JButton btnNewButton_1 = new JButton("Atrás");
		btnNewButton_1.setBounds(632, 506, 85, 21);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal frame = new VentanaPrincipal(toString());
				frame.setVisible(true);
				dispose();

			}
		});

		JLabel lblNewLabel_5 = new JLabel("Total");
		lblNewLabel_5.setBounds(501, 235, 35, 32);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Genera el valor del desafío");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(229, 10, 256, 46);
		contentPane.add(lblNewLabel_6);

		JButton btnNewButton_2 = new JButton("Guardar criatura");
		btnNewButton_2.setBounds(468, 396, 128, 46);
		contentPane.add(btnNewButton_2);
		
		JComboBox<Object> comboBox_1 = new JComboBox<>();
		comboBox_1.setBounds(242, 82, 216, 66);
		JComboBox<Object> comboBox_2 = new JComboBox<>();
		comboBox_2.setBounds(242, 158, 216, 66);
		String item= "";
		String consulta="";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/d&d","root","");
			

		consulta = "SELECT DISTINCT tipo FROM criaturas";
		PreparedStatement statement = conn.prepareStatement(consulta);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			
			item =resultSet.getString("tipo");
			comboBox_1.addItem(item);
				
			}
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		comboBox_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String id = (String) comboBox_1.getSelectedItem();
				String consul = "";
				String item2 = "";
				comboBox_2.removeAllItems();
				
				try {
					conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/d&d","root","");
					
					consul = "SELECT nombre FROM criaturas WHERE tipo = '"+id+"'";
					PreparedStatement statement = conn.prepareStatement(consul);
					ResultSet resultSet = statement.executeQuery(); 
					
					while (resultSet.next()) {
						
						item2 =resultSet.getString("nombre");
						comboBox_2.addItem(item2);
						}
				
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
				
			}
		});
		
		comboBox_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String pv=(String) comboBox_2.getSelectedItem();
				String consul2 = "";
				String item3 = "";
				String item4 = "";
				String item5 = "";
				
				try {
					conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/d&d","root","");
					
					consul2 = "SELECT hp,ataque,vd FROM criaturas WHERE nombre = '"+pv+"'";
					PreparedStatement statement = conn.prepareStatement(consul2);
					ResultSet resultSet = statement.executeQuery(); 
					
					while (resultSet.next()) {
						
						item3 =resultSet.getString("hp");
						textField_1.setText(item3);
						item4=resultSet.getString("ataque");
						textArea.setText(item4);
						item5=resultSet.getString("vd");
						textField_d.setText(item5);
						}
				
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
				
			}
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				guardardatos();
				
			}
		});

		
		contentPane.add(comboBox_1);
		contentPane.add(comboBox_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(246, 258, 212, 32);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboBox.setBounds(501, 264, 46, 21);
		contentPane.add(comboBox);
		
	}

	private void guardardatos() {
			
			BaseDatos bbdd = new BaseDatos();
			bbdd.cerrarDB();
		}
		
}

