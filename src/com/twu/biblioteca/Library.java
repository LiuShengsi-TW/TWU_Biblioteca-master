package com.twu.biblioteca;

/**
 * Created by ssliu on 9/20/15.
 */
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Library {

    Set<Book> set = new HashSet<Book>();
    Set<Customers> cus = new HashSet<Customers>();
    Set<Movie> mov = new HashSet<Movie>();


    Library() {
        //Book List
        Book b1 = new Book("b0001","Jane Eyre","Charlotte Bronte","UK's Press","2007-8",100.00,5);
        Book b2 = new Book("b0002","Gone With The Wind","Margaret Mitchell","America's Press","2011-11",108.00,4);
        Book b3 = new Book("b0003","Pride And Prejudice","Jane Austin","People's Press","2000-1",98.00,6);
        Book b4 = new Book("b0004","A Passage To India","E.M.Forster","India's Press","2010-3",88.00,8);
        Book b5 = new Book("b0005","Robison Crusoe","Daniel Defore","UK's Press","2009-5",108.00,6);

        set.add(b1);
        set.add(b2);
        set.add(b3);
        set.add(b4);
        set.add(b5);

        Customers c1 = new Customers("c0001","Rita");
        Customers c2 = new Customers("c0002","Tom");
        Customers c3 = new Customers("c0003","Bill");
        Customers c4 = new Customers("c0004","Wayde");

        cus.add(c1);
        cus.add(c2);
        cus.add(c3);
        cus.add(c4);

        Movie m1 = new Movie("Life of Pi","Ang Lee","2012","9.0",4);
        Movie m2 = new Movie("Avatar","James Cameron","2009","8.6",6);
        Movie m3 = new Movie("Schindler's List","Steven Spielberg","1993","9.4",5);
        Movie m4 = new Movie("Gone Girl","David Fincher","2014","8.7",3);
        Movie m5 = new Movie("Traffic","Steven Soderbergh","2000","7.6",4);
        Movie m6 = new Movie("A Beautiful Mind","Ron Howard","2001","8.9",2);

        mov.add(m1);
        mov.add(m2);
        mov.add(m3);
        mov.add(m4);
        mov.add(m5);
        mov.add(m6);


    }

    public Customers queryCustomersById(String cid)
    {
        for(Customers c:cus)
        {
            if(c.getCid().equals(cid))
            {
                return c;
            }
        }
        return null;
    }

    public void queryAllBooks()
    {
        System.out.println("All books in Biblioteca is as fellows:");
        //Lists all books in library
        for(Book b:set)
        {
            System.out.println(b);
        }
    }

    public void queryAllMovies()
    {
        System.out.println("All movies in Biblioteca is as fellows:");
        //Lists all movies in library
        for(Movie m:mov)
        {
            System.out.println(m);
        }
    }

    public Book queryBookById(String id)
    {
        for(Book b:set)
        {
            if(b.getId().equals(id)) // Judge the id whether equal
            {
                return b;
            }
        }
        return null; // Id isn't equal then return null
    }

    public Movie queryMovieByName(String name)
    {
        for(Movie m:mov)
        {
            if(m.getName().equals(name)) // Judge the name whether equal
            {
                return m;
            }
        }
        return null; // Name isn't equal then return null
    }

    public boolean checkoutMovie(Customers c,String name, String amount)
    {
        Movie m = null;
        m = queryMovieByName(name);

        if( m != null )
        {
            System.out.println(m);
            int num = Integer.parseInt(amount);
            if(num>m.getNumber())
            {
                System.out.println("There is not so much movie you want to checkout!");
                return false;
            }
            else
            {
                mov.remove(m);
                m.setNumber(m.getNumber() - num);
                mov.add(m);
                c.customerCheckoutMovie(m, num);
                System.out.println("Thank you! Enjoy the movie.");
                return true;
            }
        }else {
            System.out.println("That moive is not available.");
            return false;
        }
    }

    public boolean checkoutBook(Customers c,String id, String amount)
    {
        Scanner in = new Scanner(System.in);
        Book b = null;
        b = queryBookById(id);

        if( b != null )
        {
            System.out.println(b);

            int num = Integer.parseInt(amount);
            if(num>b.getNumber())
            {
                System.out.println("There is not so much book you want to checkout!");
                return false;
            }
            else
            {
                set.remove(b);
                b.setNumber(b.getNumber() - num);
                set.add(b);
                c.customerCheckoutBook(b, num);
                System.out.println("Thank you! Enjoy the book.");
                return true;
            }
        }else {
            System.out.println("That book is not available.");
            return false;
        }
    }

    public boolean returnBook(Customers c,String id, String amount)
    {
        Map<Book,Integer> map = c.getBook();
        Set<Book> set = map.keySet();
        Book tempBook =null;
        boolean flag = false;
        for(Book b: set)
        {
            if(b.getId().equals(id))
            {
                flag = true;
                tempBook = b;
                break;
            }
        }
        if(flag)
        {
            int num = Integer.parseInt(amount);
            if(num > c.getBook().get(tempBook))
            {
                System.out.println("The number is beyond you have checkouted!");
                return false;
            }
            else if(num == c.getBook().get(tempBook))
            {
                c.customerReturnBook(tempBook);

                Book b = queryBookById(id);
                this.set.remove(b);
                b.setNumber(b.getNumber()+num);
                this.set.add(b);
                System.out.println("Thank you for returning the book.");
                return true;
            }
            else
            {
                c.customerReturnBook(tempBook, num);
                Book b = queryBookById(id);
                this.set.remove(b);
                b.setNumber(b.getNumber()+num);
                this.set.add(b);
                System.out.println("Thank you for returning part of the book.");
                return true;
            }
        }
        else
        {
            System.out.println("That is not a valid book to return.");
            return false;
        }
    }

    public boolean returnMovie(Customers c,String name, String amount)
    {
        Map<Movie,Integer> map = c.getMovie();
        Set<Movie> mov = map.keySet();
        Movie tempMovie =null;
        boolean flag = false;
        for(Movie m: mov)
        {
            if(m.getName().equals(name))
            {
                flag = true;
                tempMovie = m;
                break;
            }
        }
        if(flag)
        {
            int num = Integer.parseInt(amount);
            if(num > c.getMovie().get(tempMovie))
            {
                System.out.println("The number is beyond you have checkouted!");
                return false;
            }
            else if(num == c.getMovie().get(tempMovie))
            {
                c.customerReturnMovie(tempMovie);

                Movie m = queryMovieByName(name);
                this.mov.remove(m);
                m.setNumber(m.getNumber()+num);
                this.mov.add(m);
                System.out.println("Thank you for returning the movie.");
                return true;
            }
            else
            {
                c.customerReturnMovie(tempMovie, num);
                Movie m = queryMovieByName(name);
                this.mov.remove(m);
                m.setNumber(m.getNumber()+num);
                this.mov.add(m);
                System.out.println("Thank you for returning part of the movie.");
                return true;
            }
        }
        else
        {
            System.out.println("That is not a valid movie to return.");
            return false;
        }
    }
}
