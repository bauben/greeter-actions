package de.example.greeter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void greetsByName() {
        assertEquals("Hallo, Ada!", App.greet(" Ada "));
    }

    @Test
    void greetsWorldWithoutName() {
        assertEquals("Hallo, Welt!", App.greet(""));
    }
}
