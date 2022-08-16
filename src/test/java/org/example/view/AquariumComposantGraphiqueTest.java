package org.example.view;

import javafx.application.Platform;
import org.example.model.Aquarium;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AquariumComposantGraphiqueTest {
    private AquariumComposantGraphique aquariumComposantGraphique;


    @BeforeAll
    static void prepareEnvironnement() {
        Platform.startup(() -> {
        });
    }

    @BeforeEach
    public void prepareObjetAquariumComposantGraphiqe() {
        Aquarium aquarium = new Aquarium();
        this.aquariumComposantGraphique = new AquariumComposantGraphique(aquarium);
    }

    @Test
    public void testInitAquarium() {
        aquariumComposantGraphique.initAquarium();
        assertNotNull(aquariumComposantGraphique.getFond().getImage());
        assertNotNull(aquariumComposantGraphique.getChildren());
        assertEquals(aquariumComposantGraphique.getChildren().size(), 6);
    }

    @Test
    public void testLancerAquarium() {
        aquariumComposantGraphique.initAquarium();
        aquariumComposantGraphique.lancer();
        assertNotNull(aquariumComposantGraphique.getChildren());
    }
}