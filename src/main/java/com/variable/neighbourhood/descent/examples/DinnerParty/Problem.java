package com.variable.neighbourhood.descent.examples.DinnerParty;

import com.variable.neighbourhood.descent.Vnd;

import java.util.ArrayList;
import java.util.Collections;

public class Problem extends Vnd<ArrayList<Guest>> {
    @Override
    public int cost(ArrayList<Guest> solution) {
        int cost = 0;
        for (int j = 0; j < 3; j += 1) {
            for (Guest guest : solution) {
                if (checkNeighbourOppositeGender(solution, guest, j)) {
                    cost -= 1;
                } else {
                    cost += 1;
                }

                if (checkPoliticiansNumber(solution, j)) {
                    cost -= 1;
                } else {
                    cost += 1;
                }

                if (checkDoctorsNumber(solution, j)) {
                    cost -= 1;
                } else {
                    cost += 1;
                }

                if (checkSocialitesNumber(solution, j)) {
                    cost -= 1;
                } else {
                    cost += 1;
                }

                if (checkCoachesNumber(solution, j)) {
                    cost -= 1;
                } else {
                    cost += 1;
                }

                if (checkTeachersNumber(solution, j)) {
                    cost -= 1;
                } else {
                    cost += 1;
                }

                if (checkProgrammersNumber(solution, j)) {
                    cost -= 1;
                } else {
                    cost += 1;
                }
            }
        }


        return cost;
    }

    @Override
    public ArrayList<Guest> getNextNeighbourOf(ArrayList<Guest> solution) {
        int malesNumber = 0;
        int femalesNumber = 0;

        int politiciansNumber = 0;
        int doctorsNumber = 0;
        int socialitesNumber = 0;
        int coachesNumber = 0;
        int teachersNumber = 0;
        int programmersNumber = 0;

        for (Guest guest : solution) {
            if (guest.getProfession().equals(Settings.professions[0])) {
                politiciansNumber++;
            } else if (guest.getProfession().equals(Settings.professions[1])) {
                doctorsNumber++;
            } else if (guest.getProfession().equals(Settings.professions[2])) {
                socialitesNumber++;
            } else if (guest.getProfession().equals(Settings.professions[3])) {
                coachesNumber++;
            } else if (guest.getProfession().equals(Settings.professions[4])) {
                teachersNumber++;
            } else if (guest.getProfession().equals(Settings.professions[5])) {
                programmersNumber++;
            }
        }

        for (Guest guest : solution) {
            if (guest.getGender().equals(Settings.genders[0])) {
                malesNumber += 1;
            } else {
                femalesNumber += 1;
            }
        }
        if (malesNumber != 9 || femalesNumber != 9) {
            System.out.println("No Solution !");
            System.exit(0);
        }
        if (
                politiciansNumber != 3 ||
                        doctorsNumber != 3 ||
                        socialitesNumber != 3 ||
                        teachersNumber != 3 ||
                        coachesNumber != 3 ||
                        programmersNumber != 3
        ) {
            System.out.println("No Solution !");
            System.exit(0);
        }

        ArrayList<Guest> guests = new ArrayList<>(solution);
        Collections.shuffle(guests);
        return guests;
    }

    @Override
    public void printSolution(ArrayList<Guest> solution) {
        int number = 1;
        int i = 0, j = 1;
        for (Guest guest : solution) {
            System.out.print("The Table " + number + " -> Guest "+j + " : ");
            System.out.println(guest);
            i += 1;
            j += 1;
            if (i % 6 == 0) {
                System.out.println("\n");
                number += 1;
                j = 1;
            }
        }
    }

    private boolean checkNeighbourOppositeGender(ArrayList<Guest> guests, Guest guest, int table) {
        int position = 0;
        Guest nextGuest = null;
        for (int i = table * 6; i < table * 6 + 6; i++) {
            if (guests.get(i) == guest) {
                if (position == guests.size() - 1) {
                    position = -1;
                }
                nextGuest = guests.get(position + 1);
                break;
            }
            position += 1;
        }
        try {
            if (guest.getGender().equals(nextGuest.getGender())) {
                return false;
            }
        } catch (NullPointerException exception) {
            return true;
        }
        return true;
    }

    private boolean checkPoliticiansNumber(ArrayList<Guest> guests, int table) {
        int number = 0;
        for (int i = table * 6; i < table * 6 + 6; i++) {
            if (guests.get(i).getProfession().equals(Settings.professions[0])) {
                number += 1;
            }
        }
        return number == 1;
    }

    private boolean checkDoctorsNumber(ArrayList<Guest> guests, int table) {
        int number = 0;
        for (int i = table * 6; i < table * 6 + 6; i++) {
            if (guests.get(i).getProfession().equals(Settings.professions[1])) {
                number += 1;
            }
        }
        return number == 1;
    }

    private boolean checkSocialitesNumber(ArrayList<Guest> guests, int table) {
        int number = 0;
        for (int i = table * 6; i < table * 6 + 6; i++) {
            if (guests.get(i).getProfession().equals(Settings.professions[2])) {
                number += 1;
            }
        }
        return number == 1;
    }

    private boolean checkCoachesNumber(ArrayList<Guest> guests, int table) {
        int number = 0;
        for (int i = table * 6; i < table * 6 + 6; i++) {
            if (guests.get(i).getProfession().equals(Settings.professions[3])) {
                number += 1;
            }
        }
        return number == 1;
    }

    private boolean checkTeachersNumber(ArrayList<Guest> guests, int table) {
        int number = 0;
        for (int i = table * 6; i < table * 6 + 6; i++) {
            if (guests.get(i).getProfession().equals(Settings.professions[4])) {
                number += 1;
            }
        }
        return number == 1;
    }

    private boolean checkProgrammersNumber(ArrayList<Guest> guests, int table) {
        int number = 0;
        for (int i = table * 6; i < table * 6 + 6; i++) {
            if (guests.get(i).getProfession().equals(Settings.professions[5])) {
                number += 1;
            }
        }
        return number == 1;
    }

}
