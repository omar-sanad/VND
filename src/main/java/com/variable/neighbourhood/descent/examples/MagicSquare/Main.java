package com.variable.neighbourhood.descent.examples.MagicSquare;

/*
A magic square of order n (3 in this case) is an arrangement of n2 numbers (9 in this case),
usually distinct integers, in a square, such that the n numbers in all rows,
all columns, and both diagonals sum to the same constant (15 in this case).
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("A magic square of order n (3 in this case) is an arrangement of n2 numbers (9 in this case),\n" +
                "usually distinct integers, in a square, such that the n numbers in all rows,\n" +
                "all columns, and both diagonals sum to the same constant (15 in this case).");
        Problem problem = new Problem();
        Integer[][] initialSolution = new Integer[Problem.N][Problem.N];
        int value = 1;
        for (int i = 0; i < Problem.N; i += 1) {
            for (int j = 0; j < Problem.N; j += 1) {
                initialSolution[i][j] = value;
                value += 1;
            }
        }
        System.out.println("Initial Solution :");
        problem.printSolution(initialSolution);
        System.out.println();
        System.out.println("Working ...\n");
        Integer[][] finalSolution = problem.applyVndAlgorithm(initialSolution, 10000000);
        System.out.println("Final Solution :");
        problem.printSolution(finalSolution);
    }
}
