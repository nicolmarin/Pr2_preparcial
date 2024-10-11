package co.edu.uniquindio.parcial2.pr2_parcial2.viewcontroller;

import co.edu.uniquindio.parcial2.pr2_parcial2.controller.ClienteController;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ClienteDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static co.edu.uniquindio.parcial2.pr2_parcial2.utils.PrestamoConstantes.*;

public class ClienteViewController {


    ClienteController clienteController;
    ObservableList<ClienteDto> listaClientes = FXCollections.observableArrayList();
    ClienteDto clienteSeleccionado;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnNuevo;

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


    @FXML
    void initialize() {
        clienteController = new ClienteController();
        initView();
    }

    @FXML
    void onAgregarCliente(ActionEvent event) {
        agregarCliente();
    }

    private void initView() {
        initDataBinding();
        obtenerClientes();
        tableCliente.getItems().clear();
        tableCliente.setItems(listaClientes);
        listenerSelection();
    }

    private void obtenerClientes() {
       listaClientes.addAll(clienteController.obtenerClientes());
    }

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().apellido()));
        tcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cedula()));
        tcEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().email()));
        tcDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().direccion()));
    }

    private void listenerSelection() {
        tableCliente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            clienteSeleccionado = newSelection;
            mostrarInformacionCliente(clienteSeleccionado);
        });
    }

    private void agregarCliente() {
        //1. Captura los datos del formulario
        //2. Armar un Dto con los datos
        ClienteDto clienteDto = crearClienteDto();
        //3.Validar campos
        if(datosValidos(clienteDto)){
            //4. Solicitar crear cliente
            if(clienteController.agregarCliente(clienteDto)){
                listaClientes.addAll(clienteDto);
                limpiarCampos();
                mostrarMensaje(TITULO_CLIENTE_AGREGADO, HEADER, BODY_CLIENTE_AGREGADO,Alert.AlertType.INFORMATION);
            }else{
                mostrarMensaje(TITULO_CLIENTE_NO_AGREGADO, HEADER, BODY_CLIENTE_NO_AGREGADO,Alert.AlertType.ERROR);
            }
        }else{
            //mensaje de notificacion de campos incompletos
            mostrarMensaje(TITULO_INCOMPLETO, HEADER, BODY_INCOMPLETO,Alert.AlertType.WARNING);
        }
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
        if(clienteDto.nombre().isBlank() ||
           clienteDto.apellido().isBlank() ||
           clienteDto.cedula().isBlank() ||
           clienteDto.email().isBlank() ||
           clienteDto.direccion().isBlank()
        ){
            return false;
        }else{
            return true;
        }
    }


    private void mostrarInformacionCliente(ClienteDto clienteSeleccionado) {
        if(clienteSeleccionado != null){
            txtNombre.setText(clienteSeleccionado.nombre());
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
        if (action.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }

    @FXML
    void onActualizarCliente(ActionEvent event) {

    }



    @FXML
    void onEliminarCliente(ActionEvent event) {

    }

    @FXML
    void onNuevoCliente(ActionEvent event) {

    }

}
