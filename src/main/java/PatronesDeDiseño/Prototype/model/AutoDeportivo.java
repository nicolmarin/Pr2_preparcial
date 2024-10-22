package PatronesDeDiseño.Prototype.model;

import PatronesDeDiseño.Prototype.services.IVehiculo;

public class AutoDeportivo extends Vehiculo implements IVehiculo {
    public AutoDeportivo(String marca, String modelo) {
        super(marca, modelo);
    }

    @Override
    public IVehiculo clonar(){
        return new AutoDeportivo(marca, modelo);
    }
    @Override
    public String toString(){
        return "Auto Deportivo: " + super.toString();
    }
}
