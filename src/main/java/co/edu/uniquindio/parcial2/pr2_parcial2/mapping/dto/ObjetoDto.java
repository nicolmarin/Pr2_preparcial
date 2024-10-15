package co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto;

import co.edu.uniquindio.parcial2.pr2_parcial2.model.PrestamoObjeto;

public record ObjetoDto (
        String nombre,
        String idObjeto,
        String estado,
        PrestamoObjeto ownedByPrestamoUq

) {
}

