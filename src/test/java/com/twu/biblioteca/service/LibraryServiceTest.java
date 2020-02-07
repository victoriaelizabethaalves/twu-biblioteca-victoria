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
    public static final int LIST_OF_BOOKS = 1;
    public static final int CHECK_OUT_BOOK = 2;
    public static final int CHECK_IN_BOOK = 3;
    public static final int QUIT_APPLICATION = 4;
    public static final int FIRST_BOOK_ID = 1;
    public static final int BOOK_ID_OUT_OF_RANGE = 5;

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

        assertEquals("Menu \n 1 - List of all books\n 2 - Checkout a book\n 3 - Return a book\n 4 - Quit",
                libraryService.listOfMenuOptions());
    }

    @Test
    public void showsListOfBooksWhenMenuOptionIsOne() {
        Reader reader = mock(Reader.class);
        Writer writer = mock(Writer.class);
        LibraryService libraryService = new LibraryService(booksList(), reader, writer);

        when(reader.nextInt()).thenReturn(LIST_OF_BOOKS,QUIT_APPLICATION);
        libraryService.menu();

        verify(writer).out(booksList().get(0).toString());
        verify(writer).out(booksList().get(1).toString());
        verify(writer).out(booksList().get(2).toString());
    }

    @Test
    public void quitsApplicationWhenMenuOptionIsFour() {
        Reader reader = mock(Reader.class);
        Writer writer = mock(Writer.class);
        LibraryService libraryService = new LibraryService(booksList(), reader, writer);

        when(reader.nextInt()).thenReturn(QUIT_APPLICATION);
        libraryService.menu();

        verify(writer, never()).out(booksList().get(0).toString());
        verify(writer, never()).out(booksList().get(1).toString());
        verify(writer, never()).out(booksList().get(2).toString());
    }

    @Test
    public void removesBookWithIdOneFromListWhenMenuOptionIsTwo() {
        Reader reader = mock(Reader.class);
        Writer writer = mock(Writer.class);
        LibraryService libraryService = new LibraryService(booksList(), reader, writer);

        when(reader.nextInt()).thenReturn(CHECK_OUT_BOOK, FIRST_BOOK_ID, LIST_OF_BOOKS, QUIT_APPLICATION);
        libraryService.menu();

        verify(writer, never()).out(booksList().get(0).toString());
        verify(writer).out(booksList().get(1).toString());
        verify(writer).out(booksList().get(2).toString());
    }

    @Test
    public void returnsBookWithIdOneFromListWhenMenuOptionIsThree() {
        Reader reader = mock(Reader.class);
        Writer writer = mock(Writer.class);
        LibraryService libraryService = new LibraryService(booksList(), reader, writer);

        when(reader.nextInt()).thenReturn(CHECK_OUT_BOOK,FIRST_BOOK_ID, CHECK_IN_BOOK, FIRST_BOOK_ID, LIST_OF_BOOKS, QUIT_APPLICATION);
        libraryService.menu();

        verify(writer).out(booksList().get(0).toString());
        verify(writer).out(booksList().get(1).toString());
        verify(writer).out(booksList().get(2).toString());
    }

    @Test
    public void returnsMessageForInvalidBookIdWhenMenuOptionIsThree() {
        Reader reader = mock(Reader.class);
        Writer writer = mock(Writer.class);
        LibraryService libraryService = new LibraryService(booksList(), reader, writer);

        when(reader.nextInt()).thenReturn(CHECK_IN_BOOK, BOOK_ID_OUT_OF_RANGE, QUIT_APPLICATION);
        libraryService.menu();

        verify(writer).out("That is not a valid book to return.");
    }

}
