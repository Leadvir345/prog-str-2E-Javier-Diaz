import java.util.Scanner;

public class Operaciones {

    public static void alta(Alumno[] alumnos, Scanner sc) {
        System.out.print("Ingrese ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (!Validaciones.validarId(id)) {
            return;
        }

        if (Validaciones.existeId(alumnos, id)) {
            System.out.println("Error: el ID ya existe");
            return;
        }

        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();

        if (!Validaciones.validarNombre(nombre)) {
            return;
        }

        System.out.print("Ingrese promedio: ");
        double promedio = sc.nextDouble();
        sc.nextLine();

        if (!Validaciones.validarPromedio(promedio)) {
            return;
        }

        boolean agregado = false;
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) {
                alumnos[i] = new Alumno();
                alumnos[i].id = id;
                alumnos[i].nombre = nombre;
                alumnos[i].promedio = promedio;
                alumnos[i].activo = true;
                System.out.println("Alumno agregado");
                agregado = true;
                break;
            }
        }

        if (!agregado) {
            System.out.println("No hay espacio");
        }
    }

    public static void buscarPorId(Alumno[] alumnos, Scanner sc) {
        System.out.print("Ingrese ID a buscar: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (!Validaciones.validarId(id)) {
            return;
        }

        boolean encontrado = false;
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].id == id && alumnos[i].activo) {
                System.out.println("ID: " + alumnos[i].id);
                System.out.println("Nombre: " + alumnos[i].nombre);
                System.out.println("Promedio: " + alumnos[i].promedio);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontro");
        }
    }

    public static void bajaLogica(Alumno[] alumnos, Scanner sc) {
        System.out.print("Ingrese ID a dar de baja: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (!Validaciones.validarId(id)) {
            return;
        }

        boolean encontrado = false;
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].id == id) {
                alumnos[i].activo = false;
                System.out.println("Alumno dado de baja");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontro");
        }
    }

    public static void listarActivos(Alumno[] alumnos) {
        System.out.println("******Alumnos Activos ***********");
        boolean hay = false;

        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].activo) {
                System.out.println("ID: " + alumnos[i].id + " - Nombre: " + alumnos[i].nombre + " - Promedio: " + alumnos[i].promedio);
                hay = true;
            }
        }

        if (!hay) {
            System.out.println("No hay alumnos activos");
        }
    }

    public static void actualizarPromedio(Alumno[] alumnos, Scanner sc) {
        System.out.print("Ingrese ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (!Validaciones.validarId(id)) {
            return;
        }

        boolean encontrado = false;
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].id == id && alumnos[i].activo) {
                System.out.print("Ingrese nuevo promedio: ");
                double promedio = sc.nextDouble();
                sc.nextLine();

                if (!Validaciones.validarPromedio(promedio)) {
                    return;
                }

                alumnos[i].promedio = promedio;
                System.out.println("Promedio actualizado");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontro o no esta activo");
        }
    }
}
