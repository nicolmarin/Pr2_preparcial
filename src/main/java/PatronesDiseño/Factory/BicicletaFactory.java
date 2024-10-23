package PatronesDiseño.Factory;

import PatronesDiseño.Model.Bicicleta;
import PatronesDiseño.Service.Producto;

public class BicicletaFactory extends ProductoFactory {
    @Override
    public Producto crearProducto() {
        return new Bicicleta("largo plazo");
    }
}
