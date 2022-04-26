package com.company;

import java.io.IOException;
import java.util.*;

public class App {
    //
    List<Manga> mangaList;

    public static void main(String[] args) {

        MangaDaoInterface IMangaDao = new MySqlMangaDao();

        try
        {
            System.out.println("\nCall findAllManga()");
            List<Manga> mangas = IMangaDao.findAllManga();     // call a method in the DAO

            if( mangas.isEmpty() )
                System.out.println("There is no Manga");
            else {
                for (Manga manga : mangas)
                    System.out.println("Manga: " + manga.toString());
            }
            System.out.println("========================================");


            // test dao - with username and password that we know are present in the database
            System.out.println("\nCall: finMangabyNameYear");
            String name = "Fairy Tail";
            int yearMangaStarted = 2012;
            Manga manga = IMangaDao.findMangaByName(name, yearMangaStarted);

            if( manga != null ) // null returned if name and year not valid
                System.out.println("Manga found: " + manga);
            else
                System.out.println("Manga with that name and year not found");

            // test dao - with an invalid name (i.e. not in database)
            name = "Naruto Shippuden";
            yearMangaStarted = 1998;
            manga = IMangaDao.findMangaByName(name, yearMangaStarted);
            if(manga != null)
                System.out.println("Manga name: " + name + " was found: " + manga);
            else
                System.out.println("Manga name: " + name + ", yearMangaStarted: " + yearMangaStarted +" are not valid.");

            System.out.println("========================================");
            System.out.println("\nDelete manga by name()");
            String deletename = "Goblin Slayer";

           IMangaDao.deleteMangaByName(deletename);
            mangas = IMangaDao.findAllManga();     // call a method in the DAO

            if (mangas.isEmpty())
                System.out.println("There are no Products");
            else {
                for (Manga after_deleted_manga : mangas)
                    System.out.println("Manga: " + after_deleted_manga.toString());
            }
            System.out.println("Calling in add()");

            IMangaDao.addManga(new Manga("Fairy Tail",2012  , 2010));
            if( mangas.isEmpty() )
                System.out.println("There are no Manga");
            else {
                for (Manga u : mangas)
                    System.out.println("manga: " + u.toString());
            }
            System.out.println("Calling JSON");
            String allMangaJSON = IMangaDao.findAllMangaJSON();
           System.out.println(allMangaJSON);

            System.out.println("Calling Key JSON");
            String mangaJSON = IMangaDao.findMangaByNameJSON("Fairy Tail",2010);
            System.out.println(mangaJSON);

            System.out.println(" 14) Display Entity By ID");
           mangaJSON = IMangaDao.displayEntityByIDJSON(2012);
            System.out.println(mangaJSON);

            System.out.println(" 15) Display All Entities");
             allMangaJSON = IMangaDao.displayAllEntitiesJSON();
            System.out.println(allMangaJSON);

            System.out.println(" 16) Add an Entity");
            IMangaDao.addEntityJSON(new Manga("Black Clover",2017  , 2015));

            System.out.println(" 17) Delete an Entity");
            String entityName = "Black Clover";
            IMangaDao.deleteEntityByNameJSON(entityName);
        }
        catch( DaoException e )
        {
            e.printStackTrace();
        }
        App app = new App();
        app.start();


    }

    private void start() {
        this.mangaList = new ArrayList<>();
        mangaList.add(new Manga( "Date A Live", 2013, 2012));
        mangaList.add(new Manga( "Goblin Slayer", 2018, 2016));
        mangaList.add(new Manga("Jobless Reincarnation", 2021, 2014));
        mangaList.add(new Manga("Shingeki no Kyojin", 2013, 2009));
        mangaList.add(new Manga( "Dragon Ball Z", 1986, 1988));
        mangaList.add(new Manga( "Fairy Tail", 2013, 2012));
        mangaList.add(new Manga( "Bleach", 2004, 2001));
        mangaList.add(new Manga( "Kimetsu no Yaiba", 2019, 2016));
        mangaList.add(new Manga("Tokyo Ghoul", 2014, 2011));
        mangaList.add(new Manga( "Akame ga Kill", 2014, 2010));






        try {
            displayMainMenu();        // User Interface - Menu
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Program ending, Goodbye");

    }


    private void displayMainMenu() throws IOException {

        final String MENU_ITEMS = "\n*** MAIN MENU OF OPTIONS ***\n"
                + "1. ArrayList\n"
                + "2. HashMap\n"
                + "3. TreeMap\n"
                + "4. DAO's\n"
                + "5. Exit\n"
                + "Enter Option [1,5]";

        final int Arrays = 1;
        final int hashMap = 2;
        final int treeMap = 3;
        final int mangaDao = 4;
        final int EXIT = 5;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option) {
                    case Arrays:
                        System.out.println("Display all Manga available:");
                        displayAllManga();

                        break;

                    case hashMap:
                        System.out.println("Displaying HashMap:");
                        mangaHashMap();
                        break;
                    case treeMap:
                        System.out.println("Displaying TreeMap:");
                        mangaTreeMap();
                        break;

                    case mangaDao:
                        System.out.println("Find all Manga available:");
//                        findAllManga();

                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

        System.out.println("\nExiting Main Menu, goodbye.");

    }

    public void displayAllManga() {
        for (Manga m : this.mangaList) {
            System.out.println(m.toString());
        }
    }


    public void mangaHashMap() {




        Map<String, Manga> mangaMap = new HashMap<>();

        mangaMap.put("1",new Manga( "Date A Live", 2013, 2012));
        mangaMap.put("2", new Manga( "Goblin Slayer", 2018, 2016));
        mangaMap.put("3", new Manga( "Jobless Reincarnation", 2021, 2014));
        mangaMap.put("4", new Manga( "Shingeki no Kyojin", 2013, 2009));
        mangaMap.put("5", new Manga( "Dragon Ball Z", 2009, 2006));
        mangaMap.put("6", new Manga( "Fairy Tail", 2013, 2012));
        mangaMap.put("7", new Manga( "Bleach", 2004, 2001));
        mangaMap.put("8", new Manga( "Kimetsu no Yaiba", 2019, 2016));
        mangaMap.put("9", new Manga( "Tokyo Ghoul", 2014, 2011));
        mangaMap.put("10", new Manga("Akame ga Kill", 2014, 2010));
////


         String key="";
         System.out.println("Please enter a key: ");
         Scanner sc = new Scanner(System.in);
         key = sc.next();


         if (mangaMap.containsKey(key))
         {
             System.out.println("mangaMap contains key" + key);
             System.out.println();

         }
         else
         {
             System.out.println("The entered key does not match any in the Map, please try again.");
             key = sc.nextLine();
         }





}



    public static void mangaTreeMap()
    {
        TreeMap<Integer, Manga> mangaMap = new TreeMap<>();
        mangaMap.put(0, new Manga( "Date A Live",2013, 2012));
        mangaMap.put(1, new Manga( "Goblin Slayer", 2018, 2016));
        mangaMap.put(2, new Manga( "Jobless Reincarnation", 2021, 2014));
        mangaMap.put(3, new Manga( "Shingeki no Kyojin", 2013, 2009));
        mangaMap.put(4, new Manga( "Dragon Ball Z",2009, 2006));
        mangaMap.put(5, new Manga( "Fairy Tail",2013, 2012));
        mangaMap.put(6, new Manga( "Bleach",2004, 2001));
        mangaMap.put(7, new Manga( "Kimetsu no Yaiba",2019, 2016));
        mangaMap.put(8, new Manga( "Tokyo Ghoul",2014, 2011));
        mangaMap.put(9, new Manga( "Akame ga Kill",2014, 2010));

        Set<Integer> keySet = mangaMap.keySet();

        for (Integer key : keySet) {
            Manga manga = mangaMap.get(key);
            System.out.println("Key: " + key + " "
                    + manga.getName());
        }


    }




}
