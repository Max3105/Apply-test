package sample;



import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.text.AbstractDocument;

public class AddController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BtnCancel;

    @FXML
    private Button BtnSave;

    @FXML
    private TextField age_field;

    @FXML
    private DatePicker birthday_field;

    @FXML
    private TextField name_field;

    @FXML
    void initialize() {
       /* BtnSave.setOnAction(actionEvent -> {
            String nameText = name_field.getText().trim();
            String ageText = age_field.getText().trim();
            DatePicker birthdayText = (DatePicker) birthday_field.getUserData();*/

           // if(!nameText.equals("")  && !ageText.equals("") && !birthdayText.equals(""))
           //     saveUser(nameText, ageText, birthdayText);
            //    else
             //   System.out.println("jhh");
        DatabaseHandler dbHandler = new DatabaseHandler();
        BtnSave.setOnAction(actionEvent -> {
            dbHandler.saveUser(name_field.getText(), age_field.getText(), (java.sql.Date) birthday_field.getUserData());


        });

    }

   private void saveUser(String nameText, String ageText, DatePicker birthdayText) {
   }

}
