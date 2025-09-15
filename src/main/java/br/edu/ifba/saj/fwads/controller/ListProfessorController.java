package br.edu.ifba.saj.fwads.controller;
import br.edu.ifba.saj.fwads.model.Professor;
import br.edu.ifba.saj.fwads.service.Service;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
public class ListProfessorController {
    
    @FXML
    private TableColumn<Professor, String> clnNome;
    @FXML
    private TableView<Professor> tblProfessor;

    private MasterController masterController;

    public void setMasterController(MasterController masterController){
        this.masterController = masterController;
    }

    @FXML
    public void initialize() {
        clnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        loadProfessorList();
    }

    public void loadProfessorList(){
    tblProfessor.setItems(FXCollections.observableList(new Service(Professor.class).findAll()));
    }
    @FXML
    void showNovo(ActionEvent event) {
        System.out.println(tblProfessor.getSelectionModel().getSelectedItem().getNome());
        masterController.showPerfilProfessor(event, tblProfessor.getSelectionModel().getSelectedItem());                        
    }
}

