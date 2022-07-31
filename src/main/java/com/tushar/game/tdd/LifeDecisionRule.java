package com.tushar.game.tdd;

import java.util.ArrayList;
import java.util.List;

public class LifeDecisionRule {

    public List<Neighbour> neighbours(Grid grid, int row, int col) {
        int [][]directions = directions();
        List<Neighbour> neighbours = new ArrayList<>();
        int []size = grid.size();

        for (int[] direction : directions) {
            int p = direction[0] + row;
            int q = direction[1] + col;
            if (p < 0 || p > size[0] || q < 0 || q > size[1]) {
                continue;
            }
            neighbours.add(new Neighbour(p, q));
        }
        return neighbours;
    }

    private int [][] directions() {
        return new int[][]{{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
    }

    public void next(Grid grid) {
        int []size = grid.size();
        boolean[][] cells = grid.cells();
        for (int i = 0; i < size[0]; i++) {
            for (int j = 0; j < size[1]; j++) {
                grid.makeCellDead(i, j);
//                int [][]neighbors = neighbours(i, j);
//                int count = 0;
//                for (int k = 0; k < neighbors.length; k++) {
//                    for (int l = 0; l < neighbors[0].length; l++) {
//                        if (cells[k][l]) count++;
//                    }
//                }
//                if (count < 2) grid.makeCellDead(i, j);
            }
        }
    }
}
