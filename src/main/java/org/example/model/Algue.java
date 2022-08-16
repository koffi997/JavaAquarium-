package org.example.model;

import lombok.Getter;

import java.util.Random;

/**
 * @Algue Permet de selectionner aléatoirement les algues
 * (on pourra implémenter d'autres propriétés)
 */
@Getter
public class Algue {
    private final String imagePath;

    public Algue() {
        Random random = new Random();
        imagePath = "/org/example/alguedemer" + random.nextInt(3) + ".png";
    }
}
