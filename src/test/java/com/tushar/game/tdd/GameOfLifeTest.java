package com.tushar.game.tdd;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameOfLifeTest {

    @Test
    public void shouldBeDiedInCaseOfSingleLive() {
       GameOfLife gameOfLife = new GameOfLife(4, 4);
       gameOfLife.addLife(new Cell(1, 2));

       Grid grid = gameOfLife.nextGeneration();

       assertFalse(grid.hasLife(1, 2));
    }

    @Disabled
    @Test
    public void testForGridInputSizeAndLiveCells() {
        GameOfLife gameOfLife = new GameOfLife(5, 5);
        gameOfLife.addLife(new Cell(1,2));
        gameOfLife.addLife(new Cell(2,2));
        gameOfLife.addLife(new Cell(1,1));

        Grid grid = gameOfLife.nextGeneration();

        assertTrue(grid.hasLife(1, 2));
    }
}
