package com.twu.biblioteca;

import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.LibraryService;

public class BibliotecaApp {

    public static void main(String[] args) {
        BookService bookService = new BookService();
        LibraryService libraryService = new LibraryService();

        System.out.println(libraryService.getWelcomeMessage());
        System.out.println(libraryService.listOfMenuOptions());

        int menuOptionChosen = 0;

        while (menuOptionChosen != 2) {
            menuOptionChosen = libraryService.chooseAMenuOption();

            if (menuOptionChosen == 1) {
                bookService.listOfBooks().forEach(book -> System.out.println(book));
            }
            else if (menuOptionChosen == 2) {
                System.out.println("\nPlease select a valid option!");
            }
        }
    }
}