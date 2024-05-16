package UltimoProyecto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

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
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 975, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("Generador de botín");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setBackground(new Color(0, 0, 0, 150));
		lblTitle.setFont(new Font("Arial", Font.PLAIN, 25));
		lblTitle.setBounds(361, 38, 223, 65);
		lblTitle.setOpaque(true);
		contentPane.add(lblTitle);

		JLabel lblValue = new JLabel("Introduce el valor deseado del botín");
		lblValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblValue.setForeground(new Color(255, 255, 255));
		lblValue.setBackground(new Color(0, 0, 0, 150));
		lblValue.setFont(new Font("Arial", Font.PLAIN, 15));
		lblValue.setBounds(10, 197, 253, 39);
		lblValue.setOpaque(true);
		contentPane.add(lblValue);

		textField = new JTextField();
		textField.setBounds(57, 240, 163, 39);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Atrás");
		btnNewButton.setBounds(866, 489, 85, 21);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal frame = new VentanaPrincipal(toString());
				frame.setVisible(true);
				dispose();

			}
		});

		JButton btnNewButton_1 = new JButton("Generar botín");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(176, 0, 0));
		btnNewButton_1.setBounds(81, 289, 118, 47);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("Objetos disponibles");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(0, 0, 0, 150));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(345, 123, 163, 29);
		lblNewLabel.setOpaque(true);
		contentPane.add(lblNewLabel);

		JLabel lblBotn = new JLabel("Botín");
		lblBotn.setHorizontalAlignment(SwingConstants.CENTER);
		lblBotn.setBackground(new Color(0, 0, 0, 150));
		lblBotn.setForeground(new Color(255, 255, 255));
		lblBotn.setFont(new Font("Arial", Font.PLAIN, 15));
		lblBotn.setBounds(705, 123, 147, 29);
		lblBotn.setOpaque(true);
		contentPane.add(lblBotn);

		JButton btnNewButton_2 = new JButton("Limpiar lista");
		btnNewButton_2.setBounds(832, 378, 98, 47);
		contentPane.add(btnNewButton_2);

		JLabel lblNewLabel_1 = new JLabel("Valor total");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(0, 0, 0, 150));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(609, 381, 99, 39);
		lblNewLabel_1.setOpaque(true);
		contentPane.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(718, 382, 99, 39);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JScrollPane scrollPaneDisp = new JScrollPane();
		scrollPaneDisp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneDisp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneDisp.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPaneDisp.setBounds(273, 164, 311, 204);
		
		
				JList listDisponibles = new JList();
				scrollPaneDisp.setViewportView(listDisponibles);
				contentPane.add(scrollPaneDisp);
				
				JScrollPane scrollPaneBotin = new JScrollPane();
				scrollPaneBotin.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				scrollPaneBotin.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				scrollPaneBotin.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
				scrollPaneBotin.setBounds(621, 166, 309, 202);
				contentPane.add(scrollPaneBotin);
				
						JList listBotin = new JList();
						scrollPaneBotin.setViewportView(listBotin);
						
						JLabel lblFondo = new JLabel("New label");
						lblFondo.setIcon(new ImageIcon("C:\\Users\\jose_\\Desktop\\treasure.jpg"));
						lblFondo.setBounds(0, 0, 961, 520);
						contentPane.add(lblFondo);
	}
}
