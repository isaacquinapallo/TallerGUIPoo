import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Estudiante {
    public JPanel mainPanel;
    private JTextField ingresoNombre;
    private JTextField ingresoEdad;
    private JTextField consultaTxt;
    private JButton submitButton;
    private JButton submitButton1;
    private JLabel labelNombre;
    private JLabel labelEdad;
    private JLabel labelMatricula;

    public Estudiante() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = ingresoNombre.getText();
                String edad = ingresoEdad.getText();
                String url = "jdbc:mysql://localhost:3306/dataBaseEstudiantes";
                String user = "root";
                String password = "12345";
                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    String insertQuery = "INSERT INTO estudiantes (nombre, edad) VALUES (?, ?)";
                    PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
                    insertStatement.setString(1, nombre);
                    insertStatement.setString(2, edad);
                    insertStatement.executeUpdate();
                } catch (SQLException a) {
                    System.out.println(a.getMessage());
                }
            }
        });

        submitButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/dataBaseEstudiantes";
                String user = "root";
                String password = "12345";
                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    String query = "SELECT * FROM estudiantes WHERE matricula = ?";
                    PreparedStatement selectStatement = connection.prepareStatement(query);
                    selectStatement.setString(1, consultaTxt.getText());
                    ResultSet resultSet = selectStatement.executeQuery();
                    while (resultSet.next()) {
                        labelNombre.setText(resultSet.getString("nombre"));
                        labelEdad.setText(resultSet.getString("edad"));
                        labelMatricula.setText(resultSet.getString("matricula"));
                    }
                } catch (SQLException a) {
                    System.out.println(a.getMessage());
                }
            }
        });
    }
}
