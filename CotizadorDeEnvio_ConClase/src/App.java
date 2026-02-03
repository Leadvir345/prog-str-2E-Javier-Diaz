import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("******Sistema de Envíos******");

        double pesoKg = LeerRangoDbl(sc, "Peso del paquete (kg): ", 0.1, 50.0);
        int distanciaKm = LeerRangoEnt(sc, "Distancia (km): ", 1, 2000);

        System.out.println("1) Estándar");
        System.out.println("2) Express");
        int tipoServicio = LeerRangoEnt(sc, "Tipo de servicio: ", 1, 2);

        boolean esZonaRemota = LeerBool(sc, "¿Zona remota? (true/false): ");

        ShippingCalculator calculadora = new ShippingCalculator();
        double subtotal = calculadora.CalSubtotal(pesoKg, distanciaKm, tipoServicio, esZonaRemota);
        double iva = calculadora.CalIVA(subtotal);
        double total = calculadora.CalTotal(subtotal, iva);
        ImpTicket(tipoServicio, pesoKg, distanciaKm, esZonaRemota, subtotal, iva, total);
        sc.close();
    }

    public static double LeerRangoDbl(Scanner sc, String msg, double min, double max) {
        double valor;
        while (true) {
            System.out.print(msg);
            if (sc.hasNextDouble()) {
                valor = sc.nextDouble();
                if (valor >= min && valor <= max) {
                    return valor;
                } else {
                    System.out.println("Valor fuera de rango.");
                }
            } else {
                System.out.println("Entrada inválida.");
                sc.next();
            }
        }
    }

    public static int LeerRangoEnt(Scanner sc, String msg, int min, int max) {
        int valor;
        while (true) {
            System.out.print(msg);
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                if (valor >= min && valor <= max) {
                    return valor;
                } else {
                    System.out.println("Valor fuera de rango.");
                }
            } else {
                System.out.println("Entrada inválida.");
                sc.next();
            }
        }
    }

    public static boolean LeerBool(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            if (sc.hasNextBoolean()) {
                return sc.nextBoolean();
            } else {
                System.out.println("Entrada inválida.");
                sc.next();
            }
        }
    }

    public static void ImpTicket(int tipoServicio, double pesoKg, int distanciaKm,
                                 boolean esZonaRemota, double subtotal, double iva, double total) {
        System.out.println("******TICKET DE ENVÍO******");

        String servicio = (tipoServicio == 1) ? "Estándar" : "Express";
        System.out.println("Servicio: " + servicio);
        System.out.println("Peso: " + pesoKg + " kg");
        System.out.println("Distancia: " + distanciaKm + " km");
        System.out.println("Zona remota: " + (esZonaRemota ? "Sí" : "No"));

        System.out.println("Subtotal: $" + String.format("%.2f", subtotal));
        System.out.println("IVA (16%): $" + String.format("%.2f", iva));
        System.out.println("Total: $" + String.format("%.2f", total));
    }
}


class ShippingCalculator {

    public double CalSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean zonaRemota) {
        double costoBase = 0.0;

        if (tipoServicio == 1) {
            costoBase = 50.0;
        } else if (tipoServicio == 2) {
            costoBase = 90.0;
        }

        double costoPeso = pesoKg * 12.0;

        double costoDistancia = 0.0;
        if (distanciaKm <= 50) {
            costoDistancia = 20.0;
        } else if (distanciaKm >= 51 && distanciaKm <= 200) {
            costoDistancia = 60.0;
        } else if (distanciaKm > 200) {
            costoDistancia = 120.0;
        }

        double subtotalParcial = costoBase + costoPeso + costoDistancia;

        if (zonaRemota) {
            subtotalParcial = subtotalParcial * 1.10;
        }

        return subtotalParcial;
    }

    public double CalIVA(double subtotal) {
        return subtotal * 0.16;
    }

    public double CalTotal(double subtotal, double iva) {
        return subtotal + iva;
    }
}