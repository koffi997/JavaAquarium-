package org.example.model;

import lombok.Getter;

import java.util.Random;

@Getter
public class Algue {
    private final String image;

    public Algue() {
        Random random = new Random();
        image = "/org/example/alguedemer"+random.nextInt(3)+".png";
        System.out.println(image);
    }
}
