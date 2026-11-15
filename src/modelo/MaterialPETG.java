package modelo;

public class MaterialPETG extends Material {
    private static final double COSTO_GRAMO = 150;

    public MaterialPETG(double materialGramos) {
        super(materialGramos);
    }

    @Override
    public double cobroMaterial() {
        return getMaterialGramos() * COSTO_GRAMO;
    }

    @Override
    public String getNombre() {
        return "PETG";
    }
}
