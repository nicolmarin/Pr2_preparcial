package PatronesDeDiseño.facade.model;

public class Asiento {
    private int numero;
    private int fila;

    public Asiento(int numero, int fila) {
        this.numero = numero;
        this.fila = fila;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }
}
