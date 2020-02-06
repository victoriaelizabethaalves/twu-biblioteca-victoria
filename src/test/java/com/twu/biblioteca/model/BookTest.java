package com.twu.biblioteca.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BookTest {

    @Test
    public void getsBookTitle() {
        Book book = new Book("Dom Casmurro", "Machado de Assis", 1900, 1);

        assertEquals("Dom Casmurro", book.getTitle());
    }

    @Test
    public void getsBookAuthor() {
        Book book = new Book("Memórias Póstumas de Brás Cubas", "Machado de Assis", 1889, 2);

        assertEquals("Machado de Assis", book.getAuthor());
    }

    @Test
    public void getsBookYearPublish() {
        Book book = new Book("Esaú e Jacó", "Machado de Assis", 1899, 3);

        assertEquals(1899, book.getPublishYear());
    }

    @Test
    public void getsBookId() {
        Book book = new Book("Quincas Borba", "Machado de Assis", 1897, 4);

        assertEquals(4, book.getBookId());
    }

    @Test
    public void convertsToString() {
        Book book = new Book("O Alienista", "Machado de Assis", 1879, 4);

        assertEquals("Id: 4 | Title: O Alienista | Author: Machado de Assis | Published Year: 1879", book.toString());
    }

    @Test
    public void seesIfABookIsCheckedOut() {
        Book book = new Book("O Alienista", "Machado de Assis", 1879, 5);

        book.checkOut();

        assertTrue(book.isCheckedOut());
    }

    @Test
    public void areEqual() {
        Book first = new Book("O Alienista", "Machado de Assis", 1879, 6);
        Book second = new Book("O Alienista", "Machado de Assis", 1879, 7);

        assertThat(first.equals(second), is(true));
        assertThat(first.hashCode() == second.hashCode(), is(true));
    }

    @Test
    public void areNotEqual() {
        Book first = new Book("O Alienista", "Machado de Assis", 1879, 8);
        Book second = new Book("O Alienista", "Machado de Assis", 1878, 9);

        assertThat(first.equals(second), not(is(true)));
        assertThat(first.hashCode() != second.hashCode(), is(true));
    }
}