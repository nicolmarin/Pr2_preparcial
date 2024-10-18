package co.edu.uniquindio.parcial2.pr2_parcial2.model.builder;

import co.edu.uniquindio.parcial2.pr2_parcial2.model.Objeto;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.PrestamoObjeto;

public class ObjetoBuilder {
    protected String nombre;
    protected String idObjeto;
    PrestamoObjeto ownedByPrestamoUq;
    protected String estado;
    protected int cantidadPrestamos;

    public ObjetoBuilder cantidadPrestamos(int cantidadPrestamos) {
        this.cantidadPrestamos = cantidadPrestamos;
        return this;
    }
    public ObjetoBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    public ObjetoBuilder estado(String estado) {
        this.estado = estado;
        return this;
    }
    public ObjetoBuilder idObjeto(String idObjeto) {
        this.idObjeto = idObjeto;
        return this;
    }
    public ObjetoBuilder ownedByPrestamoUq(PrestamoObjeto ownedByPrestamoUq) {
        this.ownedByPrestamoUq = ownedByPrestamoUq;
        return this;
    }
    public Objeto build() {
        return new Objeto(nombre, idObjeto,ownedByPrestamoUq,estado, cantidadPrestamos);
    }
}
