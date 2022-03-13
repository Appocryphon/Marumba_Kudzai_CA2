package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    private void start() {

    }

    private void displayMainMenu() throws IOException {

        final String MENU_ITEMS = "\n*** MENU OPTIONS ***\n"
                + "1. Array\n"
                + "2. Vehicles\n"
                + "3. Bookings\n"
                + "4. Exit\n"
                + "Enter Option [1,4]";

        final int ARRAY = 1;
        final int VEHICLES = 2;
        final int BOOKINGS = 3;
        final int EXIT = 4;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option) {
                    case PASSENGERS:
                        System.out.println("Passengers option chosen");
                        displayPassengerMenu();
                        break;
                    case VEHICLES:
                        System.out.println("Vehicles option chosen");
                        break;
                    case BOOKINGS:
                        System.out.println("Bookings option chosen");
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter a valid number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter a valid number in range");
            }
        } while (option != EXIT);

        System.out.println("\nExiting Main Menu, goodbye.");

    }

    private void displayPassengerMenu() {
        final String MENU_ITEMS = "\n*** PASSENGER MENU ***\n"
                + "1. Show all Passengers\n"
                + "2. Find Passenger by Name\n"
                + "3. ADD PASSENGER\n"
                + "4. Exit\n"
                + "Enter Option [1,3]";

        final int SHOW_ALL = 1;
        final int FIND_BY_NAME = 2;
        final int ADD_PASSENGER = 3;
        final int EXIT = 4;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option) {
                    case SHOW_ALL:
                        System.out.println("Display ALL Passengers");
                        passengerStore.displayAllPassengers();
                        break;
                    case FIND_BY_NAME:
                        System.out.println("Find Passenger by Name");
                        System.out.println("Enter passenger name: ");
                        String name = keyboard.nextLine();
                        passengerStore.findpassengerbyName(name);

                        break;
                    case ADD_PASSENGER:
                        Scanner kb = new Scanner(System.in);
                        System.out.print("enter passenger name:");
                        String input_name = kb.nextLine();


                        System.out.print("enter passenger email:");
                        String email = kb.next();

                        System.out.print("enter passenger phonenumber:");
                        String phonenumber = kb.next();

                        System.out.print("enter passenger latitude:");
                        double latitude = kb.nextDouble();

                        System.out.print("enter passenger longtitude:");
                        double longtitude = kb.nextDouble();
                        passengerStore.add(input_name, email, phonenumber, latitude, longtitude);
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

    }

}
