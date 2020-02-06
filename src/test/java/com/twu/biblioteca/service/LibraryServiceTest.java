package com.twu.biblioteca.service;

import com.twu.biblioteca.Reader;
import com.twu.biblioteca.Writer;
import com.twu.biblioteca.model.Book;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LibraryServiceTest {
    public List<Book> booksList() {
        Book firstBook = new Book("Memórias Póstumas de Brás Cubas", "Machado de Assis", 1889, 1);
        Book secondBook = new Book("Esaú e Jacó", "Machado de Assis", 1899, 2);
        Book thirdBook = new Book("O Alienista", "Machado de Assis", 1879, 3);

        List<Book> bookList = Arrays.asList(firstBook, secondBook, thirdBook);

        return bookList;
    }

    @Test
    public void listAllBooksAfterWelcomeMessage(){
        LibraryService libraryService = new LibraryService(booksList(), null, null);
        assertNotNull(libraryService.listOfBooks());
    }

    @Test
    public void getsWelcomeMessage() {
        LibraryService libraryService = new LibraryService(null,null, null);

        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!",
                libraryService.getWelcomeMessage());
    }

    @Test
    public void getsMenuOptions() {
        LibraryService libraryService = new LibraryService(null,null, null);

        assertEquals("Menu \n 1 - List of all books\n 2 - Quit \n 3 - Checkout a book",
                libraryService.listOfMenuOptions());
    }

    @Test
    public void showsListOfBooksWhenMenuOptionIsOne() {
        Reader reader = mock(Reader.class);
        Writer writer = mock(Writer.class);
        LibraryService libraryService = new LibraryService(booksList(), reader, writer);

        when(reader.nextInt()).thenReturn(1,2);
        libraryService.menu();

        verify(writer).out(booksList().get(0).toString());
        verify(writer).out(booksList().get(1).toString());
        verify(writer).out(booksList().get(2).toString());
    }

    @Test
    public void quitsApplicationWhenMenuOptionIsTwo() {
        Reader reader = mock(Reader.class);
        Writer writer = mock(Writer.class);
        LibraryService libraryService = new LibraryService(booksList(), reader, writer);

        when(reader.nextInt()).thenReturn(2);
        libraryService.menu();

        verify(writer, never()).out(booksList().get(0).toString());
        verify(writer, never()).out(booksList().get(1).toString());
        verify(writer, never()).out(booksList().get(2).toString());
    }
}
