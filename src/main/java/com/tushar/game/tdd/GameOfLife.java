package com.tushar.game.tdd;

public class GameOfLife {

    Grid grid;
    LifeDecisionRule lifeDecisionRule;

    public GameOfLife(int row, int col) {
        this.grid = new Grid(row, col);
    }

    public int[] size() {
        return grid.size();
    }

    public Grid next() {
       lifeDecisionRule.next(grid);
       return grid;
    }

    public void activeCell(int row, int cell) {
        grid.makeCellActive(row, cell);
    }

}
