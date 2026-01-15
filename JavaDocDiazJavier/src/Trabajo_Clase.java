
import java.util.Scanner;

    public class Trabajo_Clase {

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int opcion;
        double peso, estatura, IMC, base, altura, area, celsius, fahrenheit,radio;
        do {
            System.out.println("-------MENÚ-------");
            System.out.println("1.  Calcular IMC. ");
            System.out.println("2.  Calcular Área de un rectangulo.");
            System.out.println("3.  Convertir C° a F.");
            System.out.println("4.  Calcular Área de un circulo.");
            System.out.println("5.  Salir.");
            System.out.println("Elige tu opcion:");

            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Haz seleccionado Calcular IMC.");
                    System.out.println("Introduzca su peso en Kg:");
                    peso=sc.nextDouble();
                    System.out.println("Ahora introduzca su estatura en m:");
                    estatura=sc.nextDouble();
                    IMC = peso/(estatura*estatura);
                    System.out.println("Tu IMC es de: "+IMC);
                    break;
                case 2:
                    System.out.println("Haz seleccionado Calcular Área de un rectangulo.");
                    System.out.println("Introduce la base del rectangulo:");
                    base=sc.nextDouble();
                    System.out.println("Introduce la altura del rectangulo:");
                    altura=sc.nextDouble();
                    area=base*altura;
                    System.out.println("El área del rectangulo es de: "+area);
                    break;
                case 3:
                    System.out.println("Haz seleccionado Conversion de C° a F.");
                    System.out.println("Introduce los grados C° deseasdos a convertir:");
                    celsius= sc.nextDouble();
                    fahrenheit=(celsius*1.8)+32;
                    System.out.println("La conversion es de: "+fahrenheit);
                    break;
                case 4:
                    System.out.println("Haz seleccionado Calcular area de un circulo.");
                    System.out.println("Introduce el radio del circulo:");
                    radio= sc.nextDouble();
                    area=3.1416*(radio*radio);
                    System.out.println("El area del circulo es: "+area);
                    break;
                default:
                    System.out.println("Opción no valida...");


            }
        } while(opcion!=5);

        sc.close();
    }

    /**
     * Calcula el Índice de Masa Corporal (IMC) a partir del peso y la estatura.
     * @param peso El peso del usuario en kilogramos.
     * @param estatura La estatura del usuario en metros.
     * @return El valor calculado del IMC.
     */
    public static double calcularIMC(double peso, double estatura) {
        return peso / (estatura * estatura);
    }

    /**
     * Calcula el área de un rectángulo multiplicando su base por su altura.
     * @param base La medida de la base del rectángulo.
     * @param altura La medida de la altura del rectángulo.
     * @return El área total del rectángulo.
     */
    public static double calcularAreaRectangulo(double base, double altura) {
        return base * altura;
    }

    /**
     * Convierte una temperatura dada en grados Celsius a grados Fahrenheit.
     * @param celsius La temperatura en grados Celsius.
     * @return El resultado de la conversión a grados Fahrenheit.
     */
    public static double convertirCelsiusAFahrenheit(double celsius) {
        return (celsius * 1.8) + 32;
    }

    /**
     * Calcula el área de un círculo utilizando el radio proporcionado.
     * @param radio El radio del círculo.
     * @return El área del círculo calculada con PI (3.1416).
     */
    public static double calcularAreaCirculo(double radio) {
        return 3.1416 * (radio * radio);
    }

}

