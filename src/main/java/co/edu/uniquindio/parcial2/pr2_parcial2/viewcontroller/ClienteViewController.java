package co.edu.uniquindio.parcial2.pr2_parcial2.viewcontroller;

import co.edu.uniquindio.parcial2.pr2_parcial2.controller.ClienteController;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ClienteDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

import static co.edu.uniquindio.parcial2.pr2_parcial2.utils.ClienteConstantes.*;

public class ClienteViewController {
    ClienteController clienteController;
    ObservableList<ClienteDto> listaClientes = FXCollections.observableArrayList();
    ClienteDto clienteSeleccionado;

    // ----------------------------- Buttons -----------------------------
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnNuevo;
    // ----------------------------- Text Fields -----------------------------
    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtdireccion;

    // ----------------------------- Table -----------------------------

    @FXML
    private TableView<ClienteDto> tableCliente;
    @FXML
    private TableColumn<ClienteDto, String> tcApellido;
    @FXML
    private TableColumn<ClienteDto, String> tcCedula;
    @FXML
    private TableColumn<ClienteDto, String> tcDireccion;
    @FXML
    private TableColumn<ClienteDto, String> tcEmail;
    @FXML
    private TableColumn<ClienteDto, String> tcNombre;

    // ----------------------------- On Actions -----------------------------
    @FXML
    void onActualizarCliente(ActionEvent event) {
        actualizarCliente();
    }
    @FXML
    void onEliminarCliente(ActionEvent event) {
        eliminarCliente();
    }
    @FXML
    void onNuevoCliente(ActionEvent event) {
        limpiarCampos();
    }
    @FXML
    void onAgregarCliente(ActionEvent event) {
        agregarCliente();
    }

    // ----------------------------- Métodos de inicialización -----------------------------
    @FXML
    void initialize() {
        clienteController = new ClienteController();
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerClientes();
        tableCliente.getItems().clear();
        tableCliente.setItems(listaClientes);
        listenerSelection();
    }
    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombreCliente()));
        tcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().apellido()));
        tcEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().email()));
        tcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cedula()));
        tcDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().direccion()));
    }

    private void obtenerClientes() {
       listaClientes.addAll(clienteController.obtenerClientes());
    }

    private void listenerSelection() {
        tableCliente.getSelectionModel().selectedItemProperty().addListener((_, _, newSelection) -> {
            clienteSeleccionado = newSelection;
            mostrarInformacionCliente(clienteSeleccionado);
        });
    }

    private void actualizarCliente (){
        if (clienteSeleccionado != null) {
            ClienteDto actualizarCliente = crearClienteDto();
            if (datosValidos(actualizarCliente)) {
                clienteController.actualizarCliente(actualizarCliente);
                listaClientes.set(listaClientes.indexOf(clienteSeleccionado), actualizarCliente);
                mostrarInformacionCliente(actualizarCliente);
                mostrarMensaje(TITULO_CLIENTE_ACTUALIZADO,HEADER, BODY_CLIENTE_ACTUALIZADO, Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje(TITULO_INCOMPLETO, HEADER, BODY_INCOMPLETO, Alert.AlertType.WARNING);
            }
        } else {
            mostrarMensaje(TITULO_CLIENTE_NO_SELECCIONADO, HEADER, BODY_CLIENTE_NO_SELECCIONADO, Alert.AlertType.WARNING);
        }

    }

    private void eliminarCliente (){
        if (clienteSeleccionado != null) {
            clienteController.eliminarCliente(clienteSeleccionado);
            listaClientes.remove(clienteSeleccionado);
            limpiarCampos();
            mostrarMensaje(TITULO_CLIENTE_REMOVIDO, HEADER, BODY_CLIENTE_REMOVIDO, Alert.AlertType.INFORMATION);
        } else {
            mostrarMensaje(TITULO_CLIENTE_NO_REMOVIDO,HEADER, BODY_CLIENTE_NO_REMOVIDO, Alert.AlertType.WARNING);
        }

    }
    private void agregarCliente() {
        ClienteDto clienteDto = crearClienteDto();
        if(datosValidos(clienteDto) && clienteDuplicado(clienteDto)){
            if(clienteController.agregarCliente(clienteDto)){
                listaClientes.addAll(clienteDto);
                limpiarCampos();
                mostrarMensaje(TITULO_CLIENTE_AGREGADO, HEADER, BODY_CLIENTE_AGREGADO,Alert.AlertType.INFORMATION);
            }else{
                mostrarMensaje(TITULO_CLIENTE_NO_AGREGADO, HEADER, BODY_CLIENTE_NO_AGREGADO,Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje(TITULO_INCOMPLETO, HEADER, BODY_INCOMPLETO,Alert.AlertType.WARNING);
        }
    }

    private boolean clienteDuplicado(ClienteDto clienteDto) {
        boolean nombreDuplicado = listaClientes.stream().anyMatch(c ->
                c.nombreCliente().equalsIgnoreCase(clienteDto.nombreCliente()) &&
                        c.apellido().equalsIgnoreCase(clienteDto.apellido()));

        if (nombreDuplicado) {
            mostrarMensaje(TITULO_CLIENTE_NO_AGREGADO, HEADER, "Ya existe un cliente con ese nombre y apellido.", Alert.AlertType.WARNING);
            return false;
        }
        return true;
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        txtEmail.setText("");
        txtdireccion.setText("");
    }

    private ClienteDto crearClienteDto() {
        return new ClienteDto(
                txtNombre.getText(),
                txtApellido.getText(),
                txtCedula.getText(),
                txtEmail.getText(),
                txtdireccion.getText());
    }

    private boolean datosValidos(ClienteDto clienteDto) {
        return !clienteDto.nombreCliente().isBlank() &&
                !clienteDto.apellido().isBlank() &&
                !clienteDto.cedula().isBlank() &&
                !clienteDto.email().isBlank() &&
                !clienteDto.direccion().isBlank();
    }


    private void mostrarInformacionCliente(ClienteDto clienteSeleccionado) {
        if(clienteSeleccionado != null){
            txtNombre.setText(clienteSeleccionado.nombreCliente());
            txtApellido.setText(clienteSeleccionado.apellido());
            txtCedula.setText(clienteSeleccionado.cedula());
            txtEmail.setText(clienteSeleccionado.email());
            txtdireccion.setText(clienteSeleccionado.direccion());
        }
    }
    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }
    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        return action.get() == ButtonType.OK;
    }
}
