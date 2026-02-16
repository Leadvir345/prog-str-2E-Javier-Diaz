public class Reportes {

    public static void mostrarReportes(Alumno[] alumnos) {
        System.out.println("******REPORTES***********");

        int totalActivos = 0;
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].activo) {
                totalActivos++;
            }
        }

        if (totalActivos == 0) {
            System.out.println("No hay alumnos activos");
            return;
        }

        double suma = 0;
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].activo) {
                suma = suma + alumnos[i].promedio;
            }
        }
        double promedioGeneral = suma / totalActivos;
        System.out.println("1) Promedio general: " + promedioGeneral);

        Alumno mayor = null;
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].activo) {
                if (mayor == null || alumnos[i].promedio > mayor.promedio) {
                    mayor = alumnos[i];
                }
            }
        }
        if (mayor != null) {
            System.out.println("2) Alumno con mayor promedio:");
            System.out.println("   ID: " + mayor.id);
            System.out.println("   Nombre: " + mayor.nombre);
            System.out.println("   Promedio: " + mayor.promedio);
        }

        Alumno menor = null;
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].activo) {
                if (menor == null || alumnos[i].promedio < menor.promedio) {
                    menor = alumnos[i];
                }
            }
        }
        if (menor != null) {
            System.out.println("3) Alumno con menor promedio:");
            System.out.println("   ID: " + menor.id);
            System.out.println("   Nombre: " + menor.nombre);
            System.out.println("   Promedio: " + menor.promedio);
        }

        int contador = 0;
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].activo && alumnos[i].promedio >= 8.0) {
                contador++;
            }
        }
        System.out.println("4) Alumnos con promedio >= 8.0: " + contador);
    }
}