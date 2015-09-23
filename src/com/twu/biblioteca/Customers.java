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
    private String passWord; // customer's passWord
    private Map<Book,Integer> book;
    private Map<Movie,Integer> movie;

    public Customers()
    {

    }

    public Customers(String cid,String name)
    {
        this.cid = cid;
        this.name = name;
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

    public void customerCheckoutBook(Book b,int num)
    {
        this.getBook().put(b, num);
    }

    public void customerReturnBook(Book b,int num)
    {
        this.getBook().put(b, (this.getBook().get(b)-num));
    }

    public void customerReturnBook(Book b)
    {
        this.getBook().remove(b);
    }

    public void customerCheckoutMovie(Movie m,int num)
    {
        this.getMovie().put(m, num);
    }

    public void customerReturnMovie(Movie m,int num)
    {
        this.getMovie().put(m, (this.getMovie().get(m) - num));
    }

    public void customerReturnMovie(Movie m)
    {
        this.getMovie().remove(m);
    }

    public void showAllBooks()
    {
        Set<Book> set = this.getBook().keySet();
        for(Book b : set)
        {
            System.out.print("Book's id: "+b.getId()+" Book's name: "+b.getName());
            System.out.print(" Checkouted Amount: "+this.getBook().get(b));
            System.out.println();
        }
    }

    public void showAllMovies()
    {
        Set<Movie> mov = this.getMovie().keySet();
        for(Movie m : mov)
        {
            System.out.print("Movie's name: " + m.getName() + " Movie's director: " + m.getDirector());
            System.out.print("Checkouted Amount: "+this.getMovie().get(m));
            System.out.println();
        }
    }

}
