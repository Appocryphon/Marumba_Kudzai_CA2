package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


    public class MySqlMangaDao extends MySqlDAO implements MangaDaoInterface
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
                    int yearMangaStarted = resultSet.getInt("YEAR_MANGA_STARTED");
                    int yearAnimeStarted = resultSet.getInt("YEAR_ANIME_STARTED");
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

                String query = "SELECT * FROM USER WHERE MANGA_NAME = ? AND YEAR_MANGA_STARTED = ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, manga_name);
                preparedStatement.setInt(2, year_MangaStarted);

                resultSet = preparedStatement.executeQuery();
                if (resultSet.next())
                {

                    String name = resultSet.getString("MANGA_NAME");
                    int yearMangaStarted = resultSet.getInt("YEAR_MANGA_STARTED");
                    int yearAnimeStarted = resultSet.getInt("YEAR_ANIME_STARTED");

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

        @Override
        public void deleteMangaByName(String name) throws DaoException
        {
            Connection connection = null;
            PreparedStatement preparedStatement = null;

            try
            {
                connection = this.getConnection();

                String query = "DELETE FROM USER WHERE MANGA_NAME = ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, name);
                preparedStatement.executeUpdate();

            } catch (SQLException e)
            {
                throw new DaoException("deleteMangaByName() " + e.getMessage());
            } finally
            {
                try
                {
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
                    throw new DaoException("deleteMangaByName() " + e.getMessage());
                }
            }
        }

        @Override
        public Manga addManga(Manga manga) throws DaoException
        {
            Connection connection = null;
            PreparedStatement ps = null;
            ResultSet resultSet = null;

            try
            {
                //Get connection object using the methods in the super class (MySqlDao.java)...
                connection = this.getConnection();

                String query = "INSERT INTO USER VALUES(NULL, ?, ?, ?)";
                ps = connection.prepareStatement(query);
//            ps.setString(1, product.getID());
                ps.setString(1, manga.getName());
                ps.setInt(2, manga.getYearMangaStarted());
                ps.setInt(3, manga.getYearAnimeStarted());

                ps.executeUpdate();

                //Using a PreparedStatement to execute SQL...
            } catch (SQLException e)
            {
                throw new DaoException("addManga() " + e.getMessage());
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
                    throw new DaoException("addManga() " + e.getMessage());
                }
            }
            return manga;     // may be empty
        }

        @Override
        public String findAllMangaJSON() throws DaoException
        {
            Connection connection = null;
            PreparedStatement ps = null;
            ResultSet resultSet = null;
            List<Manga> mangaList = new ArrayList<>();
            Gson gsonParser = new Gson();
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
                    int yearMangaStarted = resultSet.getInt("YEAR_MANGA_STARTED");
                    int yearAnimeStarted = resultSet.getInt("YEAR_ANIME_STARTED");
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

            return gsonParser.toJson(mangaList);
        }

        @Override
        public String findMangaByNameJSON(String manga_name, int year_MangaStarted) throws DaoException {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            Manga manga = null;
            Gson gsonParser = new Gson();
            try
            {
                connection = this.getConnection();

                String query = "SELECT * FROM USER WHERE MANGA_NAME = ? AND YEAR_MANGA_STARTED = ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, manga_name);
                preparedStatement.setInt(2, year_MangaStarted);

                resultSet = preparedStatement.executeQuery();
                if (resultSet.next())
                {

                    String name = resultSet.getString("MANGA_NAME");
                    int yearMangaStarted = resultSet.getInt("YEAR_MANGA_STARTED");
                    int yearAnimeStarted = resultSet.getInt("YEAR_ANIME_STARTED");

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
            return gsonParser.toJson(manga);
        }
        @Override
        public String displayEntityByIDJSON(int year_AnimeStarted) throws DaoException
        {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            Manga manga = null;
            Gson gsonParser = new Gson();
            try
            {
                connection = this.getConnection();

                String query = "SELECT * FROM USER WHERE YEAR_ANIME_STARTED = ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, year_AnimeStarted);

                resultSet = preparedStatement.executeQuery();
                if (resultSet.next())
                {

                    String name = resultSet.getString("MANGA_NAME");
                    int yearMangaStarted = resultSet.getInt("YEAR_MANGA_STARTED");
                    int yearAnimeStarted = resultSet.getInt("YEAR_ANIME_STARTED");

                    manga = new Manga(name, yearMangaStarted, yearAnimeStarted);
                }
            } catch (SQLException e)
            {
                throw new DaoException("displayEntityByID() " + e.getMessage());
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
                    throw new DaoException("displayEntityByID() " + e.getMessage());
                }
            }
            return gsonParser.toJson(manga);
        }


        @Override
        public String displayAllEntitiesJSON() throws DaoException
        {
            Connection connection = null;
            PreparedStatement ps = null;
            ResultSet resultSet = null;
            List<Manga> mangaList = new ArrayList<>();
            Gson gsonParser = new Gson();
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
                    int yearMangaStarted = resultSet.getInt("YEAR_MANGA_STARTED");
                    int yearAnimeStarted = resultSet.getInt("YEAR_ANIME_STARTED");
                    Manga u = new Manga( name, yearMangaStarted, yearAnimeStarted);
                    mangaList.add(u);
                }
            } catch (SQLException e)
            {
                throw new DaoException("displayAllEntities() " + e.getMessage());
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
                    throw new DaoException("displayAllEntities() " + e.getMessage());
                }
            }

            return gsonParser.toJson(mangaList);
        }
        @Override
       public Manga addEntityJSON( Manga manga ) throws DaoException
        {
            Connection connection = null;
            PreparedStatement ps = null;
            ResultSet resultSet = null;

            try
            {
                //Get connection object using the methods in the super class (MySqlDao.java)...
                connection = this.getConnection();

                String query = "INSERT INTO USER VALUES(NULL, ?, ?, ?)";
                ps = connection.prepareStatement(query);
//            ps.setString(1, product.getID());
                ps.setString(1, manga.getName());
                ps.setInt(2, manga.getYearMangaStarted());
                ps.setInt(3, manga.getYearAnimeStarted());

                ps.executeUpdate();

                //Using a PreparedStatement to execute SQL...
            } catch (SQLException e)
            {
                throw new DaoException("addEntityJSON() " + e.getMessage());
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
                    throw new DaoException("addEntityJSON() " + e.getMessage());
                }
            }
            return manga;     // may be empty
        }
        @Override
        public void deleteEntityByNameJSON(String name) throws DaoException
        {
            Connection connection = null;
            PreparedStatement preparedStatement = null;

            try
            {
                connection = this.getConnection();

                String query = "DELETE FROM USER WHERE MANGA_NAME = ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, name);
                preparedStatement.executeUpdate();

            } catch (SQLException e)
            {
                throw new DaoException("deleteEntityByNameJSON() " + e.getMessage());
            } finally
            {
                try
                {
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
                    throw new DaoException("deleteEntityByNameJSON() " + e.getMessage());
                }
            }
        }
    }


