import java.util.Scanner;

public class ServicioGrado {

    public static String leerTextoNoVacio(Scanner sc, String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = sc.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("El texto no puede estar vacío. Intente de nuevo.");
            }
        } while (texto.isEmpty());
        return texto;
    }

    public static double leerDoubleEnRango(Scanner sc, String mensaje, double min, double max) {
        double numero;
        while (true) {
            try {
                System.out.print(mensaje);
                numero = Double.parseDouble(sc.nextLine());

                if (numero >= min && numero <= max) {
                    return numero;
                } else {
                    System.out.println("El valor debe estar entre " + min + " y " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número válido.");
            }
        }
    }


    public static int leerIntEnRango(Scanner sc, String mensaje, int min, int max) {
        int numero;
        while (true) {
            try {
                System.out.print(mensaje);
                numero = Integer.parseInt(sc.nextLine());

                if (numero >= min && numero <= max) {
                    return numero;
                } else {
                    System.out.println("El valor debe estar entre " + min + " y " + max);
                }
            } catch (NumberFormatException _) {
                System.out.println("Por favor ingrese un número entero válido.");
            }
        }
    }

    public static boolean leerBoolean(Scanner sc, String mensaje) {
        String respuesta;
        while (true) {
            System.out.print(mensaje);
            respuesta = sc.nextLine().trim().toLowerCase();

            if (respuesta.equals("true") || respuesta.equals("si") || respuesta.equals("sí") || respuesta.equals("s")) {
                return true;
            } else if (respuesta.equals("false") || respuesta.equals("no") || respuesta.equals("n")) {
                return false;
            } else {
                System.out.println("Por favor ingrese si o no (también puede usar true/false).");
            }
        }
    }


    public static void imprimirReporte(String nombre, double p1, double p2, double p3,
                                       double promedio, int asistencia, boolean entregoProyecto,
                                       double calificacionFinal, String estado) {
        System.out.println("          REPORTE FINAL DE CALIFICACIONES");

        System.out.println("DATOS DEL ALUMNO:");
        System.out.println("   Nombre: " + nombre);

        System.out.println("CALIFICACIONES PARCIALES:");
        System.out.printf("   Parcial 1: %.2f%n", p1);
        System.out.printf("   Parcial 2: %.2f%n", p2);
        System.out.printf("   Parcial 3: %.2f%n", p3);
        System.out.printf("   Promedio de parciales: %.2f%n", promedio);

        System.out.println("ASISTENCIA Y PROYECTO:");
        System.out.println("   Asistencia: " + asistencia);
        System.out.println("   Entregó proyecto: " + (entregoProyecto ? "Sí " : "No "));

        System.out.println("RESULTADO FINAL:");
        System.out.printf("   Calificación final: %.2f%n", calificacionFinal);
        System.out.println("   Estado: " + estado);


        if (estado.equals("APROBADO")) {
            System.out.println("¡FELICIDADES! Has aprobado el curso.");
        } else {
            System.out.println(" Lo sentimos, no has aprobado.");
            System.out.println("   Motivo: " + estado);
        }
    }
}
