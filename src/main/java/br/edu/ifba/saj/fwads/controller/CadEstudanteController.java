package br.edu.ifba.saj.fwads.controller;
import br.edu.ifba.saj.fwads.model.Estudante;
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

    public void setListAutorController(ListEstudanteController listAutorController) {
        this.listEstudanteController = listEstudanteController;
    }

    @FXML
    private void salvarAutor() {
        Estudante novoEstudante = new Estudante(txNome.getText(),
                    txEmail.getText(),
                    txCPF.getText());
        serviceEstudante.create(novoEstudante);
        new Alert(AlertType.INFORMATION, 
        "Estudante:"+novoEstudante.getNome()+" cadastrado com sucesso").showAndWait();
        limparTela();
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
