import java.util.Scanner;

// Clase principal para ejecutar la consola del sistema de impresión 3D
public class Main {
    public static void main(String[] args) {
// Objeto Scanner para leer la entrada de teclado
        Scanner sc = new Scanner(System.in);
        
// Bitácora contable donde se guardan los pedidos confirmados del día
        ResumenDia resumenDia = new ResumenDia();
        
// Contador para asignar un ID numérico único y consecutivo a cada pedido
        int contadorPedidos = 0;
        
// Bandera para controlar la ejecución del menú interactivo
        boolean salir = false;

// Bucle principal: se repite hasta que el usuario elija la opción de salir
        while (!salir) {
            System.out.println("\n=================================");
            System.out.println("   SISTEMA DE IMPRESIÓN 3D");
            System.out.println("=================================");
            System.out.println("1. Registrar nuevo pedido");
            System.out.println("2. Cotización de pedido");
            System.out.println("3. Ver resumen del día");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

// Validación de la opción elegida para evitar que la aplicación falle si meten letras
            int opcion = 0;
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
            } else {
                sc.next(); // Limpia la entrada no válida; la opción queda en 0 para entrar a 'default'
            }

            switch (opcion) {
                case 1:
// Opción 1: Registro directo de un pedido confirmado por el cliente
                    System.out.println("\n=== REGISTRAR NUEVO PEDIDO ===");
                    
// Se crea el pedido asignándole el siguiente ID consecutivo
                    Pedido pedidoRegistrar = CrearPedido.nuevoPedido(sc, contadorPedidos + 1);
                    contadorPedidos++;
                    
// Se ingresa a la lista del resumen del día
                    resumenDia.registrarPedido(pedidoRegistrar);
                    
                    System.out.println("\n=== PEDIDO REGISTRADO CON ÉXITO ===");
                    System.out.println(pedidoRegistrar);
                    break;

                case 2:
// Opción 2: Cotización rápida sin compromiso
                    System.out.println("\n=== COTIZACIÓN DE PEDIDO ===");
                    
// Se calcula la cotización con la misma lógica del pedido
                    Pedido pedidoCotizado = CrearPedido.nuevoPedido(sc, contadorPedidos + 1);
                    System.out.println("\n=== RESUMEN DE COTIZACIÓN ===");
                    System.out.println(pedidoCotizado);

// Se le pregunta al cliente si decide confirmar la compra
                    System.out.print("\n¿Desea registrar esta cotización como pedido en el día de hoy? (1. Sí, 2. No): ");
                    int respuesta = 0;
                    if (sc.hasNextInt()) {
                        respuesta = sc.nextInt();
                    } else {
                        sc.next();
                    }

// Si confirma (1), aumenta el contador de pedidos y lo guarda en el resumen del día
// Si no confirma (2), la cotización se descarta de la memoria para no alterar las cuentas
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
 // Opción 3: Consulta del total acumulado y lista de pedidos del día
                    System.out.println("\n" + resumenDia);
                    break;

                case 4:
 // Opción 4: Finaliza la ejecución del sistema
                    salir = true;
                    System.out.println("\n¡Gracias por usar el sistema!");
                    break;

                default:
 // Captura opciones fuera del rango (1-4) o entradas inválidas
                    System.out.println("\nOpción no válida. Intente nuevamente.");
                    break;
            }
        }
        
// Cierre del Scanner para liberar recursos
        sc.close();
    }
}
