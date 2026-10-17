import java.util.Scanner;

public class CrearPedido {
    public static Pedido nuevoPedido(Scanner scanner, int numeroPedido) {
        Pedido pedido = new Pedido(numeroPedido);

        // Cantidad de placas (1-20)
        int numPlacas = 0;
        while (numPlacas < 1 || numPlacas > 20) {
            System.out.print("¿Cuántas placas de impresión tiene este pedido? (1-20): ");
            if (scanner.hasNextInt()) {
                numPlacas = scanner.nextInt();
                if (numPlacas < 1 || numPlacas > 20) {
                    System.out.println("   Cantidad inválida: debe estar entre 1 y 20.");
                }
            } 
            else {
                scanner.next();
                System.out.println("   Entrada inválida: escriba un número entero.");
            }
        }

        // Cobrar filamento (1 = Sí, 2 = No)
        int opcionFilamento = 0;
        while (opcionFilamento != 1 && opcionFilamento != 2) {
            System.out.print("¿Cobrar filamento en este pedido? (1. Sí, 2. No): ");
            if (scanner.hasNextInt()) {
                opcionFilamento = scanner.nextInt();
                if (opcionFilamento != 1 && opcionFilamento != 2) {
                    System.out.println("   Opción inválida: escriba 1 o 2.");
                }
            } 
            else {
                scanner.next();
                System.out.println("   Entrada inválida: escriba 1 o 2.");
            }
        }
        boolean conFilamento = (opcionFilamento == 1);

        for (int i = 1; i <= numPlacas; i++) {
            System.out.println("\n-> DATOS DE LA PLACA #" + i + ":");

            // Tiempo de impresión (1-600 minutos)
            int minutos = 0;
            while (minutos < 1 || minutos > 600) {
                System.out.print("   Tiempo de impresión (en minutos): ");
                if (scanner.hasNextInt()) {
                    minutos = scanner.nextInt();
                    if (minutos < 1 || minutos > 600) {
                        System.out.println("   Tiempo inválido: debe estar entre 1 y 600 minutos.");
                    }
                } else {
                    scanner.next();
                    System.out.println("   Entrada inválida: escriba un número entero.");
                }
            }

            // Peso de la pieza (mayor que 0 y máximo 750 g)
            double gramos = 0;
            while (gramos <= 0 || gramos > Material.MAX_GRAMOS_PLACA) {
                System.out.print("   Peso de la pieza (en gramos, máximo 750): ");
                if (scanner.hasNextDouble()) {
                    gramos = scanner.nextDouble();
                    if (gramos <= 0 || gramos > Material.MAX_GRAMOS_PLACA) {
                        System.out.println("   Peso inválido: debe ser mayor que 0 y máximo 750 g.");
                    }
                } 
                else {
                    scanner.next();
                    System.out.println("   Entrada inválida: escriba un número.");
                }
            }

            Energia energia = new Energia(minutos);
            Material material = new Material(gramos);
            Placas placa = new Placas(energia, material, conFilamento);

            pedido.agregarPlaca(placa);
        }
        return pedido;
    }
}