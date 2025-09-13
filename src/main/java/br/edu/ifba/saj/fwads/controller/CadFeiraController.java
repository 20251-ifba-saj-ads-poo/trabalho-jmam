package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.model.Feira;
import br.edu.ifba.saj.fwads.service.Service;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class CadFeiraController {
    @FXML
    private TextField txNome;

    private MasterController masterController;
    private ListFeiraController listFeiraController;

    private Service<Feira> serviceFeira = new Service<>(Feira.class);
    
    public void setMasterController(MasterController masterController) {
        this.masterController = masterController;
    }

    public void setListFeiraController(ListFeiraController listFeiraController) {
        this.listFeiraController = listFeiraController;
    }
    
    @FXML
    void limparTela(ActionEvent event) {
        txNome.setText("");
    }

    @FXML
    void salvar(ActionEvent event) {
        Feira novoFeira = new Feira(txNome.getText());
        serviceFeira.create(novoFeira);
        new Alert(AlertType.INFORMATION, 
        "Feira:"+novoFeira.getNome()+" cadastrado com sucesso").showAndWait();
        limparTela(event);
        if (listFeiraController!= null) {
            listFeiraController.loadFeiraList();
        }
    }

}
