package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.model.Estudante;
import br.edu.ifba.saj.fwads.model.Projeto;
import br.edu.ifba.saj.fwads.service.Service;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

public class PerfilEstudanteController {

    @FXML
    private ChoiceBox<Projeto> slProjeto;

    @FXML
    private TextField txNome;
    
    private Estudante estudante;
    private Service<Estudante> serviceEstudante = new Service<>(Estudante.class);
    private Service<Projeto> serviceProjeto = new Service<>(Projeto.class);
    private MasterController masterController;

    public void setMasterController(MasterController masterController){
        this.masterController = masterController;
    }

    void setEstudante(Estudante estudante) {
        this.estudante=estudante;
        slProjeto.setConverter(new StringConverter<Projeto>() {
            @Override
            public String toString(Projeto obj) {
                if (obj != null) {
                    return obj.getNome();
                }
                return "";
            }

            @Override
            public Projeto fromString(String stringProjeto) {
                return serviceProjeto.findAll()
                    .stream()
                    .filter(projeto -> stringProjeto.equals(projeto.getNome()))
                    .findAny()
                    .orElse(null);                
            }
        });
        txNome.setText(estudante.getNome()); 
        loadList();
    }
    @FXML
    public void initialize() {       
    }
    
    public void loadList(){
        slProjeto.setItems(FXCollections.observableList(serviceProjeto.findAll()));
    } 
    


    @FXML
    void retornar(ActionEvent event) {
        masterController.showListEstudante(event);
    }

    @FXML
    void salvar(ActionEvent event) {
        estudante.setNome(txNome.getText());
        estudante.setProjeto(slProjeto.getSelectionModel().getSelectedItem());
        serviceEstudante.update(estudante);
    }

}
