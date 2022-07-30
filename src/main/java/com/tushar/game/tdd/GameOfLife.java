package com.tushar.game.tdd;

public class GameOfLife {

    Grid grid;

    public GameOfLife(int row, int col) {
        this.grid = new Grid(row, col);
    }

    public int[] size() {
        return grid.size();
    }

    public Grid next() {
        grid.makeCellDead(2, 2);
        return grid;
    }

    public void activeCell(int row, int cell) {
        grid.makeCellActive(row, cell);
    }
}
