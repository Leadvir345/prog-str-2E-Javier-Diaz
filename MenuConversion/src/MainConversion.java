import java.util.Scanner;

public class MainConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int contadorCaF = 0;
        int contadorFaC = 0;
        int contadorKmaMi = 0;
        int contadorMiaKm = 0;
        int totalConver = 0;
        int opcion;
        do {
            menu();
            while (true) {
                System.out.print("Ingrese la opción deseada: ");
                if (sc.hasNextInt()) {
                    opcion = sc.nextInt();
                    if (opcion >= 1 && opcion <= 5) {
                        break;
                    } else {
                        System.out.println(" Opción inválida. Debe ser entre 1 y 5.");
                    }
                } else {
                    System.out.println(" Debe ingresar un número.");
                    sc.next();
                }
            }
            if (opcion == 5) {
                break;
            }
            double valor = 0;
            while (true) {
                System.out.print("Ingrese el valor a convertir: ");
                if (sc.hasNextDouble()) {
                    valor = sc.nextDouble();
                    break;
                } else {
                    System.out.println("Debe ingresar un número válido.");
                    sc.next();
                }
            }
            switch (opcion) {
                case 1:
                    ConvertirCaF(valor);
                    contadorCaF++;
                    break;
                case 2:
                    ConvertirFaC(valor);
                    contadorFaC++;
                    break;
                case 3:
                    ConvertirKmaMi(valor);
                    contadorKmaMi++;
                    break;
                case 4:
                    ConvertirMiaKm(valor);
                    contadorMiaKm++;
                    break;
            }
            totalConver++;
            System.out.println();
        } while (opcion != 5);

        System.out.println("RESUMEN");
        System.out.println("Total de conversiones: " + totalConver);
        System.out.println("°C a F: " + contadorCaF);
        System.out.println("F a °C: " + contadorFaC);
        System.out.println("Km a Millas: " + contadorKmaMi);
        System.out.println("Millas a Km: " + contadorMiaKm);
        sc.close();
    }

    public static void menu() {
        System.out.println("********CONVERTIDOR**********");
        System.out.println("1. °C a F");
        System.out.println("2. F a °C");
        System.out.println("3. Km a Millas");
        System.out.println("4. Millas a Km");
        System.out.println("5. Salir");
    }


    public static void ConvertirCaF(double a) {
        double resultado = (1.8 * a) + 32;
        System.out.println("Celsius a Fahrenheit");
        System.out.println("Conversion: " + resultado);
    }

    public static void ConvertirFaC(double a) {
        double resultado = (a - 32) / 1.8;
        System.out.println("Fahrenheit a Celsius");
        System.out.printf("Conversion: %.2f\n", resultado);
    }

    public static void ConvertirKmaMi(double a) {
        double resultado = 0.621371 * a;
        System.out.println("Kilometros a Millas");
        System.out.printf("Conversion: %.2f\n", resultado);
    }

    public static void ConvertirMiaKm(double a) {
        double resultado = 1.60934 * a;
        System.out.println("Millas a Kilometros");
        System.out.printf("Conversion: %.2f\n", resultado);
    }
}