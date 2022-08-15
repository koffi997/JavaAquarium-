package org.example.controller;

import org.example.model.Aquarium;
import org.example.view.AquariumVue;

public class AquariumVueController {

    Aquarium aquarium;

    public AquariumVueController(AquariumVue aquariumVue) {
        mettreVue(aquariumVue);
    }

    private void mettreVue(AquariumVue aquariumVue) {

        aquariumVue.getAjoutPoissonBtn().setOnAction(event -> {
            aquariumVue.getAquariumComposantGraphique().getAquarium().ajouterPoisson();
            event.consume();
            aquariumVue.getAquariumComposantGraphique().launch();

        });

        aquariumVue.getRetirePoissonBtn().setOnAction(event -> {
            aquariumVue.getAquariumComposantGraphique().getAquarium().retirerPoisson();
            event.consume();
            aquariumVue.getAquariumComposantGraphique().launch();
        });
        aquariumVue.getAquariumComposantGraphique().launch();

    }
}
