package com.variable.neighbourhood.descent.examples.DinnerParty;

import java.util.ArrayList;
import java.util.UUID;

/*
We invited 18 guests and prepared 3 round tables with 6 seats each.
1- Every guest should sit next to someone (left and right) of the opposite gender.
2- At every table, there should be one politician, one doctor, one socialite,
one coach, one teacher and one programmer.
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("We invited 18 guests and prepared 3 round tables with 6 seats each.\n" +
                "1- Every guest should sit next to someone (left and right) of the opposite gender.\n" +
                "2- At every table, there should be one politician, one doctor, one socialite,\n" +
                "one coach, one teacher and one programmer.");
        Problem problem = new Problem();
        ArrayList<Guest> guests = new ArrayList<>();
        int i = -1;
        for (int j = 0; j < 18; j += 1) {
            String id = UUID.randomUUID().toString();
            String gender = null;
            if (j < 9)
                gender = Settings.genders[0];
            else
                gender = Settings.genders[1];
            if (j % 3 == 0)
                i += 1;
            String type = Settings.professions[i];
            Guest guest = new Guest(id, gender, type);
            guests.add(guest);
        }


        System.out.println("Initial Solution :");
        problem.printSolution(guests);
        System.out.println();
        System.out.println("Working ...\n");
        ArrayList<Guest> finalSolution = problem.applyVndAlgorithm(guests, 10000000);
        System.out.println("Final Solution :");
        problem.printSolution(finalSolution);
    }
}
