import javax.swing.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese su edad: ");
        int edad = sc.nextInt();
        sc.nextLine();//Consume el salto de linea pendiente
        System.out.println("Ingrese su Matricula(Ej. POLINACIONAL23454SDF): ");
        String matricula = sc.nextLine();

        JFrame frame = new JFrame("Registro de Estudiantes"); //Intanciado
        frame.setContentPane(new Estudiante(nombre,edad,matricula).mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar procesos
        frame.setSize(20000, 1000);
        frame.pack();
        frame.setVisible(true);

    }
}