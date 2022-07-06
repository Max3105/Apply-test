package sample.controllers;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class EditController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BtnCancel;

    @FXML
    private Button BtnSave;

    @FXML
    void initialize() {
        assert BtnCancel != null : "fx:id=\"BtnCancel\" was not injected: check your FXML file 'Edit.fxml'.";
        assert BtnSave != null : "fx:id=\"BtnSave\" was not injected: check your FXML file 'Edit.fxml'.";

    }

}
