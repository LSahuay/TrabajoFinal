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
import javax.swing.ImageIcon;
import java.awt.Color;

/**
 * This class represents the window for managing challenges in a game.
 */
public class VDesafio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_d;
	private Connection conn;
	private JTextField textField_1;
	private String usuario;

    /**
     * Constructs a new VDesafio window.
     * @param nombreUsuario The name of the user.
     */
	public VDesafio(String nombreUsuario) {
		setTitle("DUNGEONS & DRAGONS");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField_d = new JTextField();
		textField_d.setBackground(new Color(255, 255, 255));
		textField_d.setColumns(10);
		textField_d.setBounds(90, 422, 57, 46);
		contentPane.add(textField_d);

		JLabel lblNewLabel = new JLabel("Elige el tipo de criatura");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
		lblNewLabel.setBounds(55, 92, 486, 46);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Elige la criatura");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
		lblNewLabel_1.setBounds(55, 168, 486, 46);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Puntos de vida de la criatura");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
		lblNewLabel_2.setBounds(55, 251, 191, 46);
		contentPane.add(lblNewLabel_2);

		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setBounds(242, 345, 216, 158);
		contentPane.add(textArea);

		JLabel lblNewLabel_3 = new JLabel("Valor de desafío");
		lblNewLabel_3.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(70, 380, 128, 32);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Ataques");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
		lblNewLabel_4.setBounds(322, 315, 85, 32);
		contentPane.add(lblNewLabel_4);

		JButton btnNewButton_1 = new JButton("Atrás");
		btnNewButton_1.setBounds(618, 501, 85, 21);
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
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
		lblNewLabel_5.setBounds(501, 235, 40, 32);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Genera el valor del desafío");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Bookman Old Style", Font.BOLD, 25));
		lblNewLabel_6.setBounds(163, 21, 380, 46);
		contentPane.add(lblNewLabel_6);

		JButton btnNewButton_2 = new JButton("Guardar criatura");
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.setBounds(468, 396, 128, 46);
		contentPane.add(btnNewButton_2);
		
		JComboBox<Object> comboBox_1 = new JComboBox<>();
		comboBox_1.setBackground(Color.LIGHT_GRAY);
		comboBox_1.setBounds(242, 82, 216, 66);
		JComboBox<Object> comboBox_2 = new JComboBox<>();
		comboBox_2.setBackground(Color.LIGHT_GRAY);
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
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setBounds(246, 258, 212, 32);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "0.75", "0.50", "0.25"}));
		comboBox.setBounds(495, 264, 46, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\luisj\\Desktop\\img_proyecto_programacion\\desafios.jpg"));
		lblNewLabel_7.setBounds(0, 0, 717, 554);
		contentPane.add(lblNewLabel_7);
		
	}

    /**
     * Saves the data of the creature.
     */
	private void guardardatos() {
			
			BaseDatos bbdd = new BaseDatos();
			bbdd.cerrarDB();
		}
	
    /**
     * Sets the username.
     * @param nombreUsuario The name of the user.
     * @return The username.
     */
	public String setUsuario(String nombreUsuario) {
		this.usuario=nombreUsuario;
		
		return usuario;
	
		
	}
		
}

