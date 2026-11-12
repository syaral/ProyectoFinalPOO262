package modelo;

public class MaterialTPU extends Material {
    private static final double COSTO_GRAMO = 200;

    public MaterialTPU(double materialGramos) {
        super(materialGramos);
    }

    @Override
    public double cobroMaterial() {
        return getMaterialGramos() * COSTO_GRAMO;
    }

    @Override
    public String getNombre() {
        return "TPU";
    }
}