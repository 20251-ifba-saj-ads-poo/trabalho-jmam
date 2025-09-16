package br.edu.ifba.saj.fwads.controller;


import br.edu.ifba.saj.fwads.model.Professor;
import br.edu.ifba.saj.fwads.model.Projeto;
import br.edu.ifba.saj.fwads.service.Service;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

public class CadProjetoController {
    
    @FXML
    private Label lbISBN;
    
    @FXML
    private TextField txTitulo;
    @FXML
    private ChoiceBox<Professor> slProfessor;

    private MasterController masterController;
    private ListProjetoController listProjetoController;

    private Service<Projeto> serviceProjeto = new Service<>(Projeto.class);
    private Service<Professor> serviceProfessor = new Service<>(Professor.class);

    public void setListProjetoController(ListProjetoController listProjetoController) {
        this.listProjetoController = listProjetoController;
    }

    public void setMasterController(MasterController masterController) {
        this.masterController = masterController;
    }

    @FXML
    void salvar(ActionEvent event) {

        Projeto novoProjeto = new Projeto(txTitulo.getText(),
        slProfessor.getSelectionModel().getSelectedItem());
        novoProjeto.setDataCriacao();
        novoProjeto.setCriador((Professor)masterController.getUsuarioLogado());
        novoProjeto.setDataModificacao();
        novoProjeto.setModificador((Professor)masterController.getUsuarioLogado());
        serviceProjeto.create(novoProjeto);
        new Alert(AlertType.INFORMATION, 
        "Projeto:"+novoProjeto.getNome()+" cadastrado com sucesso!").showAndWait();

        limparTela(event);
        if (listProjetoController!=null) {
            listProjetoController.loadProjetoList();
        }
    }

    @FXML 
    private void initialize() {
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
            carregarListaProfessores();     
    }
        


    @FXML
    private void limparTela(ActionEvent event) {
        txTitulo.setText("");
        slProfessor.setValue(null);
        //new Alert(AlertType.INFORMATION, serviceLivro.findAll().toString()).showAndWait();
    }

    private void carregarListaProfessores() {
        slProfessor.setItems(FXCollections.observableList(serviceProfessor.findAll()));
    }
}
