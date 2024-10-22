package PatronesDeDiseño.Prototype.model;

import PatronesDeDiseño.Prototype.services.IVehiculo;

public class AutoCasual extends Vehiculo implements IVehiculo {

    public AutoCasual(String marca, String modelo) {
        super(marca, modelo);
    }
    @Override
    public IVehiculo clonar(){
        return new AutoCasual(marca, modelo);
    }
    @Override
    public String toString(){
        return "Auto Casual: " + super.toString();
    }
}
