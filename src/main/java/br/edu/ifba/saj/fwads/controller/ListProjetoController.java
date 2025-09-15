package br.edu.ifba.saj.fwads.controller;
import br.edu.ifba.saj.fwads.model.Projeto;
import br.edu.ifba.saj.fwads.service.Service;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListProjetoController {
    /*@FXML
    private TableColumn<?, ?> clnLider;

    @FXML
    private TableColumn<?, ?> clnTitulo;

    @FXML
    private TableView<?> tblProjeto;

    @FXML
    void showNovo(ActionEvent event) {

    }*/
    
    @FXML
    private TableColumn<Projeto, String> clnLider;
    @FXML
    private TableColumn<Projeto, String> clnTitulo;

    

    @FXML
    private TableView<Projeto> tblProjeto;

    private MasterController masterController;

    public void setMasterController(MasterController masterController){
        this.masterController = masterController;
    }

    @FXML
    public void initialize() {
        clnTitulo.setCellValueFactory(new PropertyValueFactory<>("nome"));
        clnLider.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLider().getNome()));
        loadProjetoList();
    }
    
    public void loadProjetoList(){
        tblProjeto.setItems(FXCollections.observableList(new Service(Projeto.class).findAll()));
    }

    @FXML
    void showNovo(ActionEvent event) { 
        
        masterController.showPerfilProjeto(event, tblProjeto.getSelectionModel().getSelectedItem()); 
        /*Stage stage = new Stage();
        Scene scene = new Scene(App.loadFXML("controller/CadProjeto.fxml"), 800, 600);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        CadProjetoController controller = (CadProjetoController) App.getController();
        controller.setListProjetoController(this);

        stage.showAndWait();*/

    }
}
