package UltimoProyecto;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
    private JList<String> list;

    // Método para establecer la conexión con la base de datos
    private Connection getConnection() throws SQLException {
        // Configuración de la conexión a la base de datos MySQL
    	String bbdd="";
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
        
        // Botón "Generar botín"
        JButton btnNewButton_1 = new JButton("Generar botín");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarBotin(); // Llamar al método para generar el botín cuando se hace clic en el botón
            }
        });
        btnNewButton_1.setBounds(86, 279, 99, 47);
        contentPane.add(btnNewButton_1);
        
        // Lista para mostrar el botín generado
        list = new JList<>();
        list.setBounds(275, 156, 309, 202);
        contentPane.add(list);
    }
    
    // Método para generar el botín
    private void generarBotin() {
        try {
            // Establecer la conexión con la base de datos
            Connection conexión = getConnection();
            
            // Obtener el valor deseado del botín desde el campo de texto
            int valorDeseado = Integer.parseInt(textField.getText());
            
            // Consulta SQL para seleccionar los objetos del botín que sumen el valor deseado
            String consulta = "SELECT nombre_objeto FROM objetos WHERE valor <= ?";
            
            // Preparar la consulta
            PreparedStatement declaración = conexión.prepareStatement(consulta);
            declaración.setInt(1, valorDeseado);
            
            // Ejecutar la consulta
            ResultSet resultado = declaración.executeQuery();
            
            // Lista para almacenar los nombres de los objetos del botín
            List<String> botin = new ArrayList<>();
            
            // Iterar sobre los resultados de la consulta y agregar los nombres de los objetos a la lista
            while (resultado.next()) {
                botin.add(resultado.getString("nombre_objeto"));
            }
            
            // Mostrar el botín generado en la lista
            list.setListData(botin.toArray(new String[0]));
            
            // Cerrar la conexión y liberar recursos
            conexión.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejar cualquier excepción de SQL que pueda ocurrir, por ejemplo, mostrar un mensaje de error
        }
    }
}
