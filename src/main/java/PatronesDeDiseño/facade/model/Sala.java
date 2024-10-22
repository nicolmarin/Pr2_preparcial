package PatronesDeDiseño.facade.model;

public class Sala {
    private String clase;
    private String dimension;

    public Sala(String funcion, String dimension) {
        this.clase = funcion;
        this.dimension = dimension;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }
}
