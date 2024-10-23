package PatronesDiseño.Factory;

import PatronesDiseño.Model.Lavadora;
import PatronesDiseño.Service.Producto;

public class LavadoraFactory extends ProductoFactory {
    @Override
    public Producto crearProducto() {
        return new Lavadora("corto plazo");
    }
}
