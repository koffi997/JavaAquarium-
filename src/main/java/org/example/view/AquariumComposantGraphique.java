package org.example.view;

import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import lombok.Getter;
import org.example.model.Algue;
import org.example.model.Aquarium;
import org.example.model.Poisson;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

/**
 * La reprensentation graphique de l'aquarium
 */
@Getter
public class AquariumComposantGraphique extends Group {
    private final Aquarium aquarium;
    private final Random random = new Random();
    private ImageView fond;

    private final ArrayList<PoissonComposantGraphique> poissons = new ArrayList<>();


    public AquariumComposantGraphique(Aquarium aquarium) {
        this.aquarium = aquarium;
    }

    /**
     * lancer l'aquarium avec les poissons
     */
    public void lancer() {
        AquariumComposantGraphique aqua = this;
        Platform.runLater(() -> {
            aqua.getChildren().removeIf(node -> node instanceof PoissonComposantGraphique);
            for (int i = 0; i < aquarium.getPopulationPoisson(); i++)
                construirePoisson();
        });
    }

    /**
     * initiliaser l'aquarium avec des algues et le fond
     */
    public void initAquarium() {
        chargerImage();
        this.getChildren().add(fond);
        for (int i = 0; i < 5; i++) {
            construireAlgue();
        }
    }

    /**
     * Charger l'image de fond de l'aquarium
     */
    private void chargerImage() {
        Optional<InputStream> resourceAsStream
                = Optional.ofNullable(getClass().getResourceAsStream(aquarium.getFondImagePath()));
        if (resourceAsStream.isPresent()) {
            Image image = new Image(resourceAsStream.get(), 680, 550, false, false);
            this.fond = new ImageView(image);
        } else {
            this.fond = new ImageView();
            this.fond.setFitHeight(550);
            this.fond.setFitWidth(680);
        }
    }

    /**
     * construire un composant graphique poisson dans l'aquarium
     */
    private void construirePoisson() {
        PoissonComposantGraphique pcg = new PoissonComposantGraphique(new Poisson());
        pcg.init();
        pcg.allerAPositionAleatoire(true);
        //positionner le poisson dans le plan aléatoire
        //générer un nombre aléatoire entre touts les elements de l'aquarium
        int n = random.nextInt((this.getChildren().size() - 1) + 1) + 1;
        this.getChildren().add(n, pcg);
        poissons.add(pcg);
    }

    /**
     * contruire un composant graphique algue
     */
    private void construireAlgue() {
        AlgueComposantGraphique acg = new AlgueComposantGraphique(new Algue());
        //positionner l'algue dans le plan aléatoirement
        //générer un nombre aléatoire entre tous les elements de l'aquarium
        int n = random.nextInt((this.getChildren().size() - 1) + 1) + 1;
        this.getChildren().add(n, acg);
    }
}
