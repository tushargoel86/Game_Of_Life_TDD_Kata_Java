package com.tushar.game.tdd;

import java.util.Objects;

public class Neighbour {
    private int row;
    private int col;

    public Neighbour(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighbour neighbour = (Neighbour) o;
        return row == neighbour.row && col == neighbour.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
