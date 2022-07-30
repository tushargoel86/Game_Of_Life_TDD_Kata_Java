package com.tushar.game.tdd;

public class LifeDecisionRule {

    public int[][] neighbours(int row, int col) {
        int [][]directions = directions();
        int[][] result = new int[8][2];

        for (int i = 0; i < directions.length; i++) {
            result[i][0] = directions[i][0] + row;
            result[i][1] = directions[i][1] + col;
        }
        return result;
    }

    private int [][] directions() {
        return new int[][]{{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
    }
}
