package co.edu.uniquindio.parcial2.pr2_parcial2.viewcontroller;

import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ObjetoDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.Objeto;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.PrestamoObjeto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AdminViewController {

    @FXML
    private TextField txtCantidadClientesMayorPrestamos;

    @FXML
    private TextField txtRangoCMayorPrestamos2;

    @FXML
    private Button btnConsultarObjetosMayorPrestamos;

    @FXML
    private Button btnConsultarObjetosID;

    @FXML
    private TableView<ObjetoDto> tabObjetosDND;

    @FXML
    private TextField txtRangoObjetoXID;

    @FXML
    private TextField txtCantidadObjetosMPrestamos;

    @FXML
    private ListView<?> listObjetosMayorPrestamos11;

    @FXML
    private Button btnConsultarClMenorPrestamos;

    @FXML
    private Button btnConsultarClientesMayorPrestamos2;

    @FXML
    private TextField txtBuscarObjetoID;

    @FXML
    private TextField txtRangoCMenorPrestamos;

    @FXML
    private ListView<ObjetoDto> listCMenorPrestamos;

    @FXML
    private TextField txtRangoOMayorPrestamos;

    @FXML
    private ListView<ObjetoDto> listObjetosMayorPrestamos;

    @FXML
    private ListView<ObjetoDto> listObjetosMayorPrestamos1;

    @FXML
    private TableColumn<ObjetoDto,String> tcObjetosDND;

    @FXML
    private TextField txtCantidadObjetosMPrestamos1;

    @FXML
    private Button btnConsultarObjetosXEstado;

    @FXML
    private TableColumn<ObjetoDto,String> tcNombreODND;

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

}
