package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.LibraryService;

import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        BookService bookService = new BookService();
        LibraryService libraryService = new LibraryService();

        System.out.println(libraryService.getWelcomeMessage());
        System.out.println(bookService.listOfBooks());
    }
}