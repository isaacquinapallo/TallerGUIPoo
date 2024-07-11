import javax.swing.*;

public class Estudiante extends JFrame{

    public JPanel mainPanel;
    public JTextField nombreField;
    public JTextField edadField;
    public JTextField matriculaField;
    public JTextArea displayArea1;

    private String nombre;
    private int edad;
    private String matricula;

    //Constructor
    public Estudiante(String nombre, int edad, String matricula) {
        this.nombre = nombre;
        this.edad = edad;
        this.matricula = matricula;
        initializeComponents();
    }

    //Setters y Getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    private void initializeComponents() {
        nombreField = new JTextField("Su nombre es: " + getNombre());
        edadField = new JTextField("Su edad es: " + getEdad());
        matriculaField = new JTextField("Su Matricula es: " + getMatricula());
        displayArea1=new JTextArea("En resumen, su nombre es "+getNombre()+", su edad es "+getEdad()+" y su matricula es"+getMatricula());

        mainPanel = new JPanel();
        mainPanel.add(nombreField);
        mainPanel.add(edadField);
        mainPanel.add(matriculaField);
        mainPanel.add(displayArea1);
    }
}
