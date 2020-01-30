package com.twu.biblioteca.service;

import java.util.Scanner;

public class LibraryService {
    private String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private String menuOptions = "Menu \n 1 - List of all books\n 2 - Quit \n";

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public String listOfMenuOptions() {
        return menuOptions;
    }

    public int chooseAMenuOption() {
        int option;

        Scanner read = new Scanner(System.in);

        System.out.printf("\nPlease choose an option: ");
        option = read.nextInt();

        return option;
    }
}
