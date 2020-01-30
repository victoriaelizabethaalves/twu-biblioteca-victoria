package com.twu.biblioteca;

import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.LibraryService;

public class BibliotecaApp {

    public static void main(String[] args) {
        BookService bookService = new BookService();
        LibraryService libraryService = new LibraryService(bookService);

        System.out.println(libraryService.getWelcomeMessage());
        System.out.println(libraryService.listOfMenuOptions());

        libraryService.menu();
    }
}