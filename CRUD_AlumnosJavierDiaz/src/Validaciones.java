public class Validaciones {

    public static boolean validarId(int id) {
        if (id <= 0) {
            System.out.println("Error: el ID debe ser mayor a 0");
            return false;
        }
        return true;
    }

    public static boolean validarNombre(String nombre) {
        if (nombre.trim().isEmpty()) {
            System.out.println("Error: el nombre no puede estar vacio");
            return false;
        }
        return true;
    }

    public static boolean validarPromedio(double promedio) {
        if (promedio < 0 || promedio > 10) {
            System.out.println("Error: el promedio debe estar entre 0 y 10");
            return false;
        }
        return true;
    }

    public static boolean existeId(Alumno[] alumnos, int id) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].id == id) {
                return true;
            }
        }
        return false;
    }
}