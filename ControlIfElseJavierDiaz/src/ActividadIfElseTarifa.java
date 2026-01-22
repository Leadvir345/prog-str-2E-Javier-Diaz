import java.util.Scanner;

public class ActividadIfElseTarifa {
    public static void main(String[] args){
        int edad,tarifa,SeraEstudiante;
        boolean esEstudiante=false;
        Scanner sc=new Scanner(System.in);

        System.out.println("Ingrese su edad: ");
        edad=sc.nextInt();
        if (edad<0 || edad>120){
            System.out.println("Edad invalidad");
            return;
        }
        if (edad<12){
            tarifa=50;
        } else if (edad<=17) {
            System.out.println("¿Eres estudiante?");
            System.out.println("1. Si");
            System.out.println("2. No");
            System.out.println("Escriba el numero del menú para su selección: ");
            SeraEstudiante=sc.nextInt();
            esEstudiante=(SeraEstudiante==1);
            if (esEstudiante){
               tarifa=60;
            } else {
                tarifa=80;
            }
        } else {
            System.out.println("¿Eres estudiante?");
            System.out.println("1. Si");
            System.out.println("2. No");
            System.out.println("Escriba el numero del menú para su selección: ");
            SeraEstudiante=sc.nextInt();
            esEstudiante=(SeraEstudiante==1);
            if (esEstudiante){
                tarifa=90;
            } else {
                tarifa=120;
            }
        }
        System.out.println("-------Resultados----------");
        System.out.println("Edad ingresada: " + edad);
        System.out.println("Es estudiante: " + esEstudiante );
        System.out.println("Tarifa final: " + tarifa);
    }

}
