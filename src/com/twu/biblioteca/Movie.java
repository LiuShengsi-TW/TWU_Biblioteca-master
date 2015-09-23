package com.twu.biblioteca;

/**
 * Created by ssliu on 9/21/15.
 */
public class Movie {
    private String name; // Movie's name
    private String director; // Movie's director
    private String year; // Movie's publish year
    private String rating; // Movie's rating
    private int number; // Movie's number


    Movie()
    {

    }
    Movie(String name,String director,String year,String rating,int number)
    {
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return " Name: "+this.getName()+" Director: "+this.getDirector()+" Year: "+this.getYear()+" Rating: "+this.getRating()+" Number: "+this.getNumber();
    }



}
