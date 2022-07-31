package com.tushar.game.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class LifeDecisionRuleTest {

    @Test
    @DisplayName("Should get all neighbours for a given cell")
    void shouldGetAllNeighbourForAGivenCell() {
        LifeDecisionRule rules = new LifeDecisionRule();
        int [][]neighbours = rules.neighbours(1, 1);

        int [][]result = new int[][]{{0, 1}, {0, 0}, {1, 0}, {2, 0}, {2, 1}, {2, 2}, {1, 2}, {0, 2}};

        assertArrayEquals(result,  neighbours);
    }

    @Test
    @DisplayName("Should cell dies in case of under population")
    void testForUnderPopulation() {
        LifeDecisionRule rules = new LifeDecisionRule();
        Grid grid = new Grid(4, 8);
        grid.makeCellActive(2, 2);
        grid.makeCellActive(2, 3);

        rules.next(grid);
        int []gridSize = grid.size();
        boolean [][]result = new boolean[gridSize[0]][gridSize[1]];

        assertArrayEquals(result, grid.cells());
    }
}

/**
 *  cells = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}}
 *
 *  (0, 0)    (0, 1)    (0, 2)
 *  (1, 0)    (1, 1)    (1, 2)
 *  (2, 0)    (2, 1)    (2, 2)
 */
