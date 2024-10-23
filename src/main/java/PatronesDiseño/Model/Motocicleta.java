package PatronesDiseño.Model;

import PatronesDiseño.Service.Producto;

public class Motocicleta implements Producto {
    private String tiempoAlquiler;

    public Motocicleta(String tiempoAlquiler) {
        this.tiempoAlquiler = tiempoAlquiler;
    }

    @Override
    public String descripcion() {
        return " Motocicleta ideal para clientes que buscan un transporte ágil" + tiempoAlquiler+ ".";
    }
}
