package org.example.view;

import javafx.application.Platform;
import org.example.model.Poisson;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class PoissonComposantGraphiqueTest {

    private volatile PoissonComposantGraphique poissonComposantGraphique;

    @AfterEach
    public void prepareObjetPoissonComposantGraphiqe() {
        Platform.exit();
    }

    @Test
    public void testInitialisationPoisson() {
        Platform.setImplicitExit(false);
        Platform.startup(() -> {
            Poisson poisson = new Poisson();
            this.poissonComposantGraphique = new PoissonComposantGraphique(poisson);
            assertNotNull(poissonComposantGraphique.getImage());
            System.out.println(Arrays.toString(poissonComposantGraphique.getPosition()));

        });
    }

    @Test
    public void testRamdomPosition() {
        // double[] positionActuelle = poissonComposantGraphique.getPosition();
        poissonComposantGraphique.goToRandomPlace(false);
        assertNotNull(poissonComposantGraphique.getImage());
    }

}