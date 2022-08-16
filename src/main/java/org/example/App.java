package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import org.example.controller.AquariumVueController;
import org.example.model.Aquarium;
import org.example.view.AquariumVue;

import java.io.IOException;

/**
 * JavaFX App
 */

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Aquarium aquarium =new Aquarium();
        AquariumVue aquariumVue = new AquariumVue(aquarium);
        new AquariumVueController(aquariumVue);
        Scene scene = new Scene(aquariumVue.getParent());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("AQUARIUM");
        stage.show();
    }

    public void getToast(){

    }



    public static void main(String[] args) {
        launch();
    }

}