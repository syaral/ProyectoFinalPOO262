public class Placas {
    private final Energia energia; // composición: la placa tiene un objeto Energia que calcula el cobro de la luz
    private final Material material; // composición: la placa tiene un objeto Material que calcula el cobro del filamento
    private final boolean incluirFilamento; //se pregunta si agregar o no filamento para agregarlo al valor de la placa

    public Placas(Energia energia, Material material, boolean incluirFilamento) {
        this.energia = energia;
        this.material = material;
        this.incluirFilamento = incluirFilamento;
    }

    public Energia getEnergia() { 
        return energia; }
    public Material getMaterial() { 
        return material; }

    public double costoBasePlaca() {
        double costoPlaca = energia.cobroEnergia();
        if (incluirFilamento) {
            costoPlaca += material.cobroMaterial();
        }
        return costoPlaca;
    }

    @Override
    public String toString() {
        return energia.toString() + " | " + material.toString() + " | Cobrar filamento: " + (incluirFilamento ? "Sí" : "No");
    }
}