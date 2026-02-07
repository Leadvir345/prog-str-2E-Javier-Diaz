import java.util.Scanner;

public static class App {


public static double calcularPromedio(double p1, double p2, double p3) {
    return (p1 + p2 + p3) / 3.0;
}

public static double calcularFinal(double promedio, int asistencia) {
    return (promedio * 0.7) + (asistencia * 0.3);
}


public static String determinarEstado(double calificacionFinal, int asistencia, boolean entregoProyecto) {
    if (asistencia < 80) {
        return "REPROBADO por asistencia";
    }

    if (!entregoProyecto) {
        return "REPROBADO por proyecto";
    }

    if (calificacionFinal >= 70) {
        return "APROBADO";
    } else {
        return "REPROBADO por calificación";
    }
}
}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ServicioGrado gradeService = new ServicioGrado();
    System.out.println("*******SISTEMA DE EVALUACIÓN DE CALIFICACIONES*******");

    String nombre = ServicioGrado.leerTextoNoVacio(sc, "Ingrese el nombre del alumno: ");


    System.out.println("CALIFICACIONES PARCIALES (0-100):");
    double parcial1 = ServicioGrado.leerDoubleEnRango(sc, "  Parcial 1: ", 0, 100);
    double parcial2 = ServicioGrado.leerDoubleEnRango(sc, "  Parcial 2: ", 0, 100);
    double parcial3 = ServicioGrado.leerDoubleEnRango(sc, "  Parcial 3: ", 0, 100);

    System.out.println(" ASISTENCIA:");
    int asistencia = ServicioGrado.leerIntEnRango(sc, "  Porcentaje de asistencia (0-100): ", 0, 100);


    System.out.println(" PROYECTO:");
    boolean entregoProyecto = ServicioGrado.leerBoolean(sc, "  ¿Entregó el proyecto?: ");

    double promedioParciales = App.calcularPromedio(parcial1, parcial2, parcial3);


    double calificacionFinal = App.calcularFinal(promedioParciales, asistencia);

    String estado = App.determinarEstado(calificacionFinal, asistencia, entregoProyecto);

    ServicioGrado.imprimirReporte(nombre, parcial1, parcial2, parcial3, promedioParciales,
            asistencia, entregoProyecto, calificacionFinal, estado);
    sc.close();
}

