package br.edu.ifba.saj.fwads.controller;
import java.util.Map;

import br.edu.ifba.saj.fwads.model.Estudante;
import br.edu.ifba.saj.fwads.model.Professor;
import br.edu.ifba.saj.fwads.service.Service;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
public class CadEstudanteController {
    @FXML
    private TextField txNome;
    @FXML
    private TextField txEmail;
    @FXML
    private TextField txCPF;

    private MasterController masterController;
    private ListEstudanteController listEstudanteController;

    private Service<Estudante> serviceEstudante = new Service<>(Estudante.class);
    
    public void setMasterController(MasterController masterController) {
        this.masterController = masterController;
    }

    public void setListEstudanteController(ListEstudanteController listAutorController) {
        this.listEstudanteController = listEstudanteController;
    }

    @FXML
    public void initialize() {
        txEmail.setText("@ifba.com");
    }

    @FXML
    private void salvar() {
        try {
            Estudante novoEstudante = new Estudante(txEmail.getText(),txNome.getText(),txCPF.getText());                      
            if(!serviceEstudante.findByMap(Map.of("cpf", novoEstudante.getCPF())).isEmpty())
                throw new Exception ("CPF já cadastrado");
            if(!serviceEstudante.findByMap(Map.of("email", novoEstudante.getEmail())).isEmpty())
                throw new Exception ("Email já cadastrado");
            novoEstudante.setDataCriacao();
            novoEstudante.setCriador((Professor)masterController.getUsuarioLogado());
            novoEstudante.setDataModificacao();
            novoEstudante.setModificador((Professor)masterController.getUsuarioLogado());
            serviceEstudante.create(novoEstudante);
            new Alert(AlertType.INFORMATION, 
            "Estudante:"+novoEstudante.getNome()+" cadastrado com sucesso").showAndWait();
            limparTela();            
        } catch (Exception e) {
            new Alert(AlertType.ERROR, e.getMessage()).showAndWait();
            e.printStackTrace();
        }        
        if (listEstudanteController!= null) {
            listEstudanteController.loadEstudanteList();
        }
    }
    @FXML
    private void limparTela() {
        txNome.setText("");
        txEmail.setText("");
        txCPF.setText("");
        //masterController.showFXMLFile("ListAutor.fxml");
        //new Alert(AlertType.INFORMATION, serviceAutor.findAll().toString()).showAndWait();
    }

}
