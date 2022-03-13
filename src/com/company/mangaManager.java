package com.company;

import java.util.ArrayList;

public class mangaManager
{
private final ArrayList<mangaManager> worksList;


public mangaManager()
{
    this.worksList = new ArrayList<>();
    Manga manga1 = new Manga("Date A Live",2013, 2012);
    Manga manga2 = new Manga("Goblin Slayer", 2018, 2016);
    Manga manga3 = new Manga("Jobless Reincarnation", 2021, 2014);
    Manga manga4 = new Manga("Shingeki no Kyojin", 2013, 2009);
    Mangaka mangaka1 = new Mangaka("Rifujin na Magonote",19);
    Mangaka mangaka2 = new Mangaka("Kumo Kagyu",19);
    Mangaka mangaka3 = new Mangaka("Kōshi Tachibana",19);
    lightNovel novel1 = new lightNovel("Mushonku Tensei",2014 ,2022);
    lightNovel novel2 = new lightNovel("Goblin Slayer", 2016,2022);
    lightNovel novel3 = new lightNovel("Date A Live",2011 ,2020);
    worksList.add(manga1);
    worksList.add(manga2);
    worksList.add(manga3);
    worksList.add(manga4);
    worksList.add(mangaka1);
    worksList.add(mangaka2);
    worksList.add(mangaka3);
    worksList.add(novel1);
    worksList.add(novel2);
    worksList.add(novel3);
}
}
