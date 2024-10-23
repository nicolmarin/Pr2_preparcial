package co.edu.uniquindio.parcial2.pr2_parcial2.viewcontroller;

import co.edu.uniquindio.parcial2.pr2_parcial2.controller.AdminController;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ClienteDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ObjetoDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

import static co.edu.uniquindio.parcial2.pr2_parcial2.utils.AdminConstantes.*;

public class AdminViewController {
    private AdminController adminController;
    private final ObservableList<ObjetoDto> listaObjetos = FXCollections.observableArrayList();
    private final ObservableList<ClienteDto> listaClientesMayorPrestamos = FXCollections.observableArrayList();
    private final ObservableList<EmpleadoDto> listaEmpleadosMayorPrestamos = FXCollections.observableArrayList();
    private final ObservableList<ClienteDto> listaClientesPorCedula = FXCollections.observableArrayList();
    private final ObservableList<ObjetoDto> listaObjetosMayorPrestamos = FXCollections.observableArrayList();
    private ObjetoDto objetoSeleccionado;
    private ClienteDto clienteSeleccionado;



    @FXML
    private ListView<EmpleadoDto> listBuscarEmpleadosMayorPrestamos;

    @FXML
    private TextField txtCantidadEmpleadosMayorPrestamos;

    @FXML
    void onConsultarEmpleadosMayorPrestamos(ActionEvent event) {
        consultarEmpleadosMayorPrestamos();
    }

    private void consultarEmpleadosMayorPrestamos() {
        String cantidadTexto = txtCantidadEmpleadosMayorPrestamos.getText();
        if (validarCampoNoVacio(cantidadTexto, BODY_INGRESE_CANTIDAD_CLIENTES)) {
            try {
                if (cantidadTexto.equals("0")) {
                    mostrarMensaje("Rango no válido", HEADER_ERROR, "El valor del rango no puede ser 0.", Alert.AlertType.ERROR);
                    return;
                }
                int cantidadPrestamos = Integer.parseInt(cantidadTexto);
                listaEmpleadosMayorPrestamos.clear();
                List<EmpleadoDto> empleados = adminController.consultarEmpleadosMayorPrestamos(cantidadPrestamos);
                listaEmpleadosMayorPrestamos.setAll(FXCollections.observableArrayList(empleados));
                listBuscarEmpleadosMayorPrestamos.setItems(listaEmpleadosMayorPrestamos);
            } catch (NumberFormatException e) {
                mostrarMensaje("Entrada no válida", HEADER_ERROR, BODY_NUMERO_NO_VALIDO, Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje(TITULO_OBJETO_INGRESE_VALOR, HEADER, BODY_INGRESE_RANGO, Alert.AlertType.INFORMATION);
        }
    }

    // ----------------------------- List Views -----------------------------
    @FXML
    private ListView<ObjetoDto> listObjetos;
    @FXML
    private ListView<ClienteDto> listBuscarClientesMayorPrestamos;
    @FXML
    private ListView<ClienteDto> listBuscarPorCedula;
    @FXML
    private ListView<ObjetoDto> listObjetosMayorPrestamos;

    // ----------------------------- Text Fields -----------------------------
    @FXML
    private TextField txtEstado;
    @FXML
    private TextField txtID;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtRangoOMayorPrestamos;
    @FXML
    private TextField txtBuscarClientePorCedula;
    @FXML
    private TextField txtCantidadClientesMayorPrestamos;

    // ----------------------------- Buttons -----------------------------
    @FXML
    private Button btnConsultarObjetosMayorPrestamos;
    @FXML
    private Button btnConsultarClientePorCedula;
    @FXML
    private Button btnConsultarObjetosXEstado;
    @FXML
    private Button btnConsultarClientesMayorPrestamos;
    @FXML
    private Button btnConsultarEmpleadosMayorPrestamos;

    @FXML
    private Button btnVerAsociados;

    @FXML
    private Button btnVerNoAsociados;

    @FXML
    private Button btnVerTodos;

    // ----------------------------- On Actions -----------------------------
    @FXML
    void onConsultarObjetosXEstado(ActionEvent event) {
        consultarObjetosPorEstado();
    }

    @FXML
    void onConsultarClientesMayorPrestamos(ActionEvent event) {
        consultarClientesMayorPrestamos();
    }

    @FXML
    void onConsultarObjetosMayorPrestamos(ActionEvent event) {
        consultarObjetosMayorPrestamos();
    }

    @FXML
    void onConsultarClientesCedula(ActionEvent event) {
        consultarClientePorCedula();
    }

    @FXML
    void onVerAsociados(ActionEvent event) {
        verAsociados();
    }

    @FXML
    void onVerNoAsociados(ActionEvent event) {
        verNoAsociados();
    }

    @FXML
    void onVerTodos(ActionEvent event) {
        verTodos();
    }

    private void verTodos() {
        listaObjetos.clear();
        List<ObjetoDto> todosObjetos = adminController.obtenerObjetos();
        listaObjetos.setAll(FXCollections.observableArrayList(todosObjetos));
        listObjetos.setItems(listaObjetos);
    }

    private void verAsociados() {
        listaObjetos.clear();
        List<ObjetoDto> objetosAsociados = adminController.consultarObjetosConPrestamos();
        listaObjetos.setAll(FXCollections.observableArrayList(objetosAsociados));
        listObjetos.setItems(listaObjetos);
    }

    private void verNoAsociados() {
        listaObjetos.clear();
        List<ObjetoDto> objetosNoAsociados = adminController.consultarObjetosSinPrestamos();
        listaObjetos.setAll(FXCollections.observableArrayList(objetosNoAsociados));
        listObjetos.setItems(listaObjetos);
    }

    private void consultarClientePorCedula() {
        String cedula = txtBuscarClientePorCedula.getText();
        if (validarCampoNoVacio(cedula, TITULO_OBJETO_INGRESE_VALOR)) {
            try {
                ClienteDto clienteDto = adminController.consultarClientePorCedula(cedula);
                if (clienteDto != null) {
                    listaClientesPorCedula.add(clienteDto);
                    listBuscarPorCedula.setItems(listaClientesPorCedula);
                    mostrarMensaje("Cliente Encontrado", "Información", clienteDto.toString(), Alert.AlertType.INFORMATION);
                } else {
                    mostrarMensaje(TITULO_OBJETO_NO_ENCONTRADO, HEADER, BODY_ID_NO_ENCONTRADO, Alert.AlertType.ERROR);
                }
            } catch (IllegalArgumentException e) {
                mostrarMensaje(TITULO_OBJETO_NO_ENCONTRADO, HEADER, e.getMessage(), Alert.AlertType.ERROR);
            }
        }
    }

    private void consultarObjetosMayorPrestamos() {
        String rangoTexto = txtRangoOMayorPrestamos.getText();
        if (validarCampoNoVacio(rangoTexto, TITULO_OBJETO_INGRESE_VALOR)) {
            try {
                if (rangoTexto.equals("0")) {
                    mostrarMensaje("Rango no válido", HEADER_ERROR, "El valor del rango no puede ser 0.", Alert.AlertType.ERROR);
                    return;
                }
                int rango = Integer.parseInt(rangoTexto);
                listaObjetosMayorPrestamos.clear();
                List<ObjetoDto> objetos = adminController.consultarObjetosMayorPrestamos(rango);
                listaObjetosMayorPrestamos.setAll(FXCollections.observableArrayList(objetos));
                listObjetosMayorPrestamos.setItems(listaObjetosMayorPrestamos);

            } catch (NumberFormatException e) {
                mostrarMensaje("Entrada no válida", HEADER_ERROR, BODY_NUMERO_NO_VALIDO, Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje(TITULO_OBJETO_INGRESE_VALOR, HEADER, BODY_INGRESE_RANGO, Alert.AlertType.INFORMATION);
        }
    }

    private void consultarClientesMayorPrestamos() {
        String cantidadTexto = txtCantidadClientesMayorPrestamos.getText();
        if (validarCampoNoVacio(cantidadTexto, BODY_INGRESE_CANTIDAD_CLIENTES)) {
            try {
                if (cantidadTexto.equals("0")) {
                    mostrarMensaje("Rango no válido", HEADER_ERROR, "El valor del rango no puede ser 0.", Alert.AlertType.ERROR);
                    return;
                }
                int cantidadPrestamos = Integer.parseInt(cantidadTexto);
                listaClientesMayorPrestamos.clear();
                List<ClienteDto> clientes = adminController.consultarClientesMayorPrestamos(cantidadPrestamos);
                listaClientesMayorPrestamos.setAll(FXCollections.observableArrayList(clientes));
                listBuscarClientesMayorPrestamos.setItems(listaClientesMayorPrestamos);
            } catch (NumberFormatException e) {
                mostrarMensaje("Entrada no válida", HEADER_ERROR, BODY_NUMERO_NO_VALIDO, Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje(TITULO_OBJETO_INGRESE_VALOR, HEADER, BODY_INGRESE_RANGO, Alert.AlertType.INFORMATION);
        }
    }

    private void consultarObjetosPorEstado() {
        String estado = txtEstado.getText();
        if (validarCampoNoVacio(estado, TITULO_OBJETO_INGRESE_VALOR)) {
            listaObjetos.clear();
            List<ObjetoDto> objetos = adminController.consultarObjetosPorEstado(estado);
            listaObjetos.setAll(FXCollections.observableArrayList(objetos));
            listObjetos.setItems(listaObjetos);
        } else {
            mostrarMensaje(TITULO_OBJETO_INGRESE_VALOR, HEADER, "Ingrese el valor", Alert.AlertType.INFORMATION);
        }
    }

    private boolean validarCampoNoVacio(String valor, String mensaje) {
        if (valor.trim().isEmpty()) {
            mostrarMensaje("Campo Vacío", "Error", mensaje, Alert.AlertType.WARNING);
            return false;
        }
        return true;
    }

    private void mostrarMensaje(String titulo, String encabezado, String contenido, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
