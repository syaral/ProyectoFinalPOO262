public class Energia {
    private static final double COSTO_KW = 2000; // costo por kW
    private static final double GASTO_KW_HORA = 0.3; // consumo de la impresora en kW por hora
    private final int tiempoMinutos;

    public Energia(int tiempoMinutos) { 
        this.tiempoMinutos = tiempoMinutos;
    }

    public int getTiempoMinutos() { //se implementa un getter del tiempo para poder saber el tiempo en minutos en otras clases
        return tiempoMinutos; }
    public double cobroEnergia() { //se establece el costo de la energia, con respecto al tiempo, para incluirla en el cobro total
        return (tiempoMinutos * ((GASTO_KW_HORA / 60) * COSTO_KW)); }

    @Override
    public String toString() {
        return "Tiempo: " + tiempoMinutos + " min | Luz: $" + cobroEnergia();
    }
}