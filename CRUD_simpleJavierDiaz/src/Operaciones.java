import java.util.Scanner;

public class Operaciones {

    public static void alta(Persona[] personas, Scanner sc) {
        System.out.print("Ingrese ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (!Validaciones.validarId(id)) {
            return;
        }

        if (Validaciones.existeId(personas, id)) {
            System.out.println("Error: el ID ya existe");
            return;
        }

        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();

        if (!Validaciones.validarNombre(nombre)) {
            return;
        }

        boolean agregado = false;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == null) {
                personas[i] = new Persona();
                personas[i].id = id;
                personas[i].nombre = nombre;
                personas[i].activa = true;
                System.out.println("Persona agregada");
                agregado = true;
                break;
            }
        }

        if (!agregado) {
            System.out.println("No hay espacio");
        }
    }

    public static void buscarPorId(Persona[] personas, Scanner sc) {
        System.out.print("Ingrese ID a buscar: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (!Validaciones.validarId(id)) {
            return;
        }

        boolean encontrado = false;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].id == id && personas[i].activa) {
                System.out.println("ID: " + personas[i].id);
                System.out.println("Nombre: " + personas[i].nombre);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontro");
        }
    }

    public static void bajaLogica(Persona[] personas, Scanner sc) {
        System.out.print("Ingrese ID a dar de baja: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (!Validaciones.validarId(id)) {
            return;
        }

        boolean encontrado = false;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].id == id) {
                personas[i].activa = false;
                System.out.println("Persona dada de baja");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontro");
        }
    }

    public static void listarActivas(Persona[] personas) {
        System.out.println("******Personas Activas ***********");
        boolean hay = false;

        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].activa) {
                System.out.println("ID: " + personas[i].id + " - Nombre: " + personas[i].nombre);
                hay = true;
            }
        }

        if (!hay) {
            System.out.println("No hay personas activas");
        }
    }

    public static void actualizarNombre(Persona[] personas, Scanner sc) {
        System.out.print("Ingrese ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (!Validaciones.validarId(id)) {
            return;
        }

        boolean encontrado = false;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].id == id && personas[i].activa) {
                System.out.print("Ingrese nuevo nombre: ");
                String nombre = sc.nextLine();

                if (!Validaciones.validarNombre(nombre)) {
                    return;
                }

                personas[i].nombre = nombre;
                System.out.println("Nombre actualizado");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontro o no esta activa");
        }
    }
}