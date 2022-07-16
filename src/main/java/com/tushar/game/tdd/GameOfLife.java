package com.tushar.game.tdd;

public class GameOfLife {
    private final Grid grid;

    public GameOfLife(int row, int col) {
        grid = new Grid(row, col);
    }

    public void addLife(Cell cell) {

    }

    public Grid nextGeneration() {
        return grid;
    }
}
