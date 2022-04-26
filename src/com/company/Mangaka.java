package com.company;

import java.util.ArrayList;
import java.util.List;

public class Mangaka {

    String name;
    float yearBorn;




    public Mangaka(String name, int yearBorn)
    {
        this.name = name;
        this.yearBorn = yearBorn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getYearBorn() {
        return yearBorn;
    }

    public void setYearBorn(float yearBorn) {
        this.yearBorn = yearBorn;
    }

    @Override
    public String toString() {
        return "Mangaka{" +
                "name='" + name + '\'' +
                ", yearBorn=" + yearBorn +
                '}';
    }
}
