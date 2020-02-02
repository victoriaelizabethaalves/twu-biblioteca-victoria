package com.twu.biblioteca.service;

import com.twu.biblioteca.Reader;
import com.twu.biblioteca.Writer;
import com.twu.biblioteca.model.Book;

import java.util.List;
import java.util.Scanner;

public class LibraryService {
    private String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private String menuOptions = "Menu \n 1 - List of all books\n 2 - Quit \n";
    private BookService bookService;
    private Reader reader;
    private Writer writer;

    public LibraryService(BookService bookService, Reader reader, Writer writer) {
        this.bookService = bookService;
        this.reader = reader;
        this.writer = writer;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public String listOfMenuOptions() {
        return menuOptions;
    }

    private int chooseAMenuOption() {
        int option;

        System.out.printf("\nPlease choose an option: ");
        option = reader.nextInt();

        return option;
    }

    public void menu() {
        int menuOptionChosen = 0;

        while (menuOptionChosen != 2) {
            menuOptionChosen = chooseAMenuOption();

            if (menuOptionChosen == 1) {
                List<Book> listOfBooks = bookService.listOfBooks();
                for(Book book:listOfBooks) {
                    writer.out(book.toString());
                }
            } else if (menuOptionChosen == 2) {
                System.out.println("\nPlease select a valid option!");
            }
        }
    }
}
