package com.company;

public class lightNovel extends mangaManager {
    String name;
    int yearStarted;
    int yearFinished;


    public lightNovel(String name, int yearStarted, int yearFinished)
    {
        this.name = name;
        this.yearFinished = yearFinished;
        this.yearStarted = yearStarted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearStarted() {
        return yearStarted;
    }

    public void setYearStarted(int yearStarted) {
        this.yearStarted = yearStarted;
    }

    public int getYearFinished() {
        return yearFinished;
    }

    public void setYearFinished(int yearFinished) {
        this.yearFinished = yearFinished;
    }

    @Override
    public String toString() {
        return "lightNovel{" +
                "name='" + name + '\'' +
                ", yearStarted=" + yearStarted +
                ", yearFinished=" + yearFinished +
                '}';
    }
}
