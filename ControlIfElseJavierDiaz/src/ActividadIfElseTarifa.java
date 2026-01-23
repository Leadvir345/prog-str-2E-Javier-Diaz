import java.util.Scanner;

class Tarifas {
    int edad;
    int tarifa;
    int SeraEstudiante;
    boolean esEstudiante = false;
    Scanner sc=new Scanner(System.in);

    public void solicitarEdad(){
        System.out.println("Ingresa tu edad");
        edad= sc.nextInt();
    }

    public void calcularTarifa(){
        if (edad<0 || edad>120){
            System.out.println("Edad invalida");
            return;
        }

        if(edad<12){
            tarifa=50;
        } else if(edad<=17){
            SaberSiEsEstudiante();
            if (esEstudiante){
                tarifa=60;
            }else{
                tarifa=80;
            }
        }else{
            SaberSiEsEstudiante();
            if (esEstudiante){
                tarifa=90;
            }else {
                tarifa=120;
            }
        }
    }

    private void SaberSiEsEstudiante() {
        System.out.println("¿Eres estudiante?");
        System.out.println("1. Si");
        System.out.println("2. No");
        System.out.println("Escriba el numero del menú para su selección: ");
        SeraEstudiante = sc.nextInt();
        esEstudiante = (SeraEstudiante == 1);
    }

    public void mostrarResultados() {
        if (edad >= 0 && edad <= 120) {
            System.out.println("----Resultados--------");
            System.out.println("Edad ingresada: " + edad);
            System.out.println("Es estudiante: " + esEstudiante);
            System.out.println("Tarifa final: " + tarifa);
        }
    }
}

public class ActividadIfElseTarifa {
    public static void main(String[] args) {
        Tarifas gestor = new Tarifas();
        gestor.solicitarEdad();
        gestor.calcularTarifa();
        gestor.mostrarResultados();
    }
}