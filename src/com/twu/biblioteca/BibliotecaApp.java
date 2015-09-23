package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {
    private static Scanner in = new Scanner(System.in);
    private static int choice;
    private static Library lib = new Library();

    public static void menu() {
        System.out.println("********* Welcome To Biblioteca ************");
        System.out.println("1. List Books ");
        System.out.println("2. List Movies ");
        System.out.println("3. Query Book");
        System.out.println("4. Checkout Book");
        System.out.println("5. Checkout Movie");
        System.out.println("6. Return Book");
        System.out.println("7. Return Movie");
        System.out.println("8. Customer Information");
        System.out.println("9. Quit");
        System.out.println("********************************************");
        System.out.println("Please input your option(1-8):");
        choice = in.nextInt();
        while(choice<1 || choice>9) {
            System.out.println("Select a valid option!");
            choice = in.nextInt();
        }
    }

    public static boolean login() {

        String libraryNumber;
        String password;
        boolean run;

        System.out.println("Please input customer's library number: (00x-000x)");
        libraryNumber = in.next();
        System.out.println("Please input customer's password: ");
        password = in.next();
        run = lib.Login(libraryNumber,password);
        if ( !run ){
            System.out.println("Sorry : The library number or password is wrong! ");
        }
        return run;
    }


    public static void main(String[] args) {
        Book b = null;
        Movie m = null;
        Customers c = null;
        String movieName;
        String bookId;
        String customerId;
        String amount;
        String libraryNumber;
        boolean goon;

        goon = BibliotecaApp.login();

        while ( !goon) {

            goon = BibliotecaApp.login();
        }

        while( goon ) {

            System.out.println("Dear customer, welcome to the world of Biblioteca!");

            BibliotecaApp.menu();

            while(choice!=9)
            {
                switch(choice)
                {
                    case 1:
                        lib.queryAllBooks();
                        break;
                    case 2:
                        lib.queryAllMovies();
                        break;
                    case 3:
                        System.out.println("Please input book's id you want to query:(b000x)");
                        bookId = in.next();
                        b = lib.queryBookById(bookId);
                        if(b!=null)
                        {
                            System.out.println("The message of the book you queried is as follows:");
                            System.out.println(b);
                        }
                        else
                        {
                            System.out.println("Sorry! The book you queried is not exist in Biblioteca!");
                        }
                        break;
                    case 4:
                        System.out.println("Please input customer's id who want to checkout book:(c000x)");
                        customerId = in.next();
                        c = lib.queryCustomersById(customerId);
                        System.out.println("Please input book's id you want checkout:(b000x)");
                        bookId = in.next();
                        System.out.println("Please input amount of the book you want checkout:");
                        amount = in.next();
                        lib.checkoutBook(c, bookId, amount);
                        break;
                    case 5:
                        System.out.println("Please input customer's id who want to checkout movie:(c000x)");
                        customerId = in.next();
                        c = lib.queryCustomersById(customerId);
                        System.out.println("Please input movie's name you want checkout:");
                        movieName = in.next();
                        System.out.println("Please input amount of the movie you want checkout:");
                        amount = in.next();
                        lib.checkoutMovie(c, movieName, amount);
                        break;
                    case 6:
                        System.out.println("Please input the customer's id who want to return book:(c000x)");
                        customerId = in.next();
                        c = lib.queryCustomersById(customerId);
                        c.showAllBooks();
                        System.out.println("Please input the book's id you want to return:(b000x)");
                        bookId = in.next();
                        System.out.println("Please input amount of the book you want return:");
                        amount = in.next();
                        lib.returnBook(c, bookId, amount);
                        break;
                    case 7:
                        System.out.println("Please input the customer's id who want to return movie:(c000x)");
                        customerId = in.next();
                        c = lib.queryCustomersById(customerId);
                        c.showAllMovies();
                        System.out.println("Please input the movie's name you want to return:");
                        movieName = in.next();
                        System.out.println("Please input amount of the movie you want return:");
                        amount = in.next();
                        lib.returnMovie(c, movieName, amount);
                        break;
                    case 8:
                        System.out.println("Please input your library number: (00x-000x)");
                        libraryNumber = in.next();
                        lib.showCustomerInformation(libraryNumber);
                        break;
                }
                BibliotecaApp.menu();
            }
            System.out.println("Quit Biblioteca. Welcome you come back!");
        }

    }


}
