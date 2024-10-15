package co.edu.uniquindio.parcial2.pr2_parcial2.viewcontroller;

import co.edu.uniquindio.parcial2.pr2_parcial2.controller.AdminController;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ObjetoDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.PrestamoObjeto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AdminViewController {
    private AdminController adminController;
    private ObservableList<ObjetoDto> listaObjetos = FXCollections.observableArrayList();
    private ObjetoDto objetoSeleccionado;

    //----------------------------- List Views -----------------------------
    @FXML
    private ListView<?> listObjetosMayorPrestamos11;
    @FXML
    private ListView<ObjetoDto> listCMenorPrestamos;
    @FXML
    private ListView<ObjetoDto> listObjetosMayorPrestamos;
    @FXML
    private ListView<ObjetoDto> listObjetosMayorPrestamos1;

    //----------------------------- Table View -----------------------------
    @FXML
    private TableView<ObjetoDto> tabObjetosDND;
    @FXML
    private TableColumn<ObjetoDto,String> tcEstado;
    @FXML
    private TableColumn<ObjetoDto,String> tcNombre;
    @FXML
    private TableColumn<ObjetoDto, String> tcID;


    //----------------------------- Text Fields -----------------------------
    @FXML
    private TextField txtEstado;
    @FXML
    private TextField txtID;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCantidadObjetosMPrestamos1;
    @FXML
    private TextField txtRangoOMayorPrestamos;
    @FXML
    private TextField txtBuscarObjetoID;
    @FXML
    private TextField txtRangoCMenorPrestamos;
    @FXML
    private TextField txtRangoObjetoXID;
    @FXML
    private TextField txtCantidadObjetosMPrestamos;
    @FXML
    private TextField txtCantidadClientesMayorPrestamos;
    @FXML
    private TextField txtRangoCMayorPrestamos2;

    //----------------------------- Buttons -----------------------------
    @FXML
    private Button btnConsultarObjetosMayorPrestamos;
    @FXML
    private Button btnConsultarObjetosID;
    @FXML
    private Button btnConsultarObjetosXEstado;
    @FXML
    private Button btnConsultarClMenorPrestamos;
    @FXML
    private Button btnConsultarClientesMayorPrestamos2;


    //----------------------------- On Actions -----------------------------
    @FXML
    void onConsultarCMenorPrestamos(ActionEvent event) {
    }
    @FXML
    void onConsultarObjetosXEstado(ActionEvent event) {
    }
    @FXML
    void onConsultarObjetosMayorPrestamos(ActionEvent event) {
    }
    @FXML
    void onConsultarObjetosID(ActionEvent event) {
        PrestamoObjeto objeto = new PrestamoObjeto();
    }
    @FXML
    void onConsultarClientesMayorPrestamos(ActionEvent event) {
    }

    //---------------------------------------------------------------------------


    @FXML
    void initialize(){
        adminController= new AdminController() ;
        initView();
    }
    private void initView() {
        initDataBinding();
        ObtenerObjetos();
        tabObjetosDND.getItems().clear();
        tabObjetosDND.setItems(listaObjetos);
        listenerSelection();
    }
    private void ObtenerObjetos() {
        listaObjetos.addAll(adminController.obtenerObjetoss());

    }
    private void listenerSelection() {
        tabObjetosDND.getSelectionModel().selectedItemProperty().addListener((_,_,newSelection) -> {
            objetoSeleccionado = newSelection;
            mostrarInformacionDeObjeto(objetoSeleccionado);
        });
    }
    // Método que muestra la información del producto seleccionado en los campos de texto
    private void mostrarInformacionDeObjeto(ObjetoDto objetoSeleccionado) {
        if (objetoSeleccionado != null) {
            txtNombre.setText(objetoSeleccionado.nombre());
            txtID.setText(objetoSeleccionado.idObjeto());
            txtEstado.setText(objetoSeleccionado.estado());
        }
    }
    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcEstado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().estado()));
        tcID.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().idObjeto()));
    }


}
