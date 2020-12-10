package com.variable.neighbourhood.descent;

public abstract class Vnd<K> {

    public abstract int cost(K solution);

    public abstract K getNextNeighbourOf(K solution);

    public abstract void printSolution(K solution);

    public K applyVndAlgorithm(K initialSolution, long maxIterations) {
        int iteration = 1;
        K solution = initialSolution;
        while (iteration <= maxIterations) {
            int cost = cost(solution);
            K newSolution = getNextNeighbourOf(solution);
            int newCost = cost(newSolution);
            if (newCost < cost) {
                solution = newSolution;
                iteration = 1;
            } else {
                iteration += 1;
            }
        }
        return solution;
    }
}
