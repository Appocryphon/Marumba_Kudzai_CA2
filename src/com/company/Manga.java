package com.company;

public class Manga  {
    String name;
    int yearMangaStarted;
    int yearAnimeStarted;



    public Manga(String name, int yearAnimeStarted, int yearMangaStarted)
    {
        this.yearMangaStarted = yearMangaStarted;
        this.yearAnimeStarted = yearAnimeStarted;
        this.name = name;

    }

    public int compareTo(Manga o)
    {
        int bSameFirst =
                this.getYearAnimeStarted() - o.getYearAnimeStarted();

        int  bSameLast =
                this.getYearMangaStarted()- o.getYearMangaStarted();

        if(bSameFirst == bSameLast) // Both first and last names are the same
        {
            //so, compare based on age
            return this.getName().compareToIgnoreCase(o.getName());
        }

        else
        {
            return this.getName().compareToIgnoreCase(
                    o.getName());
        }
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
