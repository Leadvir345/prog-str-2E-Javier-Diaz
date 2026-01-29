import java.util.Random;
import java.util.Scanner;

public class juego {

    static int contFueraRango = 0;
    static int contNoNum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int min=1;
        int max=100;
        int maxIntentos=7;

        int secreto=rand.nextInt(max-min+1)+min;
        int intentos=0;
        boolean gano=false;

        mensajeBienvenida(min, max, maxIntentos);

        while(intentos < maxIntentos && !gano) {
            System.out.print("Intento "+(intentos + 1)+": ");

            int numero=0;
            boolean esValido=false;

            while(!esValido) {
                if(sc.hasNextInt()) {
                    numero=sc.nextInt();

                    if(numero >=min && numero<=max) {
                        esValido = true;
                    }else {
                        System.out.println("Fuera de rango. Debe ser entre " + min + " y " + max);
                        System.out.print("Intento "+(intentos + 1)+": ");
                        contFueraRango++;
                    }
                } else {
                    System.out.println("Eso no es un numero valido");
                    System.out.print("Intento "+(intentos + 1)+": ");
                    sc.next();
                    contNoNum++;
                }
            }

            intentos++;

            if(numero == secreto) {
                mensajeGanador(intentos);
                gano = true;
            } else if(numero < secreto) {
                System.out.println("El numero es mayor");
            } else {
                System.out.println("El numero es menor");
            }
        }
        if(!gano) {
            mensajePerdedor(secreto);
        }

        mostrarEstadisticas();
        sc.close();
    }

    public static void mensajeBienvenida(int min, int max, int intentos) {
        System.out.println("*****Adivina el numero*****");
        System.out.println("Piensa un numero del " + min + " al " + max);
        System.out.println("Tienes " + intentos + " intentos");
    }

    public static void mensajeGanador(int intentos) {
        System.out.println("Ganaste");
        System.out.println("Adivinaste el numero en " + intentos + " intentos");
    }

    public static void mensajePerdedor(int numeroSecreto) {
        System.out.println("Perdiste");
        System.out.println("El numero era: " + numeroSecreto);
    }

    public static void mostrarEstadisticas() {
        System.out.println("Resumen");
        System.out.println("Errores fuera de rango: " + contFueraRango);
        System.out.println("Errores por no poner numero: " + contNoNum);
        System.out.println("Total de errores: " + (contFueraRango + contNoNum));
    }
}