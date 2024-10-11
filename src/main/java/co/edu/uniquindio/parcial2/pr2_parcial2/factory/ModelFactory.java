package co.edu.uniquindio.parcial2.pr2_parcial2.factory;

import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ClienteDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.mappers.PrestamoMappingImpl;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.Cliente;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.PrestamoObjeto;
import co.edu.uniquindio.parcial2.pr2_parcial2.service.IModelFactoryService;
import co.edu.uniquindio.parcial2.pr2_parcial2.service.IPrestamoMapping;
import co.edu.uniquindio.parcial2.pr2_parcial2.utils.DataUtil;

import java.util.List;

public class ModelFactory implements IModelFactoryService {
    private static ModelFactory modelFactory;
    private PrestamoObjeto prestamoObjeto;
    private IPrestamoMapping mapper;

    public static ModelFactory getInstancia() {
        if(modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private ModelFactory(){
        mapper = new PrestamoMappingImpl();
        prestamoObjeto = DataUtil.inicializarDatos();
    }


    @Override
    public List<ClienteDto> obtenerClientes() {
        return mapper.getClientesDto(prestamoObjeto.getListaClientes());
    }

    @Override
    public boolean agregarCliente(ClienteDto clienteDto) {
        Cliente cliente = mapper.clienteDtoToCliente(clienteDto);
        return prestamoObjeto.crearCliente(cliente);
        //return prestamoObjeto.crearCliente(mapper.clienteDtoToCliente(clienteDto));
    }
}
