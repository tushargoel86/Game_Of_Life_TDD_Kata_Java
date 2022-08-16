package com.tushar.game.tdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grid {
    private final Cell [][]cells;

    public Grid(int row, int col) {
        cells = new Cell[row][col];
        createCell(row, col);
        createNeighbours(row, col);
    }

    private void createNeighbours(int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                cells[i][j].setNeighbours(neighbours(i, j));
            }
        }
    }

    private void createCell(int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                cells[i][j] = new Cell(i, j, CellStatus.DEAD);
            }
        }
    }

    private List<Cell> neighbours(int row, int col) {
        int [][]directions = directions();
        List<Cell> neighbours = new ArrayList<>();
        for (int[] direction : directions) {
            int p = direction[0] + row;
            int q = direction[1] + col;
            if (p < 0 || p >= cells.length || q < 0 || q >= cells[0].length) {
                continue;
            }
            neighbours.add(cells[p][q]);
        }
        return neighbours;
    }

    private int [][] directions() {
        return new int[][]{{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
    }

    public Cell[][] cells() {
        return cells;
    }

    public int[] size() {
        return new int[] {cells.length, cells[0].length};
    }

    public void makeCellActive(int row, int col) {
        Cell cell = cells[row][col];
        cell.makeItAlive();
    }

    public Cell fetchCell(int i, int j) {
        return cells[i][j];
    }
}
