package org.example.model;

import lombok.Getter;


/**
 * @Aquarium gestion des propriétés direct lié à l'aquarium
 * (on pourra implémenter d'autres propriétés)
 */
@Getter
public class Aquarium {
    private int populationPoisson;
    private final String fondImagePath;

    private final int LIMIT = 15;
    private final int MIN_LIMIT = 1;

    /**
     * construit la classe avec une image par défaut
     * et la population de poisson est initialisé à 10
     */
    public Aquarium() {
        this.fondImagePath = "/org/example/aqua.png";
        populationPoisson = 3;
    }

    /**
     * permet d'augmenter le nombre de poisson dans l'aquarium
     */
    public int ajouterPoisson() {
        return populationPoisson < LIMIT ? populationPoisson += 1 : LIMIT;
    }

    /**
     * permet diminuer le nombre de poisson dans l'aquarium
     */
    public int retirerPoisson() {
        return populationPoisson > MIN_LIMIT ? populationPoisson -= 1 : MIN_LIMIT;
    }
}
