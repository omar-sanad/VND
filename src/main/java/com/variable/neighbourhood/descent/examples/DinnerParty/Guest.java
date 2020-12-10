package com.variable.neighbourhood.descent.examples.DinnerParty;

import java.util.Objects;

public class Guest {
    private String id;
    private String gender;
    private String profession;
    private boolean set = false;
    private int table;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return id.equals(guest.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Guest(String id, String gender, String type) {
        this.id = id;
        this.gender = gender;
        this.profession = type;
    }

    public Guest(String id, String gender, String profession, int table) {
        this.id = id;
        this.gender = gender;
        this.profession = profession;
        this.table = table;
    }

    public Guest() {
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "{Gender = " + gender + ", Profession = " + profession + "}";
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String type) {
        this.profession = type;
    }

    public boolean isSet() {
        return set;
    }

    public void setSet(boolean set) {
        this.set = set;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }
}
