package com.twu.biblioteca.model;

public class Movie {
    private String name;
    private int year;
    private String director;
    private Rating rating;

    public Movie(String name, int year, String director, Rating rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("Name: %s | Year: %d | Director: %s | Rating: %s", name, year, director, rating);
    }
}
