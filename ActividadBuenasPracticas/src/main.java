import java.util.Scanner;

/**
 * Proporciona la lógica para calcular la sumatoria de una secuencia numérica.
 * Esta clase gestiona la entrada de datos por consola y el procesamiento
 * de la suma acumulada de números naturales.
 */
public class main{
    /**
     * Variable que controla la iteración actual dentro del ciclo de cálculo.
     */
    public static int VALOR_CONTADOR = 1;
    /**
     * Variable que almacena el total acumulado del cálculo de la secuencia.
     */
    public static int NUMERO_SECUENCIA = 0;
    /**
     * Arranca la aplicación, solicita el dato inicial y muestra el resultado.
     * * @param args Arreglo de strings para parámetros desde la terminal.
     */
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        // Captura del dato
        int valorRegistrado = registrarValores(sc, "Ingresa el valor para sacar su secuencia: ");
        // Procesamiento
        int resultadoFinal = calculoDeSecuencia(valorRegistrado);
        // Salida
        System.out.println("El calculo final de la secuencia es: " +resultadoFinal);
    }
    /**
     * Realiza la suma aritmética desde 1 hasta el número indicado.
     * * @param valorRegistrado El límite superior hasta donde se realizará la suma.
     * @return El total de la suma acumulada de la secuencia.
     */
    public static int registrarValores(Scanner sc, String valorRegistrado){
        System.out.println(valorRegistrado);
        return sc.nextInt();
    }
    // Reiniciamos el acumulador para asegurar resultados correctos en cada llamada
    public static int calculoDeSecuencia(int valorRegistrado){
        for (VALOR_CONTADOR = 1; VALOR_CONTADOR <= valorRegistrado; VALOR_CONTADOR++){
            NUMERO_SECUENCIA +=  VALOR_CONTADOR;
        }
        return NUMERO_SECUENCIA;
    }
}