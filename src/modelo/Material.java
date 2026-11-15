package modelo;

public abstract class Material {
    public static final double MAX_GRAMOS_PLACA = 750; // límite de peso por placa
    private final double materialGramos;

    public Material(double materialGramos) {
        this.materialGramos = materialGramos;
    }

    public double getMaterialGramos() {
        return materialGramos;
    }

    // Cada tipo de material calcula su cobro a su manera
    public abstract double cobroMaterial();

    public abstract String getNombre();

    @Override
    public String toString() {
        return getNombre() + " | Peso: " + materialGramos + " g | Filamento: $" + cobroMaterial();
    }
}