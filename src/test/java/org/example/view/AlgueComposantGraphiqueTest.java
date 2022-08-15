package org.example.view;

import org.example.model.Algue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlgueComposantGraphiqueTest {

    final double LAYOUT_MAX_X = 400;
    final double LAYOUT_Y = 200;
    private AlgueComposantGraphique algueComposantGraphique;


    @BeforeEach
    public void prepareObjetAlgueComposantGraphiqe() {
        Algue algue = new Algue();
        this.algueComposantGraphique = new AlgueComposantGraphique(algue);
    }
    @Test
    public void verifieConstructionAlgue(){
        assertNotNull(algueComposantGraphique.getImage());
        assertTrue(algueComposantGraphique.getLayoutX()< LAYOUT_MAX_X);
        assertEquals(algueComposantGraphique.getLayoutY(),LAYOUT_Y);
    }
}