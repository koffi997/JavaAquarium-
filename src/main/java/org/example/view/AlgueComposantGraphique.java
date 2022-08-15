package org.example.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.model.Algue;

import java.io.InputStream;
import java.util.Optional;
import java.util.Random;

/**
 * cette classe gère l'algue qui n'est rien d'autre qu'une image.
 * elle se positionne dans la moitié inférieur de l'aquarium.
 *  repartie aléatoirement selon la largeur
 */
public class AlgueComposantGraphique extends ImageView {
    private final Algue algue;

    /**
     * @param algue
     * Construire graphique l'algue
     */
    public AlgueComposantGraphique(Algue algue) {
        this.algue=algue;
        chargerImage();
        this.setLayoutY(200);
        Random random = new Random();
        this.setLayoutX(random.nextInt(400));
    }

    /**
     * Charger l'image de algue
     *
     */
    private void chargerImage() {
        Optional<InputStream> resourceAsStream
                = Optional.ofNullable(getClass().getResourceAsStream(algue.getImagePath()));
        if(resourceAsStream.isPresent()){
            Image image = new Image(resourceAsStream.get());
            this.setImage(image);
        }
    }
}
