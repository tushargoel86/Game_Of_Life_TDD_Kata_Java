package com.tushar.game.tdd;

public class GameOfLife {

    boolean[][] cells;

    public GameOfLife(int row, int col) {
        cells = new boolean[row][col];
    }

    public int[] size() {
        return new int[]{cells.length, cells[0].length};
    }
}
