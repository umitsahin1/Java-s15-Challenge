package org.s15challange.person;

import org.s15challange.book.Book;
import org.s15challange.MemberRecord;
import org.s15challange.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Reader extends Person {
    private List<Book> books = new ArrayList<>();
    private MemberRecord record;

    //Constructors
    public Reader(String name, MemberRecord record) {
        super(name);
        this.record = record;
    }


    //Getters
    public List<Book> getBooks() {
        return books;
    }

    public MemberRecord getRecord() {
        return record;
    }


    //Methods
    public void purchaseBook(Book book) {
        books.add(book);
        book.changeOwner(this);
        book.updateStatus(Status.PURCHASED);
        System.out.println(getName() + "Book purchased: " + book.getTitle());
    }


    public void borrowBook(Book book) {
        if (book != null && book.getOwner() == null && books.size() < 5) {
            books.add(book);
            book.changeOwner(this);
            book.updateStatus(Status.BORROWED);
            record.incBookIssued();
            System.out.println(getName() + " borrowed " + book.getTitle());
        } else {
            System.out.println("Cannot borrow the book.");
        }
    }


    public void returnBook(Book book) {
        if (books.contains(book)) {
            books.remove(book);
            book.changeOwner(null);
            book.updateStatus(Status.AVAILABLE);
            record.decBookIssued();
            System.out.println(getName() + " returned " + book.getTitle());
        } else {
            System.out.println("You do not have the book " + book.getTitle());
        }
    }


    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println(getName() + " has no books.");
        } else {
            System.out.println(getName() + "'s books:");
            for (Book book : books) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }


    @Override
    public void whoYouAre() {
        System.out.println("I am Reader" + getName());
    }

    @Override
    public String toString() {
        return "Reader{" +
                "books=" + books +
                ", record=" + record +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Reader reader)) return false;
        return Objects.equals(books, reader.books) && Objects.equals(record, reader.record);
    }


    @Override
    public int hashCode() {
        return Objects.hash(books, record);
    }
}
