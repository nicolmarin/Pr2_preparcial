package co.edu.uniquindio.parcial2.pr2_parcial2.model;

import co.edu.uniquindio.parcial2.pr2_parcial2.model.builder.ObjetoBuilder;

public class Objeto {
    private String nombre;
    private String idObjeto;
    PrestamoObjeto ownedByPrestamoUq;
    private String estado;

    public Objeto(String nombre, String idObjeto, PrestamoObjeto ownedByPrestamoUq, String estado) {
        this.nombre = nombre;
        this.idObjeto = idObjeto;
        this.ownedByPrestamoUq = ownedByPrestamoUq;
        this.estado = estado;
    }
    public Objeto(String idObjeto, String s, String nombre) {
        this.nombre = nombre;
    }
    public Objeto() {
    }
    public static ObjetoBuilder builder() {
        return new ObjetoBuilder();
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(String idObjeto) {
        this.idObjeto = idObjeto;
    }

    public PrestamoObjeto getOwnedByPrestamoUq() {
        return ownedByPrestamoUq;
    }

    public void setOwnedByPrestamoUq(PrestamoObjeto ownedByPrestamoUq) {
        this.ownedByPrestamoUq = ownedByPrestamoUq;
    }

    @Override
    public String toString() {
        return "Objeto{" +
                "nombre='" + nombre + '\'' +
                ", idObjeto='" + idObjeto + '\'' +
                ", ownedByPrestamoUq=" + ownedByPrestamoUq +
                ", estado='" + estado + '\''
        ;
    }
    public int getCantidadObjetoPrestado() {
        return 0;
    }
}
