package com.example.demo.controllers;

import com.example.demo.entity.Human;
import com.example.demo.interfaces.impls.CollectionApply;
import com.example.demo.utils.TreeTableUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Controller {
    private Stage mainStage;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnEdit;

    @FXML
    private TreeTableView<Human> testTreeTable;

    private Parent fxmlEdit;
    private FXMLLoader fxmlLoader = new FXMLLoader();
    private EditController editDialogController;
    private Stage editDialogStage;

    private CollectionApply addressBookImpl = new CollectionApply();

    @FXML
    void initialize() {
        initializeTreeTable();
        initializeListeners();
        initializeController();
    }

    private void initializeTreeTable() {
        testTreeTable.setShowRoot(false);

        TreeItem<Human> rootNode = new TreeItem<>();
        rootNode.setExpanded(true);

        rootNode.getChildren().addAll(addressBookImpl.getPersonList());

        testTreeTable.setRoot(rootNode);

        testTreeTable.setEditable(false);

        TreeTableColumn<Human, String> firstNameColumn = TreeTableUtil.getNameColumn();
        TreeTableColumn<Human, String> lastNameColumn = TreeTableUtil.getLastAgeColumn();
        TreeTableColumn<Human, String> birthDateColumn = TreeTableUtil.getBirthDateColumn();
        testTreeTable.getColumns().add(firstNameColumn);
        testTreeTable.getColumns().add(lastNameColumn);
        testTreeTable.getColumns().add(birthDateColumn);
    }

    private void initializeListeners() {
        testTreeTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() > 1) {


                    Human selectedPersone = testTreeTable.getSelectionModel().getSelectedItem().getValue();
                    String date = selectedPersone.getBirthday().toString();


                    DateTimeFormatter frmt = DateTimeFormatter.ofPattern("yyyy-M-dd");
                    LocalDate dt = LocalDate.parse(date, frmt);
                    LocalDate today = LocalDate.now();

                    if (dt.getMonth() == today.getMonth() && dt.getDayOfMonth() == today.getDayOfMonth()) {

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Alert Pane");
                        alert.setHeaderText(null);
                        alert.setContentText("Birthday today!");

                        alert.showAndWait();
                    }
                }
            }
        });
    }

    private void initializeController() {
        try {
            fxmlLoader.setLocation(getClass().getResource("/fxml/edit.fxml"));
            fxmlEdit = fxmlLoader.load();
            editDialogController = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateTable() {
        testTreeTable.getRoot().getChildren().clear();
        testTreeTable.getRoot().getChildren().addAll(addressBookImpl.getPersonList());
    }

    public void actionButtonPressed(ActionEvent actionEvent) {

        Object source = actionEvent.getSource();

        if (!(source instanceof Button)) {
            return;
        }

        Button clickedButton = (Button) source;

        TreeItem<Human> selectedPerson = testTreeTable.getSelectionModel().getSelectedItem();
        switch (clickedButton.getId()) {
            case "btnAdd":
                editDialogController.setHumanForEdit(new Human());
                showDialog();
                addressBookImpl.add(editDialogController.getHuman());
                updateTable();
                break;

            case "btnEdit":
                if (selectedPerson == null) {
                    showAlert();
                    break;
                } else {
                    editDialogController.setHumanForEdit(selectedPerson.getValue());
                    showDialog();
                    addressBookImpl.edit(editDialogController.getHuman());
                    updateTable();
                }
                break;

            case "btnDelete":
                if (selectedPerson == null)
                    showAlert();
                else {
                    addressBookImpl.delete(selectedPerson.getValue());
                    updateTable();
                }
                break;
        }
    }

    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("You did not select field");

        alert.showAndWait();
    }

    private void showDialog() {

        if (editDialogStage == null) {
            editDialogStage = new Stage();
            editDialogStage.setTitle("Edit Pane");
            editDialogStage.setMinHeight(150);
            editDialogStage.setMinWidth(300);
            editDialogStage.setResizable(false);
            editDialogStage.setScene(new Scene(editDialogController.getMainAnchorPane()));
            editDialogStage.initModality(Modality.WINDOW_MODAL);
            editDialogStage.initOwner(mainStage);
        }

        editDialogStage.showAndWait(); // для ожидания закрытия окна

    }

    public CollectionApply getAddressBookImpl() {
        return addressBookImpl;
    }

}

