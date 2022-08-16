package com.tushar.game.tdd;

public class GameOfLife {

    private final Grid grid;
    private final LifeDecisionRule lifeDecisionRule;

    public GameOfLife(int row, int col) {
        this.grid = new Grid(row, col);
        this.lifeDecisionRule = new LifeDecisionRule();
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
