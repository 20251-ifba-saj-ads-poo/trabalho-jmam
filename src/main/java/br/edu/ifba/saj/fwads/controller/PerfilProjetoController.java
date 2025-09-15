package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.model.Professor;
import br.edu.ifba.saj.fwads.model.Projeto;
import br.edu.ifba.saj.fwads.service.Service;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;

public class PerfilProjetoController {

    @FXML
    private ChoiceBox<Professor> slProfessor;

    @FXML
    private TextField txNome;

    private Projeto projeto;

    private MasterController masterController;

    private Service<Projeto> serviceProjeto = new Service<>(Projeto.class);
    private Service<Professor> serviceProfessor = new Service<>(Professor.class);

    public void setMasterController(MasterController masterController){
        this.masterController = masterController;
    }
    
    void setObjeto(Projeto obj) {
        this.projeto=obj;
    }
    @FXML
    public void initialize() {
        slProfessor.setConverter(new StringConverter<Professor>() {
            @Override
            public String toString(Professor obj) {
                if (obj != null) {
                    return obj.getNome();
                }
                return "";
            }

            @Override
            public Professor fromString(String stringProfessor) {
                return serviceProfessor.findAll()
                    .stream()
                    .filter(professor -> stringProfessor.equals(professor.getNome()))
                    .findAny()
                    .orElse(null);                
            }
        });

        txNome.setText(projeto.getNome());  
        loadList();
        
    }
    
    public void loadList(){
        slProfessor.setItems(FXCollections.observableList(serviceProfessor.findAll()));
    }   

    @FXML
    void retornar(ActionEvent event) {
        masterController.showListProjeto(event);
    }

    @FXML
    void salvar(ActionEvent event) {

    }

}