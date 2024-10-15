package co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto;



import java.util.Date;
import java.util.List;

public record PrestamoDto (
        String numeroPrestamo,
        Date fechaPrestamo,
        Date fechaEntrega,
        String descripcion,
        ClienteDto clienteAsociado,
        EmpleadoDto empleadoAsociado,
        List<ObjetoDto> objetosAsociados
) {
}