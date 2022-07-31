package com.tushar.game.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Cell {
    private final int row;
    private final int col;
    private List<Neighbour> neighbours;
    private final boolean isAlive;

    public Cell(int row, int col, boolean isAlive) {
        this.row = row;
        this.col = col;
        this.neighbours = new ArrayList<>();
        this.isAlive = isAlive;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Neighbour> neighbours) {
        this.neighbours = neighbours;
    }

    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return row == cell.row && col == cell.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
