package org.example.view;

import de.saxsys.javafx.test.JfxRunner;
import javafx.application.Platform;
import org.example.model.Poisson;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JfxRunner.class)
class PoissonComposantGraphiqueTest {


    private PoissonComposantGraphique poissonComposantGraphique;


    @BeforeAll
    static void prepareEnvironnement() {
        Platform.startup(() -> {
        });
    }

    @BeforeEach
    public void prepareObjetPoissonComposantGraphiqe() {
        Poisson poisson = new Poisson();
        this.poissonComposantGraphique = new PoissonComposantGraphique(poisson);
    }

    @Test
    public void testInitialisationPoisson() {
        poissonComposantGraphique.init();
        assertNotNull(poissonComposantGraphique.getImage());
        assertTrue(poissonComposantGraphique.getPosition()[0]>-1);
    }

    @Test
    public void testAllerAPositionAleatoire() {
        poissonComposantGraphique.init();
        double[] position = poissonComposantGraphique.getPosition();
        poissonComposantGraphique.allerAPositionAleatoire(false);
        assertEquals(position[0], poissonComposantGraphique.getPosition()[0]);
    }
}