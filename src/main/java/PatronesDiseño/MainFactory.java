package PatronesDiseño;

import PatronesDiseño.Factory.*;
import PatronesDiseño.Service.Producto;

public class MainFactory {
    public static void main(String[] args) {
        ProductoFactory cocheFactory = new CocheFactory();
        Producto coche = cocheFactory.crearProducto();
        System.out.println(coche.descripcion());

        ProductoFactory motoFactory = new MotocicletaFactory();
        Producto moto = motoFactory.crearProducto();
        System.out.println(moto.descripcion());

        ProductoFactory bicicletaFactory = new BicicletaFactory();
        Producto bicicleta = bicicletaFactory.crearProducto();
        System.out.println(bicicleta.descripcion());

        // Crear fábricas de la familia de Electrodomésticos
        ProductoFactory refrigeradorFactory = new RefrigeradorFactory();
        Producto refrigerador = refrigeradorFactory.crearProducto();
        System.out.println(refrigerador.descripcion());

        ProductoFactory televisorFactory = new TelevisionFactory();
        Producto televisor = televisorFactory.crearProducto();
        System.out.println(televisor.descripcion());

        ProductoFactory lavadoraFactory = new LavadoraFactory();
        Producto lavadora = lavadoraFactory.crearProducto();
        System.out.println(lavadora.descripcion());
    }
}
