package org.example.view;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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

    private Parent creationVue(){
        VBox vBox =new VBox();
        vBox.getChildren().addAll(aquariumComposantGraphique,creationBouttonsVue());
        return vBox;
    }
    private HBox creationBouttonsVue(){
        HBox hBox =new HBox();
        hBox.getChildren().addAll(ajoutPoissonBtn,retirePoissonBtn);
        return hBox;
    }
    public Parent getParent(){
        return vuePrincipal;
    }

}
