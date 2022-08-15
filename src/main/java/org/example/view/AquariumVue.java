package org.example.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import lombok.Getter;
import org.example.model.Aquarium;

@Getter
public class AquariumVue {
    Button ajoutPoissonBtn = new Button("Ajouter Poisson");
    Button retirePoissonBtn = new Button("Retirer Poisson");
    AquariumComposantGraphique aquariumComposantGraphique;
    Parent vuePrincipal;

    public AquariumVue(Aquarium aquarium) {
        aquariumComposantGraphique = new AquariumComposantGraphique(aquarium);
        vuePrincipal = creationVue();

    }

    private Parent creationVue() {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(5));
        vBox.setSpacing(10);
        vBox.setStyle("-fx-background-color:green");

        vBox.getChildren().addAll(aquariumComposantGraphique, creationBouttonsVue());
        return vBox;
    }

    private HBox creationBouttonsVue() {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(5);
        ajoutPoissonBtn.setPrefSize(200, 40);
        ajoutPoissonBtn.setFont(Font.font("Verdana", FontPosture.REGULAR, 20));
        retirePoissonBtn.setPrefSize(200, 40);
        retirePoissonBtn.setFont(Font.font("Verdana", FontPosture.REGULAR, 20));
        hBox.getChildren().addAll(ajoutPoissonBtn, retirePoissonBtn);
        return hBox;
    }

    public Parent getParent() {
        return vuePrincipal;
    }

    public void lancerAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Attention");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }

}
