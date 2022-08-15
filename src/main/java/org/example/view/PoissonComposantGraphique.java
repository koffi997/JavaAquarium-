package org.example.view;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.example.model.Poisson;

import java.util.Objects;
import java.util.Random;

public class PoissonComposantGraphique extends ImageView {
    private Timeline timeline;
    private final Random random = new Random();
    private double[] position;

    public PoissonComposantGraphique(Poisson poisson) {
        Image image =new Image(Objects.requireNonNull(getClass().getResourceAsStream(poisson.getImage())));
        this.setImage(image);
        init();
    }

    /**
     * initilaser le poisson dans l'aquarium
     */
    private void init(){
        //positionner  un poisson aléatoirement dans l'aquarium
        position = randomPosition();
        this.setLayoutX(position[0]);
        this.setLayoutX(position[1]);

        //initialiser l'animation
        timeline= new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);

        //faire deplacer le poisson vers un nouveau point
        goToRandomPlace();
    }

    /**
     * deplace un poisson vers une position aléatoire
     * elle est recurcive
     */
    private void goToRandomPlace() {
        double[] positionSuivante = randomPosition();

        position[0]=this.getLayoutX();
        position[1]=this.getLayoutY();

        //rotation du poisson (éviter la marche arrière)
        if(position[0] < positionSuivante[0]){
            this.setScaleX(-1);
        }else{
            this.setScaleX(1);
        }

        //inialiser le trajet
        KeyValue x = new KeyValue(this.layoutXProperty(),positionSuivante[0]);
        KeyValue y = new KeyValue(this.layoutYProperty(),positionSuivante[1]);

        //calcul la distance du parcour : racine carré de (x2-x1)² + (y2-y1)²
        //temps de parcour : t = distance / vitesse
        //afin d'avoir une vitesse constante
        double distance = Math.sqrt(Math.pow(positionSuivante[0]-position[0],2) +
                Math.pow(positionSuivante[1]-position[1],2));
        double VITESSE = 0.1;
        double temps = distance / VITESSE;
        //lancer la nouvelle animation
        timeline.stop();
        timeline.getKeyFrames().clear();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(temps),event -> goToRandomPlace(),x,y));
        this.layoutXProperty().addListener((observableValue, number, t1) -> {
            if(checkCollision()){
                //timeline.stop();

                //timeline.stop();
               goToRandomPlace();
            }else{
                System.out.println("non");
            }
        });
        timeline.play();
    }

    private boolean checkCollision() {
        System.out.println(this.getParent().getChildrenUnmodifiable().size());
        System.out.println(this.getParent().getChildrenUnmodifiable()
                .stream()
                .filter(node -> node instanceof PoissonComposantGraphique).count());

        return this.getParent().getChildrenUnmodifiable()
                .stream()
                .filter(node -> node instanceof PoissonComposantGraphique)
                .anyMatch(node -> this.getBoundsInParent().intersects(node.getBoundsInParent()));
    }

    /**
     * Choisir une position (x,y) aléatoire où aller dans l'aquarium
     */
    private double[] randomPosition() {
        double[] pos = new double[2];
        pos[0]= random.nextInt(600);//x (aquarium) - x (poisson)
        pos[1]=random.nextInt(450); //y (aquarium) - y (poisson)
        return pos;
    }
}
