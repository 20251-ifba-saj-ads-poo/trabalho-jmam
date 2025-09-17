package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.model.Estudante;
import br.edu.ifba.saj.fwads.model.Professor;
import br.edu.ifba.saj.fwads.model.Projeto;
import br.edu.ifba.saj.fwads.service.Service;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

public class PerfilProjetoController {

    @FXML
    private TableColumn<Estudante, String> clnEstudante;
    @FXML
    private TableView<Estudante> tblEstudante;
    @FXML
    private ChoiceBox<Professor> slProfessor;
    @FXML
    private TableView<Professor> tblProfessores;
    @FXML
    private TableColumn<Professor, String> clnProfessores;
    @FXML
    private TextField txNome;

    private Projeto projeto;

    private MasterController masterController;

    private Service<Projeto> serviceProjeto = new Service<>(Projeto.class);
    private Service<Professor> serviceProfessor = new Service<>(Professor.class);

    public void setMasterController(MasterController masterController){
        this.masterController = masterController;
    }
    
    void setProjeto(Projeto projeto) {
        this.projeto=projeto;
        slProfessor.setValue(projeto.getLider());
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
        clnEstudante.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
        clnProfessores.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome())); 
        loadList();
    }
    @FXML
    public void initialize() {   
            
    }
    
    public void loadList(){
        slProfessor.setItems(FXCollections.observableList(serviceProfessor.findAll()));
        tblEstudante.setItems(FXCollections.observableList(projeto.getEstudante()));
        tblProfessores.setItems(FXCollections.observableList(projeto.getProfessores()));
    }   

    @FXML
    void retornar(ActionEvent event) {
        masterController.showListProjeto(event);
    }

    @FXML
    void adicionar(ActionEvent event) {
        projeto.addProfessor(slProfessor.getSelectionModel().getSelectedItem());
        projeto.setDataModificacao();
        projeto.setModificador((Professor)masterController.getUsuarioLogado());
        serviceProjeto.update(projeto);
        loadList();
    }

    @FXML
    void salvar(ActionEvent event) {
        try {
            projeto.setNome(txNome.getText());
            projeto.setLider(slProfessor.getSelectionModel().getSelectedItem());
            projeto.setDataModificacao();
            projeto.setModificador((Professor)masterController.getUsuarioLogado());
            serviceProjeto.update(projeto);
        } catch (Exception e) {
            new Alert(AlertType.ERROR, e.getMessage()).showAndWait();
            e.printStackTrace();
        }
    }

    @FXML
    void remover(ActionEvent event) {
        if(tblProfessores.getSelectionModel().getSelectedItem()==projeto.getLider()){
            new Alert(AlertType.INFORMATION, 
            "Professor "+projeto.getLider().getNome()+" é lider do projeto e não pode ser excluido.").showAndWait();
            return;
        }
        projeto.removeProfessor(tblProfessores.getSelectionModel().getSelectedItem());
        projeto.setDataModificacao();
        projeto.setModificador((Professor)masterController.getUsuarioLogado());
        serviceProjeto.update(projeto);
        loadList();
    }

}