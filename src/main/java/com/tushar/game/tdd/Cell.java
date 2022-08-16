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
    private static final int OVER_POPULATION_GREATER_THAN = 3;
    private static final int UNDER_POPULATION_LESS_THAN = 2;

    public Cell(int row, int col, CellStatus cellStatus) {
        this.row = row;
        this.col = col;
        this.neighbours = new ArrayList<>();
        this.cellStatus = cellStatus;
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
        return row == cell.row && col == cell.col && cellStatus == cell.cellStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col, cellStatus);
    }

    public void makeItDead() {
        cellStatus = CellStatus.DEAD;
    }

    public void makeItAlive() {
        cellStatus = ALIVE;
    }

    public void makeItDeadIfUnderPopulation() {
        long count = getAliveCount();
        if (count < UNDER_POPULATION_LESS_THAN) makeItDead();
    }

    public void makeItDeadIfOverPopulation() {
        long count = getAliveCount();
        if (count > OVER_POPULATION_GREATER_THAN) makeItDead();
    }

    private long getAliveCount() {
        return this.neighbours.stream().filter(Cell::isAlive).count();
    }
}
