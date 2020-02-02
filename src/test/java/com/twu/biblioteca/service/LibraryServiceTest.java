package com.twu.biblioteca.service;

import com.twu.biblioteca.Reader;
import com.twu.biblioteca.Writer;
import com.twu.biblioteca.model.Book;
import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class LibraryServiceTest {

    @Test
    public void getsWelcomeMessage() {
        LibraryService libraryService = new LibraryService(null, null, null);

        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!",
                libraryService.getWelcomeMessage());
    }

    @Test
    public void getsMenuOptions() {
        LibraryService libraryService = new LibraryService(null, null, null);

        assertEquals("Menu \n 1 - List of all books\n 2 - Quit \n",
                libraryService.listOfMenuOptions());
    }

    @Test
    public void showsListOfBooksWhenMenuOptionIsOne() {
        BookService bookService = mock(BookService.class); // Creates BookService mock
        Reader reader = mock(Reader.class);
        Writer writer = mock(Writer.class);
        LibraryService libraryService = new LibraryService(bookService, reader, writer);

        Book firstBook = new Book("Memórias Póstumas de Brás Cubas", "Machado de Assis", 1889);
        Book secondBook = new Book("Esaú e Jacó", "Machado de Assis", 1899);
        Book thirdBook = new Book("O Alienista", "Machado de Assis", 1879);

        when(reader.nextInt()).thenReturn(1,2);
        when(bookService.listOfBooks()).thenReturn(Arrays.asList(firstBook, secondBook, thirdBook));
        libraryService.menu();

        verify(writer).out(firstBook.toString());
        verify(writer).out(secondBook.toString());
        verify(writer).out(thirdBook.toString());
    }

    @Test
    public void quitsApplicationWhenMenuOptionIsTwo() {
        BookService bookService = mock(BookService.class); // Creates BookService mock
        Reader reader = mock(Reader.class);
        Writer writer = mock(Writer.class);
        LibraryService libraryService = new LibraryService(bookService, reader, writer);

        Book firstBook = new Book("Memórias Póstumas de Brás Cubas", "Machado de Assis", 1889);
        Book secondBook = new Book("Esaú e Jacó", "Machado de Assis", 1899);
        Book thirdBook = new Book("O Alienista", "Machado de Assis", 1879);

        when(reader.nextInt()).thenReturn(2);
        when(bookService.listOfBooks()).thenReturn(Arrays.asList(firstBook, secondBook, thirdBook));
        libraryService.menu();

        verify(writer, never()).out(firstBook.toString());
        verify(writer, never()).out(secondBook.toString());
        verify(writer, never()).out(thirdBook.toString());
    }
}
