package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.App;
import br.edu.ifba.saj.fwads.model.Projeto;
import br.edu.ifba.saj.fwads.service.Service;
<<<<<<< HEAD
=======
import javafx.beans.property.SimpleStringProperty;
>>>>>>> 84b5fcd43212f67e82355e545ae1b42c18f670d3
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
<<<<<<< HEAD
=======

public class ListProjetoController {
@FXML
    private TableColumn<Projeto, String> clnTitulo;

    @FXML
    private TableColumn<Projeto, String> clnLider;

    @FXML
    private TableView<Projeto> tbl;

    @FXML
    public void initialize() {
        clnTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        clnLider.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLider()));
        loadList();
    }
    
    public void loadList(){
        tbl.setItems(FXCollections.observableList(new Service(Projeto.class).findAll()));
    }

    @FXML
    void showNovo(ActionEvent event) {

        Stage stage = new Stage();
        Scene scene = new Scene(App.loadFXML("controller/CadProjeto.fxml"), 800, 600);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        CadProjetoController controller = (CadProjetoController) App.getController();
        controller.setListProjetoController(this);

        stage.showAndWait();

    }
>>>>>>> 84b5fcd43212f67e82355e545ae1b42c18f670d3

public class ListProjetoController {
    @FXML
    private TableColumn<Projeto, String> clnTitulo;

    @FXML
    private TableColumn<Projeto, String> clnLider;

    @FXML
    private TableView<Projeto> tbl;

    @FXML
    public void initialize() {
        clnTitulo.setCellValueFactory(new PropertyValueFactory<>("Titulo"));
        clnLider.setCellValueFactory(new PropertyValueFactory<>("Lider"));
        loadProjetoList();
    }
    
    public void loadProjetoList(){
        tbl.setItems(FXCollections.observableList(new Service(Projeto.class).findAll()));
    }

    @FXML
    void showNovo(ActionEvent event) {

        Stage stage = new Stage();
        Scene scene = new Scene(App.loadFXML("controller/CadLivro.fxml"), 800, 600);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        CadProjetoController controller = (CadProjetoController) App.getController();
        controller.setListProjetoController(this);

        stage.showAndWait();

    }
}
