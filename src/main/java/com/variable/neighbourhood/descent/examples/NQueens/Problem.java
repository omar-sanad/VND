package com.variable.neighbourhood.descent.examples.NQueens;

import com.github.freva.asciitable.AsciiTable;
import com.variable.neighbourhood.descent.Vnd;

import java.util.ArrayList;
import java.util.Random;

public class Problem extends Vnd<Integer[][]> {
    public static final int N = 4;

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
        int[] numbers = generateNumbers();
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
        int queenNumber = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                if (solution[i][j] == 0) {
                    data[i][j] = " ";
                } else {
                    queenNumber += 1;
                    data[i][j] = "Q" + queenNumber;
                }

        }
        System.out.println(AsciiTable.getTable(data));
    }

    private int[] generateNumbers() {
        Random random = new Random();
        ArrayList<Integer> integers = new ArrayList<>();
        while (integers.size() < N * N) {
            integers.add(random.nextInt(2));
        }
        return integers.stream().mapToInt(i -> i).toArray();
    }

    private boolean checkSumOfRow(Integer[][] solution, int row) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += solution[row][i];
        }
        return sum == 1;
    }

    private boolean checkSumOfColumn(Integer[][] solution, int column) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += solution[i][column];
        }
        return sum == 1;
    }

    private boolean checkSumOfUpperDiagonal(Integer[][] solution) {
        int sum = 0;
        sum += solution[0][0];
        sum += solution[1][1];
        sum += solution[2][2];
        sum += solution[3][3];
        return sum == 1;
    }

    private boolean checkSumOfLowerDiagonal(Integer[][] solution) {
        int sum = 0;
        sum += solution[0][3];
        sum += solution[1][2];
        sum += solution[2][1];
        sum += solution[3][0];
        return sum == 1;
    }

}
