import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Estudiante {
    public JPanel mainPanel;
    private JTextField ingresoNombre;
    private JTextField ingresoEdad;
    private JButton submitButton;
    private JTextField consultaTxt;
    private JButton submitButton1;


    public Estudiante() {
        submitButton.addActionListener(new ActionListener() {
            @lombok.SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = ingresoNombre.getText();
                String edad = ingresoEdad.getText();
                String url = "jdbc:mysql://localhost:3306/dataBaseEstudiantes";
                String user = "root";
                String password = "12345";
                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    // Insertar nombre y edad
                    String insertQuery = "INSERT INTO estudiantes (nombre, edad) VALUES (?, ?)";
                    Statement selectStatement= connection.prepareStatement(insertQuery);
                    ResultSet resultSet = statement.executeQuery();
                    statement.setString(1, nombre);
                    statement.setString(2, edad);
                    statement.executeUpdate();
                    String query="select * from estudiantes where cedula='"+ consultaTxt.getText()+"'";
                    Statement statement = connection.createStatement();


                    while (resultSet.next()) {
                        // Aquí puedes manejar el resultado de la consulta, por ejemplo:
                        System.out.println("Nombre: " + resultSet.getString("nombre"));
                        System.out.println("Edad: " + resultSet.getString("edad"));
                    }
                } catch (SQLException a) {
                    System.out.println(a.getMessage());
                }
            }
        });

        submitButton1.addActionListener(new ActionListener() {
            String nombre = ingresoNombre.getText();
            String edad = ingresoEdad.getText();
            String url = "jdbc:mysql://localhost:3306/dataBaseEstudiantes";
            String user = "root";
            String password = "12345";

        try(Connection connection= DriverManager.getConnection(url,user,password)) {
            String query="select * from estudiantes where cedula='"+ consultaTxt.getText()+"'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String num1 = resultSet.getString("b1");
                double numero1=new Double(num1).doubleValue();
                String num2 = resultSet.getString("b2");
                double numero2=new Double(num2).doubleValue();
                double promedio= numero2+numero1/2;
                System.out.println(resultSet.getString("nombre"));
                labelNombre.setText(resultSet.getString("nombre"));
                System.out.println(resultSet.getString("cedula"));
                labelCedula.setText(resultSet.getString("cedula"));
                System.out.println(resultSet.getString("b1"));
                labelb1.setText(resultSet.getString("b1"));
                System.out.println(resultSet.getString("b2"));
                labelb2.setText(resultSet.getString("b2"));
                System.out.println(promedio);
                labelPromedio.setText(String.valueOf(promedio));
            }
        });
    }
    }
