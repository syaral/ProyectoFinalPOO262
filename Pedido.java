// Esta clase representa un pedido completo de impresión 3D.
// Aquí se guardan las placas, se calcula el desgaste y la mano de obra
// Tambien se aplican los recargos si corresponden y se saca el precio final.
public class Pedido {

// --- Constantes y Precios fijos ---
    private static final int DESGASTE_MAQUINA = 6000;    // $6.000 de desgaste por cada placa
    private static final double MANO_OBRA = 3000;        // $3.000 por hora de trabajo
    private static final int PLACAS_POR_RECARGO = 10;    // Cada 10 placas hay un recargo
    private static final double RECARGO_USO = 5000;      // Valor del recargo es de $5.000

// --- Datos unicos del pedido ---
    private final int numeroPedido;       // El ID o número del pedido
    private int numPlacas;                // Numero de placas
    private int tiempoTotalMinutos;       // Duracion de impresión en minutos (por placa)
    private double subtotalPlacas;        // Suma del costo de luz y filamento de las placas
    private String placasDetalle = "";    // Texto que se le muestra a el cliente con los datos de la placa

// Constructor: número del pedido al crearlo
    public Pedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

// Getter para consultar el número del pedido
    public int getNumeroPedido() { 
        return numeroPedido; 
    }

// Método para ir metiendo placas al pedido.
// Con cada placa que se agrega, suma su tiempo, su costo base y guarda su detalle en texto.
    public void agregarPlaca(Placas placa) {
        numPlacas++;
        tiempoTotalMinutos += placa.getEnergia().getTiempoMinutos();
        subtotalPlacas += placa.costoBasePlaca();
        placasDetalle += "  [Placa #" + numPlacas + "] -> " + placa + "\n";
    }

// Si el pedido tiene 10 o más placas, cobra $5.000 extra por cada paquete de 10 placas.
// Se usa división entera (numPlacas / 10) para quedé exacto: De 10 a 19 placas da 1 ($5.000), de 20 a 29 da 2 ($10.000), etc.
    public double calcularRecargoUso() {
        double recargo = 0;
        if (numPlacas >= PLACAS_POR_RECARGO) {
            recargo = (numPlacas / PLACAS_POR_RECARGO) * RECARGO_USO;
        }
        return recargo;
    }

// Aquí se calcula el precio final del pedido sumando todo:
// (Desgaste x número de placas) + Mano de obra + Costo de placas + Recargo por volumen.
// Se redondea hacia arriba al múltiplo de 100 más cercano.
    public double calcularCostoPedido() {
        double manoObra = (tiempoTotalMinutos / 60.0) * MANO_OBRA;
        double subtotal = DESGASTE_MAQUINA * numPlacas + manoObra + subtotalPlacas + calcularRecargoUso();
        
        return Math.ceil(subtotal / 100) * 100;
    }

// Se genera el recibo en texto para imprimirlo al cliente
    @Override
    public String toString() {
        String texto = "Pedido #" + numeroPedido + " | Placas en el pedido: " + numPlacas + "\n"
                     + placasDetalle
                     + "Desgaste Máquina: $" + (DESGASTE_MAQUINA * numPlacas) + "\n";
                     
// Solo muestra la línea de recargo si  se aplicó
        if (calcularRecargoUso() > 0) {
            texto += "Recargo por uso: $" + (long) calcularRecargoUso() + "\n";
        }
        
        return texto + "COSTO TOTAL PEDIDO: $" + (long) calcularCostoPedido();
    }
}
