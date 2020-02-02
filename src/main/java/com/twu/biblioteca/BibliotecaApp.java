package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.service.LibraryService;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        Reader reader = new Reader();
        Writer writer = new Writer();
        List<Book> bookList = new ArrayList<>();

        bookList.add(new Book("Harry Potter", "J.K. Rowling", 1998));
        bookList.add(new Book("The Little Prince", "Anthony", 1970));
        bookList.add(new Book("1984", "George Orwell", 1984));

        LibraryService libraryService = new LibraryService(bookList, reader, writer);

        System.out.println(libraryService.getWelcomeMessage());
        System.out.println(libraryService.listOfMenuOptions());

        libraryService.menu();
    }
}