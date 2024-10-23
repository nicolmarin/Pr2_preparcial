package PatronesDiseño.Factory;

import PatronesDiseño.Model.Coche;
import PatronesDiseño.Service.Producto;

public class CocheFactory extends ProductoFactory {
    @Override
    public Producto crearProducto() {
        return new Coche("largo plazo");
    }
}
