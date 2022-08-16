package org.example.view;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import lombok.Getter;
import org.example.model.Poisson;

import java.io.InputStream;
import java.util.Optional;
import java.util.Random;

/**
 * Simule graphiquement le comportement d'un poisson
 */
@Getter
public class PoissonComposantGraphique extends ImageView {
    private Timeline timeline;
    private final Random random = new Random();
    private double[] position;
    private final Poisson poisson;

    public PoissonComposantGraphique(Poisson poisson) {
        this.poisson = poisson;
    }

    private void chargeImage() {
        Optional<InputStream> resourceAsStream
                = Optional.ofNullable(getClass().getResourceAsStream(poisson.getImagePath()));
        if (resourceAsStream.isPresent()) {
            Image image = new Image(resourceAsStream.get());
            this.setImage(image);
        }
    }

    /**
     * Choisir une position (x,y) aléatoire où aller dans l'aquarium
     */
    private double[] randomPosition() {
        double[] pos = new double[2];
        pos[0] = random.nextInt(585);//x (aquarium) - x (poisson)
        pos[1] = random.nextInt(450); //y (aquarium) - y (poisson)
        return pos;
    }

    /**
     * initilaser le poisson dans l'aquarium
     */
    public void init() {
        chargeImage();
        //positionner  un poisson aléatoirement dans l'aquarium
        position = randomPosition();
        this.setLayoutX(position[0]);
        this.setLayoutY(position[1]);

        //initialiser l'animation
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);

        this.layoutXProperty().addListener(observable -> {
            if (collision()) {
                timeline.stop();
                position = randomPosition();
                this.setLayoutX(position[0]);
                this.setLayoutY(position[1]);
                allerAPositionAleatoire(true);
            }
        });
    }

    /**
     * faire deplacer le poisson vers un emplacement aléatoire
     *
     * @param recursive : repète les tours du poisson dans l'aquarium.
     *                  à false le poisson s'arrète après un tour
     */
    public void allerAPositionAleatoire(boolean recursive) {
        double[] positionSuivante = randomPosition();
        position[0] = this.getLayoutX();
        position[1] = this.getLayoutY();

        //rotation du poisson (éviter la marche arrière)
        if (position[0] < positionSuivante[0]) {
            this.setScaleX(-1);
        } else {
            this.setScaleX(1);
        }

        //inialiser le trajet
        KeyValue x = new KeyValue(this.layoutXProperty(), positionSuivante[0]);
        KeyValue y = new KeyValue(this.layoutYProperty(), positionSuivante[1]);

        //calcul la distance du parcour : racine carré de (x2-x1)² + (y2-y1)²
        //temps de parcour : t = distance / vitesse
        //afin d'avoir une vitesse constante
        double distance = Math.sqrt(Math.pow(positionSuivante[0] - position[0], 2) +
                Math.pow(positionSuivante[1] - position[1], 2));
        double VITESSE = 0.1;
        double temps = distance / VITESSE;
        //lancer la nouvelle animation
        timeline.stop();
        timeline.getKeyFrames().clear();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(temps), event -> {
            if (recursive) {
                allerAPositionAleatoire(true);
            }
            position[0] = this.getLayoutX();
            position[1] = this.getLayoutY();
        }, x, y));
        timeline.play();
    }

    /**
     * @return true si le poisson est en contact avec un autre
     */
    private boolean collision() {
        if (this.getParent() != null) {
            return this.getParent()
                    .getChildrenUnmodifiable()
                    .stream()
                    .filter(node -> node instanceof PoissonComposantGraphique && !node.equals(this))
                    .anyMatch(node -> this.getBoundsInParent().intersects(node.getBoundsInParent()));
        }
        return false;
    }
}
