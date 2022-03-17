package com.company;

import java.io.IOException;
import java.util.*;

public class App {
    //
    mangaManager mangaManager;
    List<Manga> mangaList;

    public static void main(String[] args) {
        App app = new App();
        app.start();


    }

    private void start() {
        this.mangaList = new ArrayList<>();
        mangaList.add(new Manga("Date A Live", 2013, 2012));
        mangaList.add(new Manga("Goblin Slayer", 2018, 2016));
        mangaList.add(new Manga("Jobless Reincarnation", 2021, 2014));
        mangaList.add(new Manga("Shingeki no Kyojin", 2013, 2009));
        mangaList.add(new Manga("Dragon Ball Z", 2009, 2006));
        mangaList.add(new Manga("Fairy Tail", 2013, 2012));
        mangaList.add(new Manga("Bleach", 2004, 2001));
        mangaList.add(new Manga("Kimetsu no Yaiba", 2019, 2016));
        mangaList.add(new Manga("Tokyo Ghoul", 2014, 2011));
        mangaList.add(new Manga("Akame ga Kill", 2014, 2010));




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
                + "4. Exit\n"
                + "Enter Option [1,4]";

        final int Arrays = 1;
        final int hashMap = 2;
        final int treeMap = 3;
        final int EXIT = 4;

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

        mangaMap.put("1",new Manga("Date A Live", 2013, 2012));
        mangaMap.put("2", new Manga("Goblin Slayer", 2018, 2016));
        mangaMap.put("3", new Manga("Jobless Reincarnation", 2021, 2014));
        mangaMap.put("4", new Manga("Shingeki no Kyojin", 2013, 2009));
        mangaMap.put("5", new Manga("Dragon Ball Z", 2009, 2006));
        mangaMap.put("6", new Manga("Fairy Tail", 2013, 2012));
        mangaMap.put("7", new Manga("Bleach", 2004, 2001));
        mangaMap.put("8", new Manga("Kimetsu no Yaiba", 2019, 2016));
        mangaMap.put("9", new Manga("Tokyo Ghoul", 2014, 2011));
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
        mangaMap.put(0, new Manga("Date A Live",2013, 2012));
        mangaMap.put(1, new Manga("Goblin Slayer", 2018, 2016));
        mangaMap.put(2, new Manga("Jobless Reincarnation", 2021, 2014));
        mangaMap.put(3, new Manga("Shingeki no Kyojin", 2013, 2009));
        mangaMap.put(4, new Manga("Dragon Ball Z",2009, 2006));
        mangaMap.put(5, new Manga("Fairy Tail",2013, 2012));
        mangaMap.put(6, new Manga("Bleach",2004, 2001));
        mangaMap.put(7, new Manga("Kimetsu no Yaiba",2019, 2016));
        mangaMap.put(8, new Manga("Tokyo Ghoul",2014, 2011));
        mangaMap.put(9, new Manga("Akame ga Kill",2014, 2010));

        Set<Integer> keySet = mangaMap.keySet();

        for (Integer key : keySet) {
            Manga manga = mangaMap.get(key);
            System.out.println("Key: " + key + " "
                    + manga.getName());
        }


    }




}
