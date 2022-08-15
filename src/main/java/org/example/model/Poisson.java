package org.example.model;

import lombok.Getter;

/**
 * @Poisson modèle permet de manipuler les propriétés directe d'un poisson
 * (ne gère pas l'effet graphique)
 */
@Getter
public class Poisson {
    private final String imagePath;

    public Poisson(){
        imagePath = "/org/example/poi.gif";
    }
}
