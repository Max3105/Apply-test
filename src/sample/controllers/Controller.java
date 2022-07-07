package sample.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.objects.Human;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BtnAdd;

    @FXML
    private Button BtnDelete;

    @FXML
    private Button BtnEdit;

   /* @FXML
    private TreeTableColumn<String> columnName;
    @FXML
    private TreeTableColumn<Human,String> columnAge;
    @FXML
    private TreeTableColumn<Human, DatePicker> columnBirthday;
    TreeItem<Human> per1 = new TreeItem<>(new Human("Maks","20", LocalDate.of(2002,5,31)));
    TreeItem<Human> per2 = new TreeItem<>(new Human("Kate","26", LocalDate.of(1996,5,31)));
    TreeItem<Human> per3 = new TreeItem<>(new Human("Nik","26", LocalDate.of(1996,6,22)));*/


    public Controller() {
    }

    @FXML
    void initialize(){/*
        columnName.setCellValueFactory(new PropertyValueFactory<Human, String>("name"));
        columnAge.setCellValueFactory(new PropertyValueFactory<Human, String>("age"));
        columnBirthday.setCellValueFactory(new PropertyValueFactory<Human, DatePicker>("birthday"));

        addressBookImpl.getPersonList().addListener(new ListChangeListener<Human>() {
            @Override
            public void onChanged(Change<? extends Human> c) {
                updateCountLabel();
            }
        });

        addresxsBookImpl.fillTestData();

        tableAddressBook.setItems(addressBookImpl.getPersonList());*/
    } /*{
        BtnAdd.setOnAction(actionEvent -> {
            BtnAdd.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Add.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
     //   });
       // BtnAdd.setOnAction(actionEvent -> {
          //  Parent root = FXMLLoader.load(getClass().getResource("Edit.fxml"));

        BtnEdit.setOnAction(actionEvent -> {
            BtnAdd.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Edit.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

    }*/

    public void showDialog(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(("../resources/Add.fxml")));
            stage.setTitle("Create");
            stage.setMinWidth(300);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showDialog2(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(("../resources/Edit.fxml")));
            stage.setTitle("Edit");
            stage.setMinWidth(300);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
   /* static class Human {
        SimpleStringProperty nameProperty;
        SimpleStringProperty ageProperty;
        SimpleDateFormat birthdayProperty;

        public String getAgeProperty() {
            return ageProperty.get();
        }

        public SimpleStringProperty agePropertyProperty() {
            return ageProperty;
        }

        public Human(String name, String age, LocalDate birthday){
            this.nameProperty = new SimpleStringProperty(name);
            this.ageProperty = new SimpleStringProperty(age);
            this.birthdayProperty = new SimpleDateFormat(birthday);

        }


    }

    */
    public static class TreeTableUtil
    {
        @SuppressWarnings("unchecked")
        public TreeItem<Human> getModel()
        {
            // Create all persons
            // First level
            Human person1 = new Human ("Name1", "56", LocalDate.of(1930, 1, 1));

            // Second level
            Human  person2 = new Human ("Name2", "48", LocalDate.of(1956, 12, 17));
            Human  person3 = new Human ("Name3", "8", LocalDate.of(1961, 3, 1));
            Human person4 = new Human ("Name4", "7", LocalDate.of(1968, 1, 12));
            Human  person5 = new Human ("Name5", "47", LocalDate.of(1978, 4, 14));

            // Third level
            Human  person6 = new Human ("Name6", "98", LocalDate.of(1980, 5, 10));
            Human  person7 = new Human ("Name7", "5", LocalDate.of(1981, 3, 20));
            Human  person8 = new Human ("Name8", "78", LocalDate.of(1982, 6, 3));
            Human  person9 = new Human ("Name9", "8", LocalDate.of(1990, 8, 27));
            Human  person10 = new Human ("Name10", "47", LocalDate.of(1994, 5, 15));

            // Fourth level
            Human  person11 = new Human ("Name11", "74", LocalDate.of(2010, 6, 3));
            Human  person12 = new Human ("Name12", "44", LocalDate.of(2012, 10, 11));
            Human  person13 = new Human ("Name13", "46", LocalDate.of(2012, 10, 11));

            // Build nodes
            TreeItem<Human > person6Node = new TreeItem<>(person6);
            person6Node.getChildren().addAll(new TreeItem<>(person11), new TreeItem<>(person12));

            TreeItem<Human > person7Node = new TreeItem<>(person7);
            person7Node.getChildren().addAll(new TreeItem<>(person13));

            TreeItem<Human > person2Node = new TreeItem<>(person2);
            person2Node.getChildren().addAll(person6Node, new TreeItem<>(person8),person7Node);

            TreeItem<Human > person3Node = new TreeItem<>(person3);
            person3Node.getChildren().addAll(new TreeItem<>(person9), new TreeItem<>(person10));

            TreeItem<Human > person4Node = new TreeItem<>(person4);
            TreeItem<Human > person5Node = new TreeItem<>(person5);

            // Create the root node and add children
            TreeItem<Human > rootNode = new TreeItem<>(person1);
            rootNode.getChildren().addAll(person2Node, person3Node, person4Node, person5Node);

            return rootNode;
        }

        // Returns Person Id TreeTableColumn
        /*public static TreeTableColumn<Human , Integer> getIdColumn()
        {
            TreeTableColumn<Human , Integer> idColumn = new TreeTableColumn<>("Id");
            idColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("personId"));
            return idColumn;
        }*/

        // Returns First Name TreeTableColumn
        public TreeTableColumn<Human , String> getFirstNameColumn()
        {
            TreeTableColumn<Human, String> firstNameCol = new TreeTableColumn<>("Name");
            firstNameCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));
            return firstNameCol;
        }

        // Returns Last Name TreeTableColumn
        public static TreeTableColumn<Human, String> getLastNameColumn()
        {
            TreeTableColumn<Human, String> lastNameCol = new TreeTableColumn<>("Age");
            lastNameCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("age"));
            return lastNameCol;
        }

        // Returns Birth Date TreeTableColumn
        public static TreeTableColumn<Human, LocalDate> getBirthDateColumn()
        {
            TreeTableColumn<Human, LocalDate> birthDateCol = new TreeTableColumn<>("Birthday");
            birthDateCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("birthday"));
            return birthDateCol;
        }


    }
}

