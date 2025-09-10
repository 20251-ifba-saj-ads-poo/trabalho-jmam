package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.model.Projeto;
import br.edu.ifba.saj.fwads.model.Professor;
import br.edu.ifba.saj.fwads.service.Service;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

public class CadProjetoController {
    @FXML
    private TextField txTitulo;
    @FXML
    private ChoiceBox<Professor> slProfessor;

    private ListProjetoController listProjetoController;

    private Service<Projeto> serviceProjeto = new Service<>(Projeto.class);
    private Service<Professor> serviceProfessor = new Service<>(Professor.class);

    public void setListProjetoController(ListProjetoController listProjetoController) {
        this.listProjetoController = listProjetoController;
    }

    @FXML
    void salvar(ActionEvent event) {
        Projeto novoProjeto = new Projeto(txTitulo.getText(),
        slProfessor.getSelectionModel().getSelectedItem());
        serviceProjeto.create(novoProjeto);
        new Alert(AlertType.INFORMATION, 
        "Projeto:"+novoProjeto.getNome()+" cadastrado com sucesso!").showAndWait();
        limparTela();
        if (listProjetoController!=null) {
            listProjetoController.loadList();
        }
    }

    @FXML 
    private void initialize() {
        slProfessor.setConverter(new StringConverter<Professor>() {
            @Override
            public String toString(Professor obj) {
                if (obj != null) {
                    return obj.getNome() + ":" + obj.getEmail();
                }
                return "";
            }

            @Override
            public Professor fromString(String stringProfessor) {
                return serviceProfessor.findAll()
                    .stream()
                    .filter(Professor -> stringProfessor.equals(Professor.getNome() + ":" + Professor.getEmail()))
                    .findAny()
                    .orElse(null);                
            }
        });
        
        carregarLista();
    }

    @FXML
    private void limparTela() {
        txTitulo.setText("");
        slProfessor.setValue(null);
        //new Alert(AlertType.INFORMATION, serviceLivro.findAll().toString()).showAndWait();
    }

    private void carregarLista() {
        slProfessor.setItems(FXCollections.observableList(serviceProfessor.findAll()));
    }

}
