package com.twu.biblioteca.model;

import com.twu.biblioteca.model.Book;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BookTest {

    @Test
    public void getsBookTitle() {
        Book book = new Book("Dom Casmurro", "Machado de Assis", 1900);

        assertEquals("Dom Casmurro", book.getTitle());
    }

    @Test
    public void getsBookAuthor(){
        Book book = new Book("Memórias Póstumas de Brás Cubas", "Machado de Assis", 1889);

        assertEquals("Machado de Assis", book.getAuthor());
    }

    @Test
    public void getsBookYearPublish(){
        Book book = new Book("Esaú e Jacó", "Machado de Assis", 1899);

        assertEquals(1899, book.getPublishYear());
    }

    @Test
    public void convertsToString(){
        Book book = new Book("O Alienista", "Machado de Assis", 1879);

        assertEquals("Title: O Alienista | Author: Machado de Assis | Published Year: 1879", book.toString());
    }

    @Test
    public void seesIfABookIsCheckedOut() {
        Book book = new Book("O Alienista", "Machado de Assis", 1879);

        book.checkOut();

        assertTrue(book.isCheckedOut());
    }
}