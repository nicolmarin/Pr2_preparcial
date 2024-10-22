package PatronesDeDiseño.Prototype;

import PatronesDeDiseño.Prototype.model.AutoCasual;
import PatronesDeDiseño.Prototype.model.AutoDeportivo;

public class VehiculoPrototype {
    public static void main(String[] args) {
        AutoDeportivo Ferrari = new AutoDeportivo("Ferrari", "2024 - 250GTO");
        AutoDeportivo FerrariClonado = (AutoDeportivo) Ferrari.clonar();
        FerrariClonado.setMarca("Ferrari");
        FerrariClonado.setModelo("2024 - Portofino");

        AutoCasual Chevrolet = new AutoCasual("Chevrolet", "2024 - Activ");
        AutoCasual ChevroletClonado = (AutoCasual) Chevrolet.clonar();
        ChevroletClonado.setMarca("Chevrolet");
        ChevroletClonado.setModelo("2023 - Onix");


        System.out.println("------- Auto Deportivo  -------");
        System.out.println("Original:");
        System.out.println(Ferrari);
        System.out.println("Clonado:");
        System.out.println(FerrariClonado);
        System.out.println("--------------------------------------\n");

        System.out.println("------- Auto Casual  -------");
        System.out.println("Original:");
        System.out.println(Chevrolet);
        System.out.println("Clonado:");
        System.out.println(ChevroletClonado);
        System.out.println("--------------------------------------\n");


    }
}
