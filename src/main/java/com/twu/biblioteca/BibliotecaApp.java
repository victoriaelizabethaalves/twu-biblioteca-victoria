package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.Rating;
import com.twu.biblioteca.service.LibraryService;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        Reader reader = new Reader();
        Writer writer = new Writer();
        List<Book> bookList = new ArrayList<>();
        List<Movie> movieList = new ArrayList<>();

        bookList.add(new Book("Harry Potter", "J.K. Rowling", 1998, 1));
        bookList.add(new Book("The Little Prince", "Anthony", 1970, 2));
        bookList.add(new Book("1984", "George Orwell", 1984, 3));

        movieList.add(new Movie("La La Land", 2016, "Lola", Rating.NINE, 1));
        movieList.add(new Movie("The Godfather", 1970, "Francis", Rating.TEN, 2));
        movieList.add(new Movie("The Lion King", 1990, "Disney", Rating.NINE, 3));

        LibraryService libraryService = new LibraryService(bookList, movieList, reader, writer);

        System.out.println(libraryService.getWelcomeMessage());
        System.out.println(libraryService.listOfMenuOptions());

        libraryService.menu();
    }
}