package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PoissonTest {
    private Poisson poisson;

    @BeforeEach
    public void prepareObjetPoisson() {
        this.poisson = new Poisson();
    }

    @Test
    public void testInitAlguePoisson() {
        assertNotNull(poisson);
        assertNotNull(poisson.getImagePath());
        assertFalse(poisson.getImagePath().isBlank());
    }
}