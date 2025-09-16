package br.edu.ifba.saj.fwads.controller;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import br.edu.ifba.saj.fwads.model.Feira;
import br.edu.ifba.saj.fwads.model.Projeto;
import br.edu.ifba.saj.fwads.service.Service;
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
    private ChoiceBox<?> slProjeto;

    @FXML
    private TableView<?> tblProjetos;

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

    }

    @FXML
    void dataPick(ActionEvent event) {
        LocalDate localDate = dataPicker.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        data = Date.from(instant);
    }

    @FXML
    void adicionar(ActionEvent event) {
        
    }

    @FXML
    void remover(ActionEvent event) {

    }

    @FXML
    void retornar(ActionEvent event) {

    }

    @FXML
    void salvar(ActionEvent event) {

    }

}
