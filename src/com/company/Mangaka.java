package com.company;

public class Mangaka
{
    String name;
    int yearBorn;
    int age;

    public Mangaka(String name, int yearBorn, int age)
    {
        this.name = name;
        this.yearBorn = yearBorn;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Mangaka{" +
                "name='" + name + '\'' +
                ", yearBorn=" + yearBorn +
                ", age=" + age +
                '}';
    }
}
