package miApp;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VTesoros extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JList<String> listItems;
    private JList<String> listBotin;
    private JTextField textField_1;

    // Método para establecer la conexión con la base de datos
    private Connection getConnection() throws SQLException {
        // Configuración de la conexión a la base de datos MySQL
        String bbdd = "d&d";
        String url = "jdbc:mysql://localhost:3306/" + bbdd;
        String usuario = "root";
        String contraseña = "";

        // Intentar establecer la conexión
        Connection conexión = DriverManager.getConnection(url, usuario, contraseña);
        return conexión;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Crear e iniciar la ventana de la aplicación
                    VTesoros frame = new VTesoros();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public VTesoros() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 975, 557);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        // Etiqueta de título
        JLabel lblTitle = new JLabel("Generador de botín");
        lblTitle.setFont(new Font("Arial", Font.PLAIN, 25));
        lblTitle.setBounds(314, 60, 223, 65);
        contentPane.add(lblTitle);
        
        // Etiqueta para introducir el valor deseado del botín
        JLabel lblValue = new JLabel("Introduce el valor deseado del botín");
        lblValue.setFont(new Font("Arial", Font.PLAIN, 15));
        lblValue.setBounds(21, 196, 254, 39);
        contentPane.add(lblValue);
        
        // Campo de texto para introducir el valor deseado del botín
        textField = new JTextField();
        textField.setBounds(57, 230, 163, 39);
        contentPane.add(textField);
        textField.setColumns(10);
        
        // Botón "Atrás"
        JButton btnNewButton = new JButton("Atrás");
        btnNewButton.setBounds(87, 489, 85, 21);
        contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal frame = new VentanaPrincipal(toString());
				frame.setVisible(true);
				dispose();

			}
		});

        
        // Botón "Generar botín"
        JButton btnNewButton_1 = new JButton("Generar botín");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarBotin(); // Llamar al método para generar el botín cuando se hace clic en el botón
            }
        });
        btnNewButton_1.setBounds(86, 279, 99, 47);
        contentPane.add(btnNewButton_1);
        
        // Lista para mostrar todos los items disponibles
        listItems = new JList<>();
        JScrollPane scrollPaneItems = new JScrollPane(listItems);
        scrollPaneItems.setBounds(277, 156, 309, 202);
        contentPane.add(scrollPaneItems);
        
        // Scrollbar horizontal para la lista de objetos disponibles
        JScrollBar scrollBarItems = new JScrollBar(JScrollBar.HORIZONTAL);
        scrollBarItems.setBounds(277, 358, 309, 17);
        scrollPaneItems.setHorizontalScrollBar(scrollBarItems);
        
        // Lista para mostrar los objetos disponibles
        listBotin = new JList<>();
        JScrollPane scrollPaneBotin = new JScrollPane(listBotin);
        scrollPaneBotin.setBounds(621, 156, 309, 202);
        contentPane.add(scrollPaneBotin);
        
        // Scrollbar horizontal para la lista de botín
        JScrollBar scrollBarBotin = new JScrollBar(JScrollBar.HORIZONTAL);
        scrollBarBotin.setBounds(621, 358, 309, 17);
        scrollPaneBotin.setHorizontalScrollBar(scrollBarBotin);
        
        JLabel lblNewLabel = new JLabel("Objetos disponibles");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        lblNewLabel.setBounds(361, 113, 147, 29);
        contentPane.add(lblNewLabel);
        
        JLabel lblBotn = new JLabel("Botín");
        lblBotn.setFont(new Font("Arial", Font.PLAIN, 15));
        lblBotn.setBounds(743, 113, 147, 29);
        contentPane.add(lblBotn);
        
        JButton btnNewButton_2 = new JButton("Limpiar lista");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarLista(); // Llamar al método para limpiar la lista y el valor total cuando se hace clic en el botón
            }
        });
        btnNewButton_2.setBounds(832, 368, 98, 47);
        contentPane.add(btnNewButton_2);
        
        JLabel lblNewLabel_1 = new JLabel("Valor total");
        lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(621, 371, 99, 39);
        contentPane.add(lblNewLabel_1);
        
        textField_1 = new JTextField(); // Cambiado textField_1 a variable de instancia
        textField_1.setEditable(false); // Impedir que el usuario pueda escribir en el campo de texto
        textField_1.setBounds(718, 372, 99, 39);
        textField_1.setBackground(Color.WHITE); // Fondo blanco
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        // Llamar al método para mostrar los objetos disponibles al iniciar la ventana
        mostrarObjetosDisponibles();
    }
    
    // Método para mostrar los objetos disponibles
    private void mostrarObjetosDisponibles() {
        try {
            // Establecer la conexión con la base de datos
            Connection conexión = getConnection();
            
            // Consulta SQL para seleccionar todos los objetos disponibles
            String consulta = "SELECT nombre, tipo, coste, peso FROM items";
            
            // Preparar la consulta
            PreparedStatement declaración = conexión.prepareStatement(consulta);
            
            // Ejecutar la consulta
            ResultSet resultado = declaración.executeQuery();
            
            // Lista para almacenar los nombres de los objetos disponibles
            List<String> objetosDisponibles = new ArrayList<>();
            
            // Iterar sobre los resultados de la consulta y agregar los detalles de los objetos a la lista
            while (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String tipo = resultado.getString("tipo");
                int coste = resultado.getInt("coste");
                int peso = resultado.getInt("peso");
                String detalles = nombre + " - " + tipo + " - Coste: " + coste + " - Peso: " + peso;
                objetosDisponibles.add(detalles);
                System.out.println("Detalles del objeto: " + detalles); // Imprimir los detalles del objeto para diagnóstico
            }
            
            // Imprimir el tamaño de la lista de objetos disponibles para verificar si se están recuperando datos
            System.out.println("Tamaño de la lista de objetos disponibles: " + objetosDisponibles.size());
            
            // Mostrar los objetos disponibles en la lista correspondiente
            listItems.setListData(objetosDisponibles.toArray(new String[0]));
            
            // Cerrar la conexión y liberar recursos
            conexión.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejar cualquier excepción de SQL que pueda ocurrir, por ejemplo, mostrar un mensaje de error
        }
    }
    
    // Método para generar el botín
    private void generarBotin() {
        try {
            // Establecer la conexión con la base de datos
            Connection conexión = getConnection();
            
            // Obtener el valor deseado del botín desde el campo de texto
            int valorDeseado = Integer.parseInt(textField.getText());
            
            // Consulta SQL para seleccionar los objetos del botín que tengan el mismo valor o menor que el valor deseado
            String consulta = "SELECT nombre, tipo, coste, peso FROM items WHERE coste <= ?";
            
            // Preparar la consulta
            PreparedStatement declaración = conexión.prepareStatement(consulta);
            declaración.setInt(1, valorDeseado);
            
            // Ejecutar la consulta
            ResultSet resultado = declaración.executeQuery();
            
            // Lista para almacenar los detalles de los objetos del botín
            List<String> botin = new ArrayList<>();
            // Variable para almacenar el valor total del botín
            int valorTotalBotin = 0;
            
            // Iterar sobre los resultados de la consulta y agregar los detalles de los objetos a la lista
            while (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String tipo = resultado.getString("tipo");
                int coste = resultado.getInt("coste");
                int peso = resultado.getInt("peso");
                String detalles = nombre + " - " + tipo + " - Coste: " + coste + " - Peso: " + peso;
                botin.add(detalles);
                valorTotalBotin += coste; // Sumar el coste del objeto al valor total del botín
            }
            
            // Mostrar el botín generado en la lista
            listBotin.setListData(botin.toArray(new String[0]));
            
            // Mostrar el valor total del botín en el campo correspondiente
            textField_1.setText(String.valueOf(valorTotalBotin));
            
            // Cerrar la conexión y liberar recursos
            conexión.close();
        } catch (SQLException | NumberFormatException ex) {
            ex.printStackTrace();
            // Manejar cualquier excepción de SQL que pueda ocurrir, por ejemplo, mostrar un mensaje de error
        }
    }
    
    // Método para limpiar la lista y el valor total
    private void limpiarLista() {
        // Limpiar la lista de botín y el campo de valor total
        listBotin.setListData(new String[0]);
        textField_1.setText("");
    }
}

