package modelo;

public class MaterialPLA extends Material {
    private static final double COSTO_GRAMO = 100;

    public MaterialPLA(double materialGramos) {
        super(materialGramos);
    }

    @Override
    public double cobroMaterial() {
        return getMaterialGramos() * COSTO_GRAMO;
    }

    @Override
    public String getNombre() {
        return "PLA";
    }
}
