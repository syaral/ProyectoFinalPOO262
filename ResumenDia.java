public class ResumenDia {
    private int pedidosAtendidos;
    private double totalVendido;
    private String detallePedidos = "";

    public void registrarPedido(Pedido pedido) {
        pedidosAtendidos++;
        totalVendido += pedido.calcularCostoPedido();
        detallePedidos += "\n--- " + pedido + "\n";
    }

    public int getPedidosAtendidos() { return pedidosAtendidos; }
    public double getTotalVendido() { return totalVendido; }

    @Override
    public String toString() {
        if (pedidosAtendidos == 0) {
            return "No hay pedidos registrados en el día de hoy.";
        }
        return "=== RESUMEN DEL DÍA ===\n"
             + detallePedidos
             + "\n=================================\n"
             + "Pedidos atendidos: " + pedidosAtendidos + "\n"
             + "Vendido: $" + (long) totalVendido;
    }
}