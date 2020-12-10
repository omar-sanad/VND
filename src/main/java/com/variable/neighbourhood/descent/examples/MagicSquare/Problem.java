package com.variable.neighbourhood.descent.examples.MagicSquare;

import com.github.freva.asciitable.AsciiTable;
import com.variable.neighbourhood.descent.Vnd;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Problem extends Vnd<Integer[][]> {
    public static final int N = 3;

    @Override
    public int cost(Integer[][] solution) {
        int cost = 0;
        for (int i = 0; i < N; i += 1) {
            if (!checkSumOfColumn(solution, i)) {
                cost++;
            } else {
                cost -= 1;
            }
        }
        for (int i = 0; i < N; i += 1) {
            if (!checkSumOfRow(solution, i)) {
                cost++;
            } else {
                cost -= 1;
            }
        }
        if (!checkSumOfUpperDiagonal(solution)) {
            cost++;
        } else {
            cost -= 1;
        }
        if (!checkSumOfLowerDiagonal(solution)) {
            cost++;
        } else {
            cost -= 1;
        }

        return cost;
    }

    @Override
    public Integer[][] getNextNeighbourOf(Integer[][] solution) {
        Integer[][] nextSolution = new Integer[N][N];
        int k = 0;
        Integer[] numbers = generateNDistinctNumbers((int) Math.pow(N, 2));
        for (int i = 0; i < N; i += 1) {
            for (int j = 0; j < N; j += 1) {
                nextSolution[i][j] = numbers[k];
                k += 1;
            }
        }
        return nextSolution;
    }

    @Override
    public void printSolution(Integer[][] solution) {
        String[][] data = new String[solution[0].length][solution[0].length];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                data[i][j] = String.format(" %d ", solution[i][j]);
        }
        System.out.println(AsciiTable.getTable(data));
    }

    private Integer[] generateNDistinctNumbers(int n) {
        Random random = new Random();
        Set<Integer> set = new LinkedHashSet<>();
        while (set.size() < n) {
            set.add(random.nextInt(n) + 1);
        }
        return set.toArray(new Integer[0]);
    }

    private boolean checkSumOfRow(Integer[][] solution, int row) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += solution[row][i];
        }
        return sum == N * (Math.pow(N, 2) + 1) / 2;
    }

    private boolean checkSumOfColumn(Integer[][] solution, int column) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += solution[i][column];
        }
        return sum == N * (Math.pow(N, 2) + 1) / 2;
    }

    private boolean checkSumOfUpperDiagonal(Integer[][] solution) {
        int sum = 0;
        sum += solution[0][0];
        sum += solution[1][1];
        sum += solution[2][2];
        return sum == N * (Math.pow(N, 2) + 1) / 2;
    }

    private boolean checkSumOfLowerDiagonal(Integer[][] solution) {
        int sum = 0;
        sum += solution[0][2];
        sum += solution[1][1];
        sum += solution[2][0];
        return sum == N * (Math.pow(N, 2) + 1) / 2;
    }
}
