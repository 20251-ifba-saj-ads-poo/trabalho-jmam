package br.edu.ifba.saj.fwads.controller;

import java.util.Date;

import br.edu.ifba.saj.fwads.model.Feira;
import br.edu.ifba.saj.fwads.service.Service;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class ListFeiraController {
    
   /*package br.edu.ifba.saj.fwads.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListFeiraController {

    @FXML
    private TableColumn<?, ?> clnProjeto;

    @FXML
    private TableColumn<?, ?> clnTitulo;

    @FXML
    private TableColumn<?, ?> clnData;

    @FXML
    private TableView<?> tblFeira;

    @FXML
    void showNovo(ActionEvent event) {

    }

}
 */
    
    @FXML
    private TableColumn<Feira, String> clnProjeto;
    @FXML
    private TableColumn<Feira, String> clnTitulo;
    
    @FXML
    private TableColumn<Feira, Date> clnData;

    @FXML
    private TableView<Feira> tblFeira;

    private MasterController masterController;

    public void setMasterController(MasterController masterController){
        this.masterController = masterController;
    }

    @FXML
    public void initialize() {
        clnTitulo.setCellValueFactory(new PropertyValueFactory<>("nome"));
        clnData.setCellValueFactory(new PropertyValueFactory<>("data"));
        //clnProjeto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProjeto().getNome.()));
        loadFeiraList();
    }

        public void loadFeiraList(){
        tblFeira.setItems(FXCollections.observableList(new Service(Feira.class).findAll()));
    }
    @FXML
    void showNovo(ActionEvent event) {
        masterController.showPerfilFeira(event, tblFeira.getSelectionModel().getSelectedItem());
    }
}
