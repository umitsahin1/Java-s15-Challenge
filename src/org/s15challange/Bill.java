package org.s15challange;

import org.s15challange.book.Book;
import org.s15challange.person.Reader;

public class Bill {
    private Reader reader;
    private Book book;
    private double amount;

    //Constructors
    public Bill(Reader reader, Book book) {
        this.reader = reader;
        this.book = book;
        this.amount = book.getPrice();
    }

    //Methods
    public void printBill() {
        System.out.println("Bill for " + reader.getName() + ":");
        System.out.println("Book: " + book.getTitle() + " - Amount: " + amount);
    }
}
