package br.edu.ifba.saj.fwads.controller;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import br.edu.ifba.saj.fwads.model.Feira;
import br.edu.ifba.saj.fwads.model.Professor;
import br.edu.ifba.saj.fwads.model.Projeto;
import br.edu.ifba.saj.fwads.service.Service;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PerfilFeiraController {
    private Date data;
    @FXML
    private TableColumn<Projeto, String> clnProjeto;

    @FXML
    private DatePicker dataPicker;
    @FXML
    private ChoiceBox<Projeto> slProjeto;

    @FXML
    private TableView<Projeto> tblProjetos;

    @FXML
    private TextField txNome;
    
    private Feira feira;
    private Service<Feira> serviceFeira = new Service<>(Feira.class);
    private Service<Projeto> serviceProjeto = new Service<>(Projeto.class);
    private MasterController masterController;

    public void setMasterController(MasterController masterController){
        this.masterController = masterController;
    }

    void setFeira(Feira feira) {
        this.feira=feira;        
        loadList();
    }

    @FXML
    public void initialize() {   
        clnProjeto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
    }

    public void loadList(){
        slProjeto.setItems(FXCollections.observableList(serviceProjeto.findAll()));
        tblProjetos.setItems(FXCollections.observableList(feira.getProjetos()));
    }

    @FXML
    void dataPick(ActionEvent event) {
        LocalDate localDate = dataPicker.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        data = Date.from(instant);
    }

    @FXML
    void adicionar(ActionEvent event) {
        feira.addProjeto(slProjeto.getSelectionModel().getSelectedItem());      
        feira.setDataModificacao();
        feira.setModificador((Professor)masterController.getUsuarioLogado());
        serviceFeira.update(feira);
    }

    @FXML
    void remover(ActionEvent event) {
        feira.addProjeto(slProjeto.getSelectionModel().getSelectedItem());      
        feira.setDataModificacao();
        feira.setModificador((Professor)masterController.getUsuarioLogado());
        serviceFeira.update(feira);
    }

    @FXML
    void retornar(ActionEvent event) {
        masterController.showListFeira(event);
    }

    @FXML
    void salvar(ActionEvent event) {
        feira.setNome(txNome.getText());       
        feira.setDataModificacao();
        feira.setModificador((Professor)masterController.getUsuarioLogado());
        serviceFeira.update(feira);
    }

}
