package com.example.demo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import com.example.demo.objects.Human;

import java.io.IOException;
import java.net.URL;
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

    @FXML
    private TreeTableView<Human> testTreeTable;



    public Controller() {
    }

    @FXML
    void initialize() {

        TreeItem<Human> rootNode = TreeTableUtil.getModel();
        rootNode.setExpanded(true);

        testTreeTable.setRoot(rootNode);

        testTreeTable.setEditable(false);

        TreeTableColumn<Human, String> firstNameColumn = TreeTableUtil.getFirstNameColumn();
        firstNameColumn.setCellFactory(TextFieldTreeTableCell.<Human>forTreeTableColumn());

        TreeTableColumn<Human, String> lastNameColumn = TreeTableUtil.getLastNameColumn();
        lastNameColumn.setCellFactory(TextFieldTreeTableCell.<Human>forTreeTableColumn());

        TreeTableColumn<Human, String> birthDateColumn = TreeTableUtil.getBirthDateColumn();
        birthDateColumn.setCellFactory(TextFieldTreeTableCell.<Human>forTreeTableColumn());

        testTreeTable.getColumns().add(firstNameColumn);
        testTreeTable.getColumns().add(lastNameColumn);
        testTreeTable.getColumns().add(birthDateColumn);


    }

    public void showDialog(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(("../resources/Add.fxml")));
            stage.setTitle("Create");
            stage.setMinWidth(300);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.show();

        } catch (IOException e) {
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
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static class TreeTableUtil {
        @SuppressWarnings("unchecked")
        public static TreeItem<Human> getModel() {
            // Create all persons
            // First level
            Human person1 = new Human("Name1", "56", "LocalDate.of(1930, 1, 1)");

            // Second level
            Human person2 = new Human("Name2", "48", "LocalDate.of(1930, 1, 1)");
            Human person3 = new Human("Name3", "8", "LocalDate.of(1930, 1, 1)");
            Human person4 = new Human("Name4", "7", "LocalDate.of(1930, 1, 1)");
            Human person5 = new Human("Name5", "47", "LocalDate.of(1930, 1, 1)");

            // Third level
            Human person6 = new Human("Name6", "98", "LocalDate.of(1930, 1, 1)");
            Human person7 = new Human("Name7", "5", "LocalDate.of(1930, 1, 1)");
            Human person8 = new Human("Name8", "78", "LocalDate.of(1930, 1, 1)");
            Human person9 = new Human("Name9", "8", "LocalDate.of(1930, 1, 1)");
            Human person10 = new Human("Name10", "47", "LocalDate.of(1930, 1, 1)");

            // Fourth level
            Human person11 = new Human("Name11", "74", "LocalDate.of(1930, 1, 1)");
            Human person12 = new Human("Name12", "44", "LocalDate.of(1930, 1, 1)");
            Human person13 = new Human("Name13", "46", "LocalDate.of(1930, 1, 1)");

            // Build nodes
            TreeItem<Human> person6Node = new TreeItem<>(person6);
            person6Node.getChildren().addAll(new TreeItem<>(person11), new TreeItem<>(person12));

            TreeItem<Human> person7Node = new TreeItem<>(person7);
            person7Node.getChildren().addAll(new TreeItem<>(person13));

            TreeItem<Human> person2Node = new TreeItem<>(person2);
            person2Node.getChildren().addAll(person6Node, new TreeItem<>(person8), person7Node);

            TreeItem<Human> person3Node = new TreeItem<>(person3);
            person3Node.getChildren().addAll(new TreeItem<>(person9), new TreeItem<>(person10));

            TreeItem<Human> person4Node = new TreeItem<>(person4);
            TreeItem<Human> person5Node = new TreeItem<>(person5);

            // Create the root node and add children
            TreeItem<Human> rootNode = new TreeItem<>(person1);
            rootNode.getChildren().addAll(person2Node, person3Node, person4Node, person5Node);

            return rootNode;
        }


        // Returns First Name TreeTableColumn
        public static TreeTableColumn<Human, String> getFirstNameColumn() {
            TreeTableColumn<Human, String> firstNameCol = new TreeTableColumn<>("name");
            firstNameCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));
            return firstNameCol;
        }

        // Returns Last Name TreeTableColumn
        public static TreeTableColumn<Human, String> getLastNameColumn() {
            TreeTableColumn<Human, String> lastNameCol = new TreeTableColumn<>("age");
            lastNameCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("age"));
            return lastNameCol;
        }

        // Returns Birth Date TreeTableColumn
        public static TreeTableColumn<Human, String> getBirthDateColumn() {
            TreeTableColumn<Human, String> birthDateCol = new TreeTableColumn<>("birthday");
            birthDateCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("birthday"));
            return birthDateCol;
        }


    }
}

