package com.tushar.game.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.tushar.game.tdd.CellStatus.ALIVE;

public class Cell {
    private final int row;
    private final int col;
    private List<Cell> neighbours;
    private CellStatus cellStatus;

    public Cell(int row, int col, CellStatus cellStatus) {
        this.row = row;
        this.col = col;
        this.neighbours = new ArrayList<>();
        this.cellStatus = cellStatus;
    }

    public List<Cell> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Cell> neighbours) {
        this.neighbours = neighbours;
    }

    public boolean isAlive() {
        return ALIVE.equals(cellStatus);
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

    @Override
    public String toString() {
        return "Cell{" +
                "row=" + row +
                ", col=" + col +
                ", isAlive=" + cellStatus +
                '}';
    }

    public void makeItDead() {
        cellStatus = CellStatus.DEAD;
    }

    public void makeItAlive() {
        cellStatus = ALIVE;
    }
}
