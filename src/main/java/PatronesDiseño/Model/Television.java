package PatronesDiseño.Model;

import PatronesDiseño.Service.Producto;

public class Television implements Producto {
    private String tiempoAlquiler;

    public Television(String tiempoAlquiler) {
        this.tiempoAlquiler = tiempoAlquiler;
    }

    @Override
    public String descripcion() {
        return "Televisor para ferias, exposiciones o entretenimiento doméstico"  + tiempoAlquiler+ ".";
    }
}
