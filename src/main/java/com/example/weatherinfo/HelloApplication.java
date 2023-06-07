package com.example.weatherinfo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Weather Info");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
        stage.getIcons().add(new Image("Sun.png"));
    }

    public static void main(String[] args) {
        launch();

    }
}