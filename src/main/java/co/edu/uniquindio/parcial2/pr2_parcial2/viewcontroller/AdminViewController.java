package co.edu.uniquindio.parcial2.pr2_parcial2.viewcontroller;

import co.edu.uniquindio.parcial2.pr2_parcial2.controller.AdminController;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ClienteDto;
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
    private final ObservableList<ObjetoDto> listaObjetosPorID = FXCollections.observableArrayList();
    private final ObservableList<ObjetoDto> listaObjetosMayorPrestamos = FXCollections.observableArrayList();
    private ObjetoDto objetoSeleccionado;

    // ----------------------------- List Views -----------------------------
    @FXML
    private ListView<ObjetoDto> listObjetos;
    @FXML
    private ListView<ClienteDto> listBuscarClientesMayorPrestamos;
    @FXML
    private ListView<ObjetoDto> listBuscarPorID;
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
    private TextField txtBuscarObjetoID;
    @FXML
    private TextField txtCantidadClientesMayorPrestamos;

    // ----------------------------- Buttons -----------------------------
    @FXML
    private Button btnConsultarObjetosMayorPrestamos;
    @FXML
    private Button btnConsultarObjetosID;
    @FXML
    private Button btnConsultarObjetosXEstado;
    @FXML
    private Button btnConsultarClientesMayorPrestamos;

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
    void onConsultarObjetosID(ActionEvent event) {
        consultarObjetoPorID();
    }

    //-------------------------------------------------------------------
    private void consultarObjetoPorID() {
        String id = txtBuscarObjetoID.getText();
        if (validarCampoNoVacio(id, TITULO_OBJETO_INGRESE_VALOR)) {
            try {
                ObjetoDto objetoDto = adminController.consultarObjetoPorID(id);
                if (objetoDto != null) {
                    listaObjetosPorID.add(objetoDto);
                    listBuscarPorID.setItems(listaObjetosPorID);
                    mostrarMensaje("Objeto Encontrado", "Información", objetoDto.toString(), Alert.AlertType.INFORMATION);
                }
            } catch (IllegalArgumentException e) {
                mostrarMensaje(TITULO_OBJETO_NO_ENCONTRADO, HEADER, BODY_ID_NO_ENCONTRADO, Alert.AlertType.ERROR);
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
            listaObjetos.setAll(adminController.consultarObjetosPorEstado(estado));
            listObjetos.setItems(listaObjetos);
        } else {
            mostrarMensaje(TITULO_OBJETO_INGRESE_VALOR, HEADER, BODY_INGRESE_ESTADO, Alert.AlertType.INFORMATION);
        }
    }

    // ----------------------------- Métodos de inicialización -----------------------------
    @FXML
    void initialize() {
        adminController = new AdminController();
        initDataBinding();
        cargarObjetos();
        listenerSelection();
    }

    private void cargarObjetos() {
        listaObjetos.setAll(adminController.obtenerObjetos());
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
        } else {
            txtNombre.clear();
            txtID.clear();
            txtEstado.clear();
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

    private boolean validarCampoNoVacio(String texto, String tituloError) {
        if (texto.isEmpty()) {
            mostrarMensaje(tituloError, HEADER, BODY_INCOMPLETO, Alert.AlertType.ERROR);
            return false;
        }
        return true;
    }
}
