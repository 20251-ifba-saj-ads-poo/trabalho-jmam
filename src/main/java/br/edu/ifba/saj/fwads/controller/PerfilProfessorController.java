package br.edu.ifba.saj.fwads.controller;
import br.edu.ifba.saj.fwads.model.Professor;
import br.edu.ifba.saj.fwads.model.Projeto;
import br.edu.ifba.saj.fwads.service.Service;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class PerfilProfessorController {

    @FXML
    private TableColumn<Projeto, String> clnProjeto;

    @FXML
    private TableView<Projeto> tblProjeto;

    @FXML
    private TextField txNome;

    private Professor professor;
    private Service<Projeto> serviceProjeto = new Service<>(Projeto.class);
    private Service<Professor> serviceProfessor = new Service<>(Professor.class);

    private MasterController masterController;

    public void setMasterController(MasterController masterController){
        this.masterController = masterController;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
        txNome.setText(professor.getNome());
        loadList(); 
    }
       
    @FXML
    public void initialize() {
        clnProjeto.setCellValueFactory(new PropertyValueFactory<>("nome"));                  
    }
    
    public void loadList(){
        tblProjeto.setItems(FXCollections.observableList(professor.getProjeto()));
    }   

    @FXML
    void retornar(ActionEvent event) {
        masterController.showListProfessor(event);
    }

    @FXML
    void salvar(ActionEvent event) {
        professor.setNome(txNome.getText());
        serviceProfessor.update(professor);
    }

    

}