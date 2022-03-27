package com.company;

import java.util.List;

public interface UserDaoInterface
{
    public List<Manga> findAllManga() throws DaoException;

    public Manga findMangaByName(String name, int yearMangaStarted) throws DaoException;

}