package com.tushar.game.tdd;

public class Grid {
    private final boolean [][]cells;

    public Grid(int row, int col) {
        cells = new boolean[row][col];
    }

    public boolean[][] cells() {
        return cells;
    }

    public int[] size() {
        return new int[] {cells.length, cells[0].length};
    }

    public void makeCellActive(int row, int col) {
        cells[row][col] = true;
    }

    public void makeCellDead(int row, int col) {
        cells[row][col] = false;
    }
}
