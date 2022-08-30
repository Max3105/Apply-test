package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("/fxml/sample.fxml"));
        primaryStage.setTitle("Main");
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(620);
        primaryStage.setScene(new Scene(root, 646, 460));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
