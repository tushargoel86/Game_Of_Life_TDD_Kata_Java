package com.tushar.game.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class LifeDecisionRuleTest {

    private LifeDecisionRule rules;

    @BeforeEach
    public void setup() {
        this.rules = new LifeDecisionRule();
    }

//    @Test
//    @DisplayName("Should get all neighbours for a given cell")
//    void shouldGetAllNeighbourForAGivenCell() {
//        Grid grid = new Grid(4, 8);
//        List<Neighbour> result = makeNeighbours(
//                new int[][]{{0, 1}, {0, 0}, {1, 0}, {2, 0}, {2, 1}, {2, 2},
//                            {1, 2}, {0, 2}});
//
//        List<Neighbour> neighbours = rules.neighbours(grid, 1, 1);
//
//        assertEquals(result,  neighbours);
//    }

//    @Test
//    @DisplayName("Should get all neighbours for a given cell present on the edges")
//    void shouldGetAllNeighbourForAGivenCellPresentAtEdges() {
//        Grid grid = new Grid(4, 8);
//        List<Neighbour> result = makeNeighbours
//                (new int[][]{{0, 0}, {1, 0}, {1, 1}, {1, 2}, {0, 2}});
//
//        List<Neighbour> neighbours = rules.neighbours(grid, 0, 1);
//
//        assertEquals(result,  neighbours);
//    }

    @Test
    @DisplayName("Should cell dies in case of under population")
    void testForUnderPopulation() {
        Grid grid = makeGridAndActiveCells(4, 8,
                new int[][]{{2, 2}, {2, 3}});

        rules.next(grid);

        Cell[][] result = getCopyOfGrid(grid, new int[][]{});

        assertArrayEquals(result, grid.cells());
    }

    @Test
    @DisplayName("Should cell dies in case of under population - 2")
    void testForUnderPopulation2() {
        Grid grid = makeGridAndActiveCells(4, 8,
                new int[][]{{2, 2}, {1, 3}, {1, 2}, {0, 1}});

        Cell[][] result = getCopyOfGrid(grid, new int[][]{{2, 2}, {1, 3}, {1, 2}});

        rules.next(grid);

        assertArrayEquals(result, grid.cells());
    }

    private Cell[][] getCopyOfGrid(Grid grid, int[][] activeCells) {
        Cell [][]cells = grid.cells();
        Arrays.stream(activeCells)
                .forEach(cell -> grid.makeCellActive(cell[0], cell[1]));
        return cells;
    }

    private Grid makeGridAndActiveCells(int row, int col, int[][] activeCells) {
        Grid grid = new Grid(row, col);
        for (int[] activeCell : activeCells) {
            grid.makeCellActive(activeCell[0], activeCell[1]);
        }
        return grid;
    }
}

/**
 *  cells = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}}
 *
 *  (0, 0)    (0, 1)    (0, 2)
 *  (1, 0)    (1, 1)    (1, 2)
 *  (2, 0)    (2, 1)    (2, 2) (2, 3)
 */
