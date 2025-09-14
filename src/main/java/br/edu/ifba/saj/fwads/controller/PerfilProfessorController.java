package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.model.AbstractEntity;
import br.edu.ifba.saj.fwads.model.Professor;
import br.edu.ifba.saj.fwads.model.Projeto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PerfilProfessorController {

    @FXML
    private ListView<Projeto> listProjeto;

    @FXML
    private TextField txNome;

    private Professor professor;

    private MasterController masterController;

    public void setMasterController(MasterController masterController){
        this.masterController = masterController;
    }

    @FXML
    void retornar(ActionEvent event) {
        masterController.showListProfessor(event);
    }

    @FXML
    void salvar(ActionEvent event) {
        professor.setNome(txNome.getText());
    }

    void setObjeto(AbstractEntity obj) {
        this.professor=(Professor)obj;
    }

}