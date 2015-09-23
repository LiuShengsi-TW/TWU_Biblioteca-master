package com.twu.biblioteca;

/**
 * Created by ssliu on 9/20/15.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Customers {

    private String cid; // customer's id
    private String name; // customer's name
    private String libraryNumber; // customer's
    private String password; // customer's password
    private String emaillAddress;
    private String phoneNumber;
    private Map<Book,Integer> book;
    private Map<Movie,Integer> movie;

    public Customers()
    {

    }

    public Customers(String cid,String name, String libraryNumber, String password, String emaillAddress, String phoneNumber)
    {
        this.cid = cid;
        this.name = name;
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.emaillAddress = emaillAddress;
        this.phoneNumber = phoneNumber;
        book = new HashMap<Book,Integer>();
        movie = new HashMap<Movie,Integer>();
    }


    public String getCid() {

        return cid;
    }

    public void setCid(String cid) {

        this.cid = cid;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getLibraryNumber() {

        return libraryNumber;
    }

    public void setLibraryNumber(String libraryNumber) {

        this.libraryNumber = libraryNumber;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getEmaillAddress() {

        return emaillAddress;
    }

    public void setEmaillAddress(String emaillAddress) {

        this.emaillAddress = emaillAddress;
    }

    public String getPhoneNumberword() {

        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }

    public Map<Book, Integer> getBook() {

        return book;
    }

    public void setBook(Map<Book, Integer> book) {

        this.book = book;
    }

    public Map<Movie, Integer> getMovie() {

        return movie;
    }

    public void setMovie(Map<Movie, Integer> movie) {

        this.movie = movie;
    }

    public void customerCheckoutBook(Book b,int num) {

        this.getBook().put(b, num);
    }

    public void customerReturnBook(Book b,int num) {

        this.getBook().put(b, (this.getBook().get(b) - num));
    }

    public void customerReturnBook(Book b) {

        this.getBook().remove(b);
    }

    public void customerCheckoutMovie(Movie m,int num) {

        this.getMovie().put(m, num);
    }

    public void customerReturnMovie(Movie m,int num) {

        this.getMovie().put(m, (this.getMovie().get(m) - num));
    }

    public void customerReturnMovie(Movie m) {

        this.getMovie().remove(m);
    }

    public void showAllBooks() {

        Set<Book> set = this.getBook().keySet();
        for(Book b : set)
        {
            System.out.print("Book's id: "+b.getId()+" Book's name: "+b.getName());
            System.out.print(" Checkouted Amount: "+this.getBook().get(b));
            System.out.println();
        }
    }

    public void showAllMovies() {

        Set<Movie> mov = this.getMovie().keySet();
        for(Movie m : mov)
        {
            System.out.print("Movie's name: " + m.getName() + " Movie's director: " + m.getDirector());
            System.out.print("Checkouted Amount: "+this.getMovie().get(m));
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return " Name: "+this.getName()+" Phone number: "+this.getPhoneNumberword()+" EmailAddress: "+this.getEmaillAddress();

    }

}
