package com.variable.neighbourhood.descent.examples.NQueens;

/*
We placed 4 chess queens on an 4×4 chessboard so that no two queens attack each other.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("We placed 4 chess queens on an 4×4 chessboard so that no two queens attack each other.");
        Problem problem = new Problem();
        Integer[][] initialSolution = new Integer[Problem.N][Problem.N];
        for (int i = 0; i < Problem.N; i += 1) {
            for (int j = 0; j < Problem.N; j += 1) {
                initialSolution[i][j] = 0;
            }
        }
        for (int i = 0; i < Problem.N; i += 1) {
            initialSolution[0][i] = 1;
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
