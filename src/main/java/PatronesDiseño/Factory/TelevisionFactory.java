package PatronesDiseño.Factory;

import PatronesDiseño.Model.Television;
import PatronesDiseño.Service.Producto;

public class TelevisionFactory extends ProductoFactory {
    @Override
    public Producto crearProducto() {
        return new Television("largo plazo");
    }
}
