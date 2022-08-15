package org.example.view;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import lombok.Getter;
import org.example.model.Algue;
import org.example.model.Aquarium;
import org.example.model.Poisson;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

@Getter
public class AquariumComposantGraphique extends Group {
     private Aquarium aquarium;
    private final Random random = new Random();
    private final ImageView fond;

     private ArrayList<PoissonComposantGraphique> poissons = new ArrayList<>();


    public AquariumComposantGraphique(Aquarium aquarium) {
        Image image =new Image(Objects.requireNonNull(getClass().getResourceAsStream(aquarium.getFond())),680,550,false,false);
        this.fond = new ImageView(image);
        this.aquarium=aquarium;
    }
    public void launch(){
        this.getChildren().clear();
        this.getChildren().add(fond);
        System.out.println(aquarium.getPopulationPoisson()) ;

        for ( int i = 0 ;i < aquarium.getPopulationPoisson(); i++)
            construirePoisson();

        for(int i = 0; i<5;i++)
            construireAlgue();
    }

    /**
     * construire un composant graphique poisson dans l'aquarium
     */
    private void construirePoisson(){
        PoissonComposantGraphique pcg = new PoissonComposantGraphique(new Poisson());
        //positionner le poisson dans le plan aléatoire
        //générer un nombre aléatoire entre touts les elements de l'aquarium
        int n = random.nextInt((this.getChildren().size()-1)+1)+1;
        this.getChildren().add(n,pcg);
        poissons.add(pcg);
    }
    /**
     * contruire un composant graphique algue
     */
    private void construireAlgue(){
        AlgueComposantGraphique acg = new AlgueComposantGraphique(new Algue());
        //positionner l'algue dans le plan aléatoirement
        //générer un nombre aléatoire entre touts les elements de l'aquarium
        int n = random.nextInt((this.getChildren().size()-1)+1)+1;
        this.getChildren().add(n,acg);
    }
}
