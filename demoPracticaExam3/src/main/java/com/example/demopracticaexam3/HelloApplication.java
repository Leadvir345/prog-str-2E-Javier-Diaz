package com.example.demopracticaexam3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
            HelloApplication.class.getResource("/com/example/demopracticaexam3/views/contact-view.fxml")
        );
        Scene scene = new Scene(fxmlLoader.load(), 650, 550);
        stage.setTitle("Contactos de Emergencia");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
