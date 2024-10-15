package co.edu.uniquindio.parcial2.pr2_parcial2.viewcontroller;

import co.edu.uniquindio.parcial2.pr2_parcial2.controller.AdminController;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ClienteDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ObjetoDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.Objeto;
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
    private final ObservableList<ObjetoDto> listaObjetosPorID = FXCollections.observableArrayList();
    private final ObservableList<ObjetoDto> listaObjetosMayorPrestamos = FXCollections.observableArrayList();
    private ObjetoDto objetoSeleccionado;

    //----------------------------- List Views -----------------------------
    @FXML
    private ListView<ObjetoDto> listObjetos;
    @FXML
    private ListView<ClienteDto> listBuscarClientesMayorPrestamos;
    @FXML
    private ListView<ObjetoDto> listBuscarPorID;
    @FXML
    private ListView<ObjetoDto> listObjetosMayorPrestamos;

    //----------------------------- Text Fields -----------------------------
    @FXML
    private TextField txtEstado;
    @FXML
    private TextField txtID;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtRangoOMayorPrestamos;
    @FXML
    private TextField txtBuscarObjetoID;
    @FXML
    private TextField txtCantidadClientesMayorPrestamos;

    //----------------------------- Buttons -----------------------------
    @FXML
    private Button btnConsultarObjetosMayorPrestamos;
    @FXML
    private Button btnConsultarObjetosID;
    @FXML
    private Button btnConsultarObjetosXEstado;
    @FXML
    private Button btnConsultarClientesMayorPrestamos;

    //----------------------------- On Actions -----------------------------

    @FXML
    void onConsultarObjetosXEstado(ActionEvent event) {
        consultarObjetoXEstado();
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
    void onConsultarObjetosID(ActionEvent event) {
       consultarObjetoID();
    }
    //-------------------------------------------------------------------

    private void consultarObjetoID() {
        if (!txtBuscarObjetoID.getText().isEmpty()) {
            Objeto objeto = adminController.consultarObjetoPorID(txtBuscarObjetoID.getText());
            if (objeto != null) {
                ObjetoDto objetoDto = new ObjetoDto(objeto.getIdObjeto(), objeto.getNombre(), objeto.getEstado(), objeto.getOwnedByPrestamoUq());
                listaObjetosPorID.setAll(FXCollections.observableArrayList(objetoDto));
                listBuscarPorID.setItems(listaObjetosPorID);
                mostrarMensaje("Objeto Encontrado", "Información", objeto.toString(), Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje(TITULO_OBJETO_NO_ENCONTRADO, HEADER, BODY_ID_NO_ENCONTRADO, Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje(TITULO_OBJETO_INGRESE_VALOR, HEADER, BODY_ID_NO_ENCONTRADO, Alert.AlertType.ERROR);
        }
    }
    private void consultarObjetosMayorPrestamos(){
        if (!txtRangoOMayorPrestamos.getText().isEmpty()) {
            listaObjetosMayorPrestamos.setAll(adminController.consultarObjetosMayorPrestamos(txtRangoOMayorPrestamos.getText()));
            listObjetosMayorPrestamos.setItems(listaObjetosMayorPrestamos);
        } else {
            mostrarMensaje(TITULO_OBJETO_NO_ENCONTRADO, HEADER, BODY_INGRESE_RANGO, Alert.AlertType.INFORMATION);
        }
    }
    private void consultarClientesMayorPrestamos() {
        String cantidadTexto = txtCantidadClientesMayorPrestamos.getText();
        if (!cantidadTexto.isEmpty()) {
            try {
                int cantidadPrestamos = Integer.parseInt(cantidadTexto);
                List<ClienteDto> clientes = adminController.consultarClientesMayorPrestamos(cantidadPrestamos);

                ObservableList<ClienteDto> observableClientes = FXCollections.observableArrayList(clientes);
                listaClientesMayorPrestamos.setAll(observableClientes);
                listBuscarClientesMayorPrestamos.setItems(listaClientesMayorPrestamos);
            } catch (NumberFormatException e) {
                mostrarMensaje("Entrada no válida", "Error", "Por favor, ingrese un número válido", Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje("Cantidad no ingresada", "Error", "Por favor, ingrese la cantidad de clientes", Alert.AlertType.ERROR);
        }
    }
    private void consultarObjetoXEstado() {
        if (!txtEstado.getText().isEmpty()) {
            listaObjetos.setAll(adminController.consultarObjetosPorEstado(txtEstado.getText()));
            listObjetos.setItems(listaObjetos);
        } else {
            mostrarMensaje(TITULO_OBJETO_INGRESE_VALOR, HEADER, BODY_INGRESE_ESTADO, Alert.AlertType.INFORMATION);
        }
    }

    //----------------------------- Métodos de inicialización -----------------------------
    @FXML
    void initialize() {
        adminController = new AdminController();
        initDataBinding();
        cargarObjetos();
        listenerSelection();

    }

    private void cargarObjetos() {
        listaObjetos.setAll(adminController.obtenerObjetoss());
        listObjetos.setItems(listaObjetos);
    }

    private void listenerSelection() {
        listObjetos.getSelectionModel().selectedItemProperty().addListener((_, _, newSelection) -> {
            objetoSeleccionado = newSelection;
            mostrarInformacionDeObjeto(objetoSeleccionado);
        });
    }

    private void mostrarInformacionDeObjeto(ObjetoDto objetoSeleccionado) {
        if (objetoSeleccionado != null) {
            txtNombre.setText(objetoSeleccionado.nombre());
            txtID.setText(objetoSeleccionado.idObjeto());
            txtEstado.setText(objetoSeleccionado.estado());
        }
    }

    private void initDataBinding() {
        listObjetos.setCellFactory(lv -> new ListCell<ObjetoDto>() {
            @Override
            protected void updateItem(ObjetoDto item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : "ID: " + item.idObjeto() + " - Nombre: " + item.nombre());
            }
        });

        listBuscarPorID.setCellFactory(lv -> new ListCell<ObjetoDto>() {
            @Override
            protected void updateItem(ObjetoDto item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : "ID: " + item.idObjeto() + " - Nombre: " + item.nombre());
            }
        });

        listBuscarClientesMayorPrestamos.setCellFactory(lv -> new ListCell<ClienteDto>() {
            @Override
            protected void updateItem(ClienteDto item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : "Cliente: " + item.nombreCliente());
            }
        });

        listObjetosMayorPrestamos.setCellFactory(lv -> new ListCell<ObjetoDto>() {
            @Override
            protected void updateItem(ObjetoDto item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : "ID: " + item.idObjeto() + " - Préstamos: " + item.nombre());
            }
        });
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
