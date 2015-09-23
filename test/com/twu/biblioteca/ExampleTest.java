package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void testQueryBookById() {

        Library lib = new Library();
        Book b;
        Book b1 = new Book("b0001", "Jane Eyre", "Charlotte Bronte", "UK's Press", "2007-8", 100.00, 5);

        b = lib.queryBookById("b0001");
        assertEquals(b.getId(), b1.getId());
    }

    @Test
    public void testQueryCustomersById() {

        Library lib = new Library();
        Customers c1 = new Customers("c0001","Rita","001-0001","aaa100","rita@126.com","13720270869");
        Customers c;

        c = lib.queryCustomersById("c0001");

        assertEquals(c.getCid(), c1.getCid());
    }

    @Test
    public void testCheckoutBook() {

        Library lib = new Library();
        Customers c1 = new Customers("c0001","Rita","001-0001","aaa100","rita@126.com","13720270869");
        boolean result1;
        boolean result2;
        boolean result3;

        result1 = lib.checkoutBook(c1, "b0001", "3");
        assertEquals(result1, true);

        result2 = lib.checkoutBook(c1, "b0001", "6");
        assertEquals(result2, false);

        result3 = lib.checkoutBook(c1, "b001", "3");
        assertEquals(result3, false);
    }

    @Test
    public void testReturnBook() {

        Library lib = new Library();
        Customers c1 = new Customers("c0001","Rita","001-0001","aaa100","rita@126.com","13720270869");
        boolean result1;
        boolean result2;
        boolean result3;
        boolean result4;

        lib.checkoutBook(c1, "b0001", "3");

        result1 = lib.returnBook(c1, "b0001", "1");
        assertEquals(result1, true);

        result2 = lib.returnBook(c1, "b0001", "6");
        assertEquals(result2, false);

        result3 = lib.returnBook(c1, "b001", "3");
        assertEquals(result3, false);

        result4 = lib.returnBook(c1, "b0001", "2");
        assertEquals(result4, true);
    }

    @Test
    public void testCheckoutMovie() {

        Library lib = new Library();
        Customers c1 = new Customers("c0001","Rita","001-0001","aaa100","rita@126.com","13720270869");
        boolean result1;
        boolean result2;
        boolean result3;

        result1 = lib.checkoutMovie(c1, "Avatar", "3");
        assertEquals(result1, true);

        result2 = lib.checkoutMovie(c1, "Avatar", "7");
        assertEquals(result2, false);

        result3 = lib.checkoutMovie(c1, "Avata", "3");
        assertEquals(result3, false);
    }

    @Test
    public void testReturnMovie() {

        Library lib = new Library();
        Customers c1 = new Customers("c0001","Rita","001-0001","aaa100","rita@126.com","13720270869");
        boolean result1;
        boolean result2;
        boolean result3;
        boolean result4;

        lib.checkoutMovie(c1, "Avatar", "4");

        result1 = lib.returnMovie(c1, "Avatar", "1");
        assertEquals(result1, true);

        result2 = lib.returnMovie(c1, "Avatar", "6");
        assertEquals(result2, false);

        result3 = lib.returnMovie(c1, "Avata", "3");
        assertEquals(result3, false);

        result4 = lib.returnMovie(c1, "Avatar", "3");
        assertEquals(result4, true);
    }

    @Test
    public void testShowCustomerInformation() {

        Library lib = new Library();
        Customers c1 = new Customers("c0001","Rita","001-0001","aaa100","rita@126.com","13720270869");
        Customers c;

        c = lib.showCustomerInformation("001-0001");
        assertEquals(c.getCid(), c1.getCid());
    }

    @Test
    public void testLogin() {

        Library lib = new Library();
        boolean result;

        result = lib.Login("001-0001","aaa100");
        assertEquals(result, true);

    }



}
