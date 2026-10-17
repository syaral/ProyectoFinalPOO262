// Esta clase se encarga de manejar el material (filamento) de la impresión.
// Guarda los gramos usados y calcula cuánto cuesta ese filamento. 
public class Material {

// --- Constantes del material ---
    private static final double COSTO_MATERIAL_GRAMO = 100; // Costo fijo: $100 pesos por cada gramo
    public static final double MAX_GRAMOS_PLACA = 750;       // Límite máximo de peso permitido por placa
// --- Atributos ---
    private final double materialGramos; // Gramos de filamento usados en la impresión
// Constructor: recibe los gramos al crear el material
    public Material(double materialGramos) { 
        this.materialGramos = materialGramos; 
    }
// Getter para consultar la cantidad de gramos desde otra clase
    public double getMaterialGramos() { 
        return materialGramos; 
    }
// Calcula el valor del filamento multiplicando los gramos por el precio de cada gramo
    public double cobroMaterial() { 
        return (materialGramos * COSTO_MATERIAL_GRAMO); 
    }
// Muestra en texto el peso del filamento y su precio
    @Override
    public String toString() {
        return "Peso: " + materialGramos + " g | Filamento: $" + cobroMaterial();
    }
}
