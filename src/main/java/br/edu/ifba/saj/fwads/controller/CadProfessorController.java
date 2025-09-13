package br.edu.ifba.saj.fwads.controller;
import br.edu.ifba.saj.fwads.model.Professor;
import br.edu.ifba.saj.fwads.service.Service;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class CadProfessorController {
    @FXML
    private TextField txNome;
    @FXML
    private TextField txEmail;
    @FXML
    private TextField txCPF;

    private MasterController masterController;
    private ListProfessorController listProfessorController;

    private Service<Professor> serviceProfessor = new Service<>(Professor.class);
    
    public void setMasterController(MasterController masterController) {
        this.masterController = masterController;
    }

    public void setListProfessorController(ListProfessorController listProfessorController) {
        this.listProfessorController = listProfessorController;
    }

    @FXML
    private void salvar(ActionEvent event) {
        Professor novoProfessor = new Professor(txEmail.getText(),
                    txNome.getText(),
                    txCPF.getText());
        serviceProfessor.create(novoProfessor);
        new Alert(AlertType.INFORMATION, 
        "Professor:"+novoProfessor.getNome()+" cadastrado com sucesso").showAndWait();
        limparTela(event);
        if (listProfessorController!= null) {
            listProfessorController.loadProfessorList();
        }
    }
    @FXML
    private void limparTela(ActionEvent event) {
        txNome.setText("");
        txEmail.setText("");
        txCPF.setText("");
        //masterController.showFXMLFile("ListAutor.fxml");
        //new Alert(AlertType.INFORMATION, serviceAutor.findAll().toString()).showAndWait();
    }

}