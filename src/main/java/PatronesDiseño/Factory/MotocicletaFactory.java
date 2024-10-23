package PatronesDiseño.Factory;

import PatronesDiseño.Model.Motocicleta;
import PatronesDiseño.Service.Producto;

public class MotocicletaFactory extends ProductoFactory {
    @Override
    public Producto crearProducto() {
        return new Motocicleta("corto plazo");
    }
}
