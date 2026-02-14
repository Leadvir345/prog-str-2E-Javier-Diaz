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

    public static boolean existeId(Persona[] personas, int id) {
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].id == id) {
                return true;
            }
        }
        return false;
    }
}
