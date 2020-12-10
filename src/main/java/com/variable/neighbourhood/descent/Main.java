package com.variable.neighbourhood.descent;

import java.util.scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Variable Neighbourhood Descent");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter:\n 1 -> To run the example of Magic Square\n 2 -> To run the example of N Queens\n 3 -> To run the example of Dinner Party");
        String input = scanner.nextLine();
        switch (input) {
            case "1":
                com.variable.neighbourhood.descent.examples.MagicSquare.Main.main(new String[0]);
                break;
            case "2":
                com.variable.neighbourhood.descent.examples.NQueens.Main.main(new String[0]);
                break;
            case "3":
                com.variable.neighbourhood.descent.examples.DinnerParty.Main.main(new String[0]);
                break;
        }
    }
}
