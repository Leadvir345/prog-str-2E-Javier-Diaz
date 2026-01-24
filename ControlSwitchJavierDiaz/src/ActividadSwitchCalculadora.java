 import java.util.Scanner;

    public class ActividadSwitchCalculadora {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            menu();

            System.out.print("Ingrese la opción que desea: ");
            int opcion = sc.nextInt();

            System.out.print("Ingrese el valor de a: ");
            double a = sc.nextDouble();

            System.out.print("Ingrese el valor de b: ");
            double b = sc.nextDouble();
            calcular(opcion, a, b);
            sc.close();
        }

        public static void menu() {
            System.out.println("********CALCULADORA**********");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
        }


        public static void calcular(int opcion, double a, double b) {
            System.out.println();

            switch(opcion) {
                case 1:
                    hacerSuma(a, b);
                    break;

                case 2:
                    hacerResta(a, b);
                    break;

                case 3:
                    hacerMultiplicacion(a, b);
                    break;

                case 4:
                    hacerDivision(a, b);
                    break;

                default:
                    System.out.println("Opción invalida");
                    break;
            }
        }


        public static void hacerSuma(double a, double b) {
            double resultado = a + b;
            System.out.println("SUMA");
            System.out.println("Valores ingresados: a = " + a + ", b = " + b);
            System.out.println("Resultado: " + resultado);
        }


        public static void hacerResta(double a, double b) {
            double resultado = a - b;
            System.out.println("Operación: RESTA");
            System.out.println("Valores ingresados: a = " + a + ", b = " + b);
            System.out.println("Resultado: " + a + " - " + b + " = " + resultado);
        }


        public static void hacerMultiplicacion(double a, double b) {
            double resultado = a * b;
            System.out.println("MULTIPLICACIÓN");
            System.out.println("Valores ingresados: a = " + a + ", b = " + b);
            System.out.println("El resultado es: " + a + " × " + b + " = " + resultado);
        }

        public static void hacerDivision(double a, double b) {
            System.out.println("DIVISIÓN");
            System.out.println("Valores ingresados: a = " + a + ", b = " + b);

            if(a==0||b == 0) {
                System.out.println("No se puede dividir entre cero");
            } else {
                double resultado = a / b;
                System.out.println("Resultado de la división: " + resultado);
            }
        }
    }
