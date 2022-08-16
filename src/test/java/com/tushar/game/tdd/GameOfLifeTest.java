package com.tushar.game.tdd;

import org.junit.jupiter.api.Disabled;
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

    @Test
    @DisplayName("All cell should be died in case of single alive node")
    void testForSingleAliveCell() {
        GameOfLife gameOfLife = new GameOfLife(4, 8);
        gameOfLife.activeCell(2,2);

        Grid grid = gameOfLife.next();

        Grid newGrid = new Grid(4, 8);

        assertArrayEquals(newGrid.cells(), grid.cells());
    }
//
//    @Disabled
//    @Test
//    @DisplayName("Cell should be died in case of less than 2 alive neighbours node")
//    void testForTwoAliveNeighbourCell() {
//        GameOfLife gameOfLife = new GameOfLife(4, 8);
//        gameOfLife.activeCell(2,2);
//        gameOfLife.activeCell(2,3);
//        Grid grid = gameOfLife.next();
//
//        assertArrayEquals(new boolean[4][8], grid.cells());
//    }
}
