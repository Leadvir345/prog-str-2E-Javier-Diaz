import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Alumno[] alumnos = new Alumno[25];
        int opcion;

        do {
            Menu.mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
                Operaciones.alta(alumnos, sc);
            } else if (opcion == 2) {
                Operaciones.buscarPorId(alumnos, sc);
            } else if (opcion == 3) {
                Operaciones.bajaLogica(alumnos, sc);
            } else if (opcion == 4) {
                Operaciones.listarActivos(alumnos);
            } else if (opcion == 5) {
                Operaciones.actualizarPromedio(alumnos, sc);
            } else if (opcion == 6) {
                Reportes.mostrarReportes(alumnos);
            } else if (opcion == 0) {
                System.out.println("Adios");
            } else {
                System.out.println("Opcion invalida");
            }

        } while (opcion != 0);

        sc.close();
    }
}

