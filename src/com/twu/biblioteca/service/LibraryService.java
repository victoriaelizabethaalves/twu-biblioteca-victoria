package com.twu.biblioteca.service;


import java.util.Scanner;

public class LibraryService {
    private String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private String menuOptions = "Menu \n 1 - List of all books\n 2 - Quit \n";
    private BookService bookService;

    public LibraryService(BookService bookService) {
        this.bookService = bookService;
    }

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

    public void menu() {
        int menuOptionChosen = 0;

        while (menuOptionChosen != 2) {
            menuOptionChosen = chooseAMenuOption();

            if (menuOptionChosen == 1) {
                bookService.listOfBooks().forEach(System.out::println);
            } else if (menuOptionChosen == 2) {
                System.out.println("\nPlease select a valid option!");
            }
        }
    }
}
