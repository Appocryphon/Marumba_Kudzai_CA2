package com.company;

import java.util.List;

public interface MangaDaoInterface
{
    public List<Manga> findAllManga() throws DaoException;

    public Manga findMangaByName(String name, int yearMangaStarted) throws DaoException;
    public void deleteMangaByName(String name) throws DaoException;
    Manga addManga( Manga manga ) throws DaoException;
    public String findAllMangaJSON() throws DaoException;
    public String findMangaByNameJSON(String name, int yearMangaStarted) throws DaoException;
    public String displayEntityByIDJSON(int year_AnimeStarted) throws DaoException;
    public String displayAllEntitiesJSON() throws DaoException;
    Manga addEntityJSON( Manga manga ) throws DaoException;
    public void deleteEntityByNameJSON(String name) throws DaoException;
}