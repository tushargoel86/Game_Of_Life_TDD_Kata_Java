package com.tushar.game.tdd;

import java.util.List;

public class LifeDecisionRule {
    public void next(Grid grid) {
        int []size = grid.size();
        for (int i = 0; i < size[0]; i++) {
            for (int j = 0; j < size[1]; j++) {
                Cell cell = grid.fetchCell(i, j);
                List<Cell> neighbors = cell.getNeighbours();
                long count = getAliveCount(neighbors);
                if (count < 2) grid.makeCellDead(i, j);
            }
        }
    }

    private long getAliveCount(List<Cell> neighbors) {
       return neighbors.stream()
                .filter(Cell::isAlive)
                .count();
    }
}
