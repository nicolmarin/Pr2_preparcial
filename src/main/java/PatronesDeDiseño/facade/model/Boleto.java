package PatronesDeDiseño.facade.model;

import java.time.LocalDate;

public class Boleto {
   private String pelicula;
    private LocalDate horario;

    public Boleto(String pelicula, LocalDate horario) {
        this.pelicula = pelicula;
        this.horario = horario;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public LocalDate getHorario() {
        return horario;
    }

    public void setHorario(LocalDate horario) {
        this.horario = horario;
    }
}
