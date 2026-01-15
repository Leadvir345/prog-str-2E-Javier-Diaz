
import java.util.Scanner;

    public class Main {

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int opcion;
        double peso, estatura, IMC;
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
                    IMC = peso*
            }
        }

    }


}

