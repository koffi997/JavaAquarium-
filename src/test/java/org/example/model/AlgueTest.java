package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlgueTest {
    private Algue algue;

    @BeforeEach
    public void prepareObjetAlgue(){
        this.algue =new Algue();
    }
    @Test
    public void testInitAlgueValeur(){
        assertNotNull(algue);
        assertNotNull(algue.getImagePath());
        assertFalse(algue.getImagePath().isBlank());
    }
}