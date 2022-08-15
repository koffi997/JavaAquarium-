package org.example.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.model.Algue;

import java.util.Objects;
import java.util.Random;

public class AlgueComposantGraphique extends ImageView {

    public AlgueComposantGraphique(Algue algue) {
        Image image =new Image(Objects.requireNonNull(getClass().getResourceAsStream(algue.getImage())));
        this.setImage(image);

        this.setLayoutY(200);
        Random random = new Random();
        this.setLayoutX(random.nextInt(400));
    }
}
