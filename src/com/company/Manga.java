package com.company;

public class Manga
{
    String name;
    String description;
    int yearMangaStarted;
    int copiesSold;
    int yearAnimeStarted;



    public Manga(String name, int yearAnimeStarted, int yearMangaStarted, int copiesSold, String description)
    {
        this.copiesSold = copiesSold;
        this.yearMangaStarted = yearMangaStarted;
        this.yearAnimeStarted = yearAnimeStarted;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Manga{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", yearMangaStarted=" + yearMangaStarted +
                ", copiesSold=" + copiesSold +
                ", yearAnimeStarted=" + yearAnimeStarted +
                '}';
    }
}
