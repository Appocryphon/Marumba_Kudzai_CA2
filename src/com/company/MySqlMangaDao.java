package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



    public class MySqlMangaDao extends MySqlDAO implements UserDaoInterface
    {

        @Override
        public List<Manga> findAllManga() throws DaoException
        {
            Connection connection = null;
            PreparedStatement ps = null;
            ResultSet resultSet = null;
            List<Manga> mangaList = new ArrayList<>();

            try
            {
                //Get connection object using the methods in the super class (MySqlDao.java)...
                connection = this.getConnection();

                String query = "SELECT * FROM USER";
                ps = connection.prepareStatement(query);

                //Using a PreparedStatement to execute SQL...
                resultSet = ps.executeQuery();
                while (resultSet.next())
                {
                    String name = resultSet.getString("MANGA_NAME");
                    int yearMangaStarted = resultSet.getInt("YEARMANGASTARTED");
                    int yearAnimeStarted = resultSet.getInt("YEARANIMESTARTED");
                    Manga u = new Manga( name, yearMangaStarted, yearAnimeStarted);
                    mangaList.add(u);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findAllMangaresultSet() " + e.getMessage());
            } finally
            {
                try
                {
                    if (resultSet != null)
                    {
                        resultSet.close();
                    }
                    if (ps != null)
                    {
                        ps.close();
                    }
                    if (connection != null)
                    {
                        freeConnection(connection);
                    }
                } catch (SQLException e)
                {
                    throw new DaoException("findAllManga() " + e.getMessage());
                }
            }
            return mangaList;     // may be empty
        }

        @Override
        public Manga findMangaByName(String manga_name, int year_MangaStarted) throws DaoException {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            Manga manga = null;
            try
            {
                connection = this.getConnection();

                String query = "SELECT * FROM USER WHERE MANGANAME = ? AND YEARMANGASTARTED = ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, manga_name);
                preparedStatement.setInt(2, year_MangaStarted);

                resultSet = preparedStatement.executeQuery();
                if (resultSet.next())
                {

                    String name = resultSet.getString("MANGA_NAME");
                    int yearMangaStarted = resultSet.getInt("YEARMANGASTARTED");
                    int yearAnimeStarted = resultSet.getInt("YEARANIMESTARTED");

                    manga = new Manga(name, yearMangaStarted, yearAnimeStarted);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findMangaByName() " + e.getMessage());
            } finally
            {
                try
                {
                    if (resultSet != null)
                    {
                        resultSet.close();
                    }
                    if (preparedStatement != null)
                    {
                        preparedStatement.close();
                    }
                    if (connection != null)
                    {
                        freeConnection(connection);
                    }
                } catch (SQLException e)
                {
                    throw new DaoException("findMangaByName() " + e.getMessage());
                }
            }
            return manga;     // reference to User object, or null value
        }
        }


