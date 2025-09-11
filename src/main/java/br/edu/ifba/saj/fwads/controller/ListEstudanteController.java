package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.model.Estudante;
import br.edu.ifba.saj.fwads.service.Service;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListEstudanteController {
    
    @FXML
    private TableColumn<Estudante, String> clnNome;

    @FXML
    private TableColumn<Estudante, String> clnProjeto;

    @FXML
    private TableView<Estudante> tblEstudante;

    private MasterController masterController;

    public void setMasterController(MasterController masterController){
        this.masterController = masterController;
    }

    @FXML
    public void initialize() {
        clnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        clnProjeto.setCellValueFactory(new PropertyValueFactory<>("projeto"));
        loadEstudanteList();
    }

    public void loadEstudanteList(){
        tblEstudante.setItems(FXCollections.observableList(new Service(Estudante.class).findAll()));
    }

    @FXML
    void showNovo(ActionEvent event) {

    }
}
