import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Persona[] personas = new Persona[20];
        int opcion;

        do {
            Menu.mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
                Operaciones.alta(personas, sc);
            } else if (opcion == 2) {
                Operaciones.buscarPorId(personas, sc);
            } else if (opcion == 3) {
                Operaciones.bajaLogica(personas, sc);
            } else if (opcion == 4) {
                Operaciones.listarActivas(personas);
            } else if (opcion == 5) {
                Operaciones.actualizarNombre(personas, sc);
            } else if (opcion != 0) {
                System.out.println("Opcion invalida");
            }

        } while (opcion != 0);

        System.out.println("Adios");
        sc.close();
    }
}