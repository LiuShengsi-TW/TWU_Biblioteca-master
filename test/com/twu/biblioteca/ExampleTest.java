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
        Customers c1 = new Customers("c0001","Rita");
        Customers c;

        c = lib.queryCustomersById("c0001");

        assertEquals(c.getCid(), c1.getCid());
    }

    @Test
    public void testCheckoutBook() {
        Library lib = new Library();
        Customers c1 = new Customers("c0001","Rita");
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
        Customers c1 = new Customers("c0001","Rita");
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


}
