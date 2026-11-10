package servicio;

import java.util.Scanner;
import modelo.Energia;
import modelo.Material;
import modelo.MaterialPETG;
import modelo.MaterialPLA;
import modelo.MaterialTPU;
import modelo.Pedido;
import modelo.Placas;

public class CrearPedido {
    public static Pedido nuevoPedido(Scanner scanner, int numeroPedido) {
        Pedido pedido = new Pedido(numeroPedido);

        // Cantidad de placas (1-100)
        int numPlacas = 0;
        while (numPlacas < 1 || numPlacas > 100) {
            System.out.print("¿Cuántas placas de impresión tiene este pedido? (1-100): ");
            if (scanner.hasNextInt()) {
                numPlacas = scanner.nextInt();
                if (numPlacas < 1 || numPlacas > 100) {
                    System.out.println("   Cantidad inválida: debe estar entre 1 y 100.");
                }
            } else {
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
            } else {
                scanner.next();
                System.out.println("   Entrada inválida: escriba 1 o 2.");
            }
        }
        boolean conFilamento = (opcionFilamento == 1);

        for (int i = 1; i <= numPlacas; i++) {
            System.out.println("\n-> DATOS DE LA PLACA #" + i + ":");

            // Tiempo de impresión (1-10000 minutos)
            int minutos = 0;
            while (minutos < 1 || minutos > 10000) {
                System.out.print("   Tiempo de impresión (en minutos): ");
                if (scanner.hasNextInt()) {
                    minutos = scanner.nextInt();
                    if (minutos < 1 || minutos > 10000) {
                        System.out.println("   Tiempo inválido: debe estar entre 1 y 10000 minutos.");
                    }
                } else {
                    scanner.next();
                    System.out.println("   Entrada inválida: escriba un número entero.");
                }
            }

            // Tipo de material (1 = PLA, 2 = PETG, 3 = TPU)
            int tipoMaterial = 0;
            while (tipoMaterial < 1 || tipoMaterial > 3) {
                System.out.print("   Material (1. PLA, 2. PETG, 3. TPU): ");
                if (scanner.hasNextInt()) {
                    tipoMaterial = scanner.nextInt();
                    if (tipoMaterial < 1 || tipoMaterial > 3) {
                        System.out.println("   Opción inválida: escriba 1, 2 o 3.");
                    }
                } else {
                    scanner.next();
                    System.out.println("   Entrada inválida: escriba 1, 2 o 3.");
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
                } else {
                    scanner.next();
                    System.out.println("   Entrada inválida: escriba un número.");
                }
            }

            // Se crea la subclase según lo elegido; desde aquí todo es de tipo Material
            Material material;
            switch (tipoMaterial) {
                case 1:
                    material = new MaterialPLA(gramos);
                    break;
                case 2:
                    material = new MaterialPETG(gramos);
                    break;
                default:
                    material = new MaterialTPU(gramos);
                    break;
            }

            Energia energia = new Energia(minutos);
            Placas placa = new Placas(energia, material, conFilamento);

            pedido.agregarPlaca(placa);
        }
        return pedido;
    }
}
