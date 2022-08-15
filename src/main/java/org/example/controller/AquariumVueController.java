package org.example.controller;

import javafx.scene.control.Alert;
import org.example.model.Aquarium;
import org.example.view.AquariumVue;

public class AquariumVueController {

    Aquarium aquarium;

    public AquariumVueController(AquariumVue aquariumVue) {
        mettreVue(aquariumVue);
    }

    private void mettreVue(AquariumVue aquariumVue) {
        aquarium = aquariumVue.getAquariumComposantGraphique().getAquarium();

        aquariumVue.getAjoutPoissonBtn().setOnAction(event -> {
            int population = aquarium.ajouterPoisson();
            event.consume();
            aquariumVue.getAquariumComposantGraphique().lancer();
            if (population == aquarium.getLIMIT()) {
                aquariumVue.lancerAlert("Attention!!! vous avez atteint la limite");
            }
        });

        aquariumVue.getRetirePoissonBtn().setOnAction(event -> {
            int population = aquarium.retirerPoisson();
            event.consume();
            aquariumVue.getAquariumComposantGraphique().lancer();
            if (population == aquarium.getMIN_LIMIT()) {
                aquariumVue.lancerAlert("Attention!!! vous avez atteint la limite");

            }
        });
        aquariumVue.getAquariumComposantGraphique().initAquarium();
        aquariumVue.getAquariumComposantGraphique().lancer();

    }
}
