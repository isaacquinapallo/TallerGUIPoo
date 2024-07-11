import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la edad del estudiante: ");
        int edad = scanner.nextInt();

        scanner.nextLine();
        System.out.print("Ingrese la matrícula del estudiante(Ej. POLINACIONAL23454SDF): ");
        String matricula = scanner.nextLine();

        Estudiante estudiante = new Estudiante(nombre, edad, matricula);
        estudiante.mostrarInfo();
        scanner.close();
    }
}
