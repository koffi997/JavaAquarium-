package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AquariumTest {
    private Aquarium aquarium;
    //l'aquarium contient par défaut 3 poisson
    final int DEFAULT_POPULATION = 3;

    @BeforeEach
    public void prepareObjetAquarium() {
        this.aquarium = new Aquarium();
    }

    @Test
    public void testInitAquariumValeur() {
        assertNotNull(aquarium);
        assertNotNull(aquarium.getFondImagePath());
        assertEquals(aquarium.getPopulationPoisson(), DEFAULT_POPULATION);
    }

    @Test
    public void testPoissonRetrait() {
        int population = aquarium.retirerPoisson();
        assertEquals(aquarium.getPopulationPoisson(), population);
        assertEquals(aquarium.getPopulationPoisson(), DEFAULT_POPULATION - 1);
    }

    @Test
    public void testPoissonAjout() {
        int population = aquarium.ajouterPoisson();
        assertEquals(aquarium.getPopulationPoisson(), population);
        assertEquals(aquarium.getPopulationPoisson(), DEFAULT_POPULATION + 1);
    }
}