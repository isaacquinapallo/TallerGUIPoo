import javax.swing.*;

//3.- Implememtar un programa que tenga una pantalla para insertar datos de estudiante y una pantalla para buscar estudiante por cedula.
//El deber es individual.
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Estudiantes Registro y Busqueda");
        frame.setContentPane(new Estudiante().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}