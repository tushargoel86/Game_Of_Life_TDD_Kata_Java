package com.tushar.game.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class GameOfLifeTest {

    @Test
    @DisplayName("Should set a grid of size equals to provided input")
    void testForGridSize() {
        GameOfLife gameOfLife = new GameOfLife(4, 8);
        int []size = gameOfLife.size();

        assertArrayEquals(new int[] {4, 8}, size);
    }
}
