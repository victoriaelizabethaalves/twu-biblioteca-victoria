package com.twu.biblioteca;

import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.LibraryService;

public class BibliotecaApp {

    public static void main(String[] args) {
        BookService bookService = new BookService();
        Reader reader = new Reader();
        Writer writer = new Writer();
        LibraryService libraryService = new LibraryService(bookService, reader, writer);

        System.out.println(libraryService.getWelcomeMessage());
        System.out.println(libraryService.listOfMenuOptions());

        libraryService.menu();
    }
}