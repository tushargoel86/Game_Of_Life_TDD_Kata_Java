package com.tushar.game.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LifeDecisionRuleTest {

    @Test
    @DisplayName("Should get all neighbours for a given cell")
    void shouldGetAllNeighbourForAGivenCell() {
        LifeDecisionRule rules = new LifeDecisionRule();
        Grid grid = new Grid(4, 8);
        List<Neighbour> neighbours = rules.neighbours(grid, 1, 1);
        List<Neighbour> result = List.of(new Neighbour(0, 1), new Neighbour(0, 0),
                new Neighbour(1, 0), new Neighbour(2, 0),
                new Neighbour(2, 1), new Neighbour(2, 2), new Neighbour(1, 2),
                new Neighbour(0, 2));

        assertEquals(result,  neighbours);
    }

    @Test
    @DisplayName("Should get all neighbours for a given cell present on the edges")
    void shouldGetAllNeighbourForAGivenCellPresentAtEdges() {
        LifeDecisionRule rules = new LifeDecisionRule();
        Grid grid = new Grid(4, 8);
        List<Neighbour> neighbours = rules.neighbours(grid, 0, 1);
        List<Neighbour> result = List.of(new Neighbour(0, 0),
                new Neighbour(1, 0), new Neighbour(1, 1), new Neighbour(1, 2),
                new Neighbour(0, 2));

        assertEquals(result,  neighbours);
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

    @Test
    @DisplayName("Should cell dies in case of under population - 2")
    void testForUnderPopulation2() {
        LifeDecisionRule rules = new LifeDecisionRule();
        Grid grid = new Grid(4, 8);
        grid.makeCellActive(2, 2);
        grid.makeCellActive(2, 3);
        grid.makeCellActive(1, 2);
        grid.makeCellActive(0, 1);

        rules.next(grid);
        int []gridSize = grid.size();
        boolean [][]result = new boolean[gridSize[0]][gridSize[1]];
        result[2][2] = true;
        result[2][3] = true;
        result[1][2] = true;

        assertArrayEquals(result, grid.cells());
    }
}

/**
 *  cells = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}}
 *
 *  (0, 0)    (0, 1)    (0, 2)
 *  (1, 0)    (1, 1)    (1, 2)
 *  (2, 0)    (2, 1)    (2, 2) (2, 3)
 */
