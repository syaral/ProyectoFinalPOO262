package app;

import java.util.Scanner;
import modelo.Pedido;
import servicio.Agenda;
import servicio.Catalogo;
import servicio.CrearPedido;
import servicio.ResumenDia;

public class Main {

    // Lee un entero; si el usuario escribe otra cosa, devuelve 0 (opción inválida)
    private static int leerEntero(Scanner sc) {
        if (sc.hasNextInt()) {
            return sc.nextInt();
        }
        sc.next();
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ResumenDia resumenDia = new ResumenDia();
        Catalogo catalogo = new Catalogo();
        Agenda agenda = new Agenda();
        int contadorPedidos = 0;
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=================================");
            System.out.println("   SISTEMA DE IMPRESIÓN 3D");
            System.out.println("=================================");
            System.out.println("1. Registrar nuevo pedido");
            System.out.println("2. Cotización de pedido");
            System.out.println("3. Ver resumen del día");
            System.out.println("4. Catálogo de materiales");
            System.out.println("5. Agenda de la impresora");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = leerEntero(sc);

            switch (opcion) {
                case 1:
                    System.out.println("\n=== REGISTRAR NUEVO PEDIDO ===");
                    Pedido pedidoRegistrar = CrearPedido.nuevoPedido(sc, contadorPedidos + 1);
                    contadorPedidos++;
                    resumenDia.registrarPedido(pedidoRegistrar);
                    System.out.println("\n=== PEDIDO REGISTRADO CON ÉXITO ===");
                    System.out.println(pedidoRegistrar);
                    break;

                case 2:
                    System.out.println("\n=== COTIZACIÓN DE PEDIDO ===");
                    Pedido pedidoCotizado = CrearPedido.nuevoPedido(sc, contadorPedidos + 1);
                    System.out.println("\n=== RESUMEN DE COTIZACIÓN ===");
                    System.out.println(pedidoCotizado);

                    System.out.print("\n¿Desea registrar esta cotización como pedido en el día de hoy? (1. Sí, 2. No): ");
                    int respuesta = leerEntero(sc);

                    if (respuesta == 1) {
                        contadorPedidos++;
                        resumenDia.registrarPedido(pedidoCotizado);
                        System.out.println("¡Pedido registrado exitosamente en el resumen del día!");
                    } else if (respuesta == 2) {
                        System.out.println("Cotización descartada. No se guardó en el resumen.");
                    } else {
                        System.out.println("Opción inválida. La cotización no se guardó en el resumen.");
                    }
                    break;

                case 3:
                    System.out.println("\n" + resumenDia);
                    break;

                case 4: {
                    System.out.println("\n=== CATÁLOGO DE MATERIALES ===");
                    System.out.println(catalogo.listar());
                    System.out.print("Escriba parte del nombre para buscar (o 0 para volver): ");
                    String texto = sc.next();
                    if (!texto.equals("0")) {
                        System.out.println(catalogo.buscar(texto));
                    }
                    break;
                }

                case 5: {
                    System.out.println("\n=== AGENDA DE LA IMPRESORA ===");
                    System.out.println(agenda.mostrar());
                    System.out.println("\n1. Consultar turno");
                    System.out.println("2. Reservar turno");
                    System.out.println("3. Liberar turno");
                    System.out.println("4. Poner en mantenimiento");
                    System.out.println("5. Volver");
                    System.out.print("Seleccione una acción: ");
                    int accion = leerEntero(sc);

                    if (accion >= 1 && accion <= 4) {
                        System.out.print("Fila (día, 1-5): ");
                        int fila = leerEntero(sc);
                        System.out.print("Columna (franja, 1-3): ");
                        int columna = leerEntero(sc);

                        switch (accion) {
                            case 1:
                                System.out.println(agenda.consultar(fila, columna));
                                break;
                            case 2:
                                System.out.print("Número del pedido a reservar: ");
                                int numPedido = leerEntero(sc);
                                if (numPedido >= 1 && numPedido <= contadorPedidos) {
                                    System.out.println(agenda.reservar(fila, columna, numPedido));
                                } else {
                                    System.out.println("Ese pedido no está registrado.");
                                }
                                break;
                            case 3:
                                System.out.println(agenda.liberar(fila, columna));
                                break;
                            default:
                                System.out.println(agenda.mantenimiento(fila, columna));
                                break;
                        }
                    } else if (accion != 5) {
                        System.out.println("Acción no válida.");
                    }
                    break;
                }

                case 6:
                    salir = true;
                    System.out.println("\n¡Gracias por usar el sistema!");
                    break;

                default:
                    System.out.println("\nOpción no válida. Intente nuevamente.");
                    break;
            }
        }
        sc.close();
    }
}
