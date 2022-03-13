package com.company;

public class Manga extends mangaManager {
    String name;
    int yearMangaStarted;
    int yearAnimeStarted;



    public Manga(String name, int yearAnimeStarted, int yearMangaStarted)
    {
        this.yearMangaStarted = yearMangaStarted;
        this.yearAnimeStarted = yearAnimeStarted;
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearMangaStarted() {
        return yearMangaStarted;
    }

    public void setYearMangaStarted(int yearMangaStarted) {
        this.yearMangaStarted = yearMangaStarted;
    }


    public int getYearAnimeStarted() {
        return yearAnimeStarted;
    }

    public void setYearAnimeStarted(int yearAnimeStarted) {
        this.yearAnimeStarted = yearAnimeStarted;
    }

    @Override
    public String toString() {
        return "Manga{" +
                "name='" + name + '\'' +
                ", yearMangaStarted=" + yearMangaStarted +
                ", yearAnimeStarted=" + yearAnimeStarted +
                '}';
    }
}
