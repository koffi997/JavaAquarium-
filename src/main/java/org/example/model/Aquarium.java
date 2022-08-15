package org.example.model;

import lombok.Getter;


/**
 * @Aquarium
 * gestion des propriétés direct lié à l'aquarium
 * (on pourra implémenter d'autres propriétés)
 */
@Getter
public class Aquarium {
    private int populationPoisson;
    private final String fondImagePath;

    private final int LIMIT = 30;
    private final int MIN_LIMIT = 1;

    /**
     * construit la classe avec une image par défaut
     * et la population de poisson est initialisé à 10
     */
    public Aquarium() {
        this.fondImagePath = "/org/example/img.png";
        populationPoisson = 10;
    }

    /**
     * permet d'augmenter le nombre de poisson dans l'aquarium
     */
    public int ajouterPoisson(){
        System.out.println(populationPoisson + "po");
        return populationPoisson < LIMIT ? populationPoisson+=1 : LIMIT;
    }
    /**
     * permet diminuer le nombre de poisson dans l'aquarium
     */
    public int retirerPoisson(){
        System.out.println(populationPoisson + "po");
        return populationPoisson > MIN_LIMIT ? populationPoisson -= 1 : MIN_LIMIT;
    }

}
