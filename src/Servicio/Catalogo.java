package servicio;

import modelo.Material;
import modelo.MaterialPETG;
import modelo.MaterialPLA;
import modelo.MaterialTPU;

public class Catalogo {
    private final Material[] materiales;

    public Catalogo() {
        materiales = new Material[3];
        materiales[0] = new MaterialPLA(100);
        materiales[1] = new MaterialPETG(100);
        materiales[2] = new MaterialTPU(100);
    }

    // Polimorfismo: un solo ciclo, cada material responde según su tipo
    public String listar() {
        String texto = "Costo de imprimir 100 g con cada material:\n";
        for (int i = 0; i < materiales.length; i++) {
            texto += "  " + (i + 1) + ". " + materiales[i].getNombre()
                   + " -> $" + materiales[i].cobroMaterial() + "\n";
        }
        return texto;
    }

    // Busca por parte del nombre, sin importar mayúsculas
    public String buscar(String texto) {
        String resultado = "";
        for (int i = 0; i < materiales.length; i++) {
            if (materiales[i].getNombre().toLowerCase().contains(texto.toLowerCase())) {
                resultado += "  " + materiales[i].getNombre()
                           + " -> $" + materiales[i].cobroMaterial() + " por 100 g\n";
            }
        }
        if (resultado.equals("")) {
            return "No se encontraron materiales con ese nombre.";
        }
        return "Resultados:\n" + resultado;
    }
}
