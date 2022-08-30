package com.example.demo.controllers;


import com.example.demo.entity.Human;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.ResourceBundle;

public class EditController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    @FXML
    private TextField changeAge;

    @FXML
    private DatePicker changeBirthday;

    @FXML
    private TextField changeName;

    @FXML
    private AnchorPane mainAnchorPane;
    private Human human;

    @FXML
    void initialize() {
        initializeButtonListeners();
        initializeFieldListeners();
    }

    private void initializeFieldListeners() {
        changeName.textProperty().addListener(((observableValue, s, t1) -> {
            if (!t1.isEmpty()) {
                if (!t1.matches("^[a-zA-Z ]*$")) {
                    changeName.setText(s);
                }
            }
        }));
    }

    private void initializeButtonListeners() {
        btnCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Node source = (Node) actionEvent.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.hide();
            }
        });

        btnSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                actionSave(actionEvent);
            }
        });

        changeBirthday.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showDate();
            }
        });
    }

    public void actionSave(ActionEvent actionEvent) {
        human.setName(changeName.getText());
        human.setAge(Integer.parseInt(changeAge.getText()));
        human.setBirthday(Date.valueOf(changeBirthday.getValue()));
        btnCancel.fire();
    }

    public void setHumanForEdit(Human human) {
        this.human = human;

        changeName.setText(human.getName() == null ? "" : human.getName());
        changeAge.setText(human.getAge() + "");
        changeBirthday.setValue(human.getBirthday() == null ? LocalDate.now() : human.getBirthday().toLocalDate());
    }

    private void showDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
        Calendar datebB = Calendar.getInstance();

        int year = (changeBirthday.getValue().getYear() - 1900);
        int month = (changeBirthday.getValue().getMonthValue() - 1);
        int date = (changeBirthday.getValue().getDayOfMonth());

        java.util.Date d = new java.util.Date(year, month, date);
        String str = sdf.format(d);

        //подсчет возраста
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
        LocalDate dateBirh = LocalDate.parse(str, formatter);

        LocalDate today = LocalDate.now();

        long years = ChronoUnit.YEARS.between(dateBirh, today);
        String years1 = Long.toString(years);
        changeAge.setText(years1);
    }

    public AnchorPane getMainAnchorPane() {
        return mainAnchorPane;
    }

    public Human getHuman() {
        return human;
    }
}
