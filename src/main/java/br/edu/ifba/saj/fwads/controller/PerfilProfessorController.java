package br.edu.ifba.saj.fwads.controller;
import br.edu.ifba.saj.fwads.model.Professor;
import br.edu.ifba.saj.fwads.model.Projeto;
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

    private MasterController masterController;

    public void setMasterController(MasterController masterController){
        this.masterController = masterController;
    }
    
    void setObjeto(Professor obj) {
        this.professor=obj;
    }
    @FXML
    public void initialize() {
        synchronized (professor) {
        while (professor==null) {
            try {
                professor.wait(200); // Releases lock and waits
            } catch (InterruptedException e) {
                // Handle interruption
            }
        }
        // Condition is met, proceed with action
    }
        txNome.setText(professor.getNome());
        clnProjeto.setCellValueFactory(new PropertyValueFactory<>("nome"));   
        loadList();
        
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
    }

    

}