package PatronesDiseño.Factory;

import PatronesDiseño.Model.Refrigerador;
import PatronesDiseño.Service.Producto;

public class RefrigeradorFactory extends ProductoFactory {
    @Override
    public Producto crearProducto() {
        return new Refrigerador("largo plazo");
    }
}
