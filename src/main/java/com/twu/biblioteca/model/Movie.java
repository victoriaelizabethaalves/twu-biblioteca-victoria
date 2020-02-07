package com.twu.biblioteca.model;

public class Movie {
    private String name;
    private int year;
    private String director;
    private Rating rating;
    private boolean checkedOut;
    private int movieId;

    public Movie(String name, int year, String director, Rating rating, int movieId) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.checkedOut = false;
        this.movieId = movieId;
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

    public boolean isCheckedOut() {
        return checkedOut;
    }

    @Override
    public String toString() {
        return String.format("Id: %d | Name: %s | Year: %d | Director: %s | Rating: %s", movieId, name, year, director, rating);
    }

    public void checkOut() {
        this.checkedOut = true;
    }

    public int getMovieId() { return movieId; }
}
