package com.tushar.game.tdd;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private final Cell [][]cells;

    public Grid(int row, int col) {
        cells = new Cell[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                cells[i][j] = new DeadCell(i, j);
                cells[i][j].setNeighbours(neighbours(i, j));
            }
        }
    }

    private List<Neighbour> neighbours(int row, int col) {
        int [][]directions = directions();
        List<Neighbour> neighbours = new ArrayList<>();
        for (int[] direction : directions) {
            int p = direction[0] + row;
            int q = direction[1] + col;
            if (p < 0 || p >= cells.length || q < 0 || q >= cells[0].length) {
                continue;
            }
            neighbours.add(new Neighbour(p, q));
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
        cells[row][col] = new AliveCell(row, col);
    }

    public void makeCellDead(int row, int col) {
        cells[row][col] = new DeadCell(row, col);
    }
}
