package modelo;

public class Pedido {
    private static final int DESGASTE_MAQUINA = 6000;
    private static final double MANO_OBRA = 3000;
    private static final int PLACAS_POR_RECARGO = 10;
    private static final double RECARGO_USO = 5000;

    private final int numeroPedido;
    private int numPlacas;
    private int tiempoTotalMinutos;
    private double subtotalPlacas;
    private String placasDetalle = "";

    public Pedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public int getNumeroPedido() {
        return numeroPedido; }

    public void agregarPlaca(Placas placa) {
        numPlacas++;
        tiempoTotalMinutos += placa.getEnergia().getTiempoMinutos();
        subtotalPlacas += placa.costoBasePlaca();
        placasDetalle += "  [Placa #" + numPlacas + "] -> " + placa + "\n";
    }

    // Regla de negocio: $5.000 por cada 10 placas completas del pedido
    public double calcularRecargoUso() {
        double recargo = 0;
        if (numPlacas >= PLACAS_POR_RECARGO) {
            recargo = (numPlacas / PLACAS_POR_RECARGO) * RECARGO_USO;
        }
        return recargo;
    }

    public double calcularCostoPedido() {
        double manoObra = (tiempoTotalMinutos / 60.0) * MANO_OBRA;
        double subtotal = DESGASTE_MAQUINA * numPlacas + manoObra + subtotalPlacas + calcularRecargoUso();
        return Math.ceil(subtotal / 100) * 100;
    }

    @Override
    public String toString() {
        String texto = "Pedido #" + numeroPedido + " | Placas en el pedido: " + numPlacas + "\n"
                     + placasDetalle
                     + "Desgaste Máquina: $" + (DESGASTE_MAQUINA * numPlacas) + "\n";
        if (calcularRecargoUso() > 0) {
            texto += "Recargo por uso: $" + (long) calcularRecargoUso() + "\n";
        }
        return texto + "COSTO TOTAL PEDIDO: $" + (long) calcularCostoPedido();
    }
}