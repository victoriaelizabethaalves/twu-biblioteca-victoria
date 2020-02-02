package com.twu.biblioteca.model;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int publishYear;
    private boolean checkedOut;

    public Book(String title, String author, int publishYear) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.checkedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    @Override
    public String toString() {
        return String.format("Title: %s | Author: %s | Published Year: %d", title, author, publishYear);
    }

    public void checkOut() {
        this.checkedOut = true;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return publishYear == book.publishYear &&
                checkedOut == book.checkedOut &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publishYear, checkedOut);
    }
}
