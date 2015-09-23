package com.twu.biblioteca;

/**
 * Created by ssliu on 9/20/15.
 */
public class Book {

    private String id; // book's ID
    private String name; // book's name
    private String author; // book's author
    private String press; // book's publishing house
    private String date; // book's publish date
    private double price; // book's price
    private int number; // book's number


    Book()
    {

    }
    Book(String id,String name,String author,String press,String date,double price,int number)
    {
        this.id = id;
        this.name = name;
        this.author = author;
        this.press = press;
        this.date = date;
        this.price = price;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public Book setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getPress() {
        return press;
    }

    public Book setPress(String press) {
        this.press = press;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Book setDate(String date) {
        this.date = date;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Book setPrice(double price) {
        this.price = price;
        return this;
    }

    public int getNumber() {
        return number;
    }

    public Book setNumber(int number) {
        this.number = number;
        return this;
    }

    @Override
    public String toString() {

        return "ID: "+this.getId()+" Name: "+this.getName()+" Author: "+this.getAuthor()+" Press: "+this.getPress()+" Date: "+this.getDate()+" Price: "+this.getPrice()+" Number: "+this.getNumber();
    }




}