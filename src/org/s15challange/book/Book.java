package org.s15challange.book;


import org.s15challange.Status;
import org.s15challange.person.Author;
import org.s15challange.person.Reader;

import java.util.Objects;

public class Book {
    private int bookId;
    private Author author;
    private String name;
    private double price;
    private Status status;
    private String edition;
    private String dateOfPurchase;
    private Reader owner;
    private double dailyPrice;

    // Constructor
    public Book(int bookId, Author author, String name, double price, String edition, String dateOfPurchase, Status status, Reader owner, double dailyPrice) {
        this.bookId = bookId;
        this.author = author;
        this.name = name;
        this.price = price;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
        this.status = Status.AVAILABLE;
        this.owner = null;
        this.dailyPrice = dailyPrice;

        addBookToAuthor(author, this);
    }

    private void addBookToAuthor(Author author, Book book) {
        author.newBook(book);
    }


    // Getters
    public String getTitle() {
        return this.name;
    }

    public Author getAuthor() {
        return author;
    }

    public Integer getBookId() {
        return this.bookId;
    }

    public Reader getOwner() {
        return this.owner;
    }

    public Status getStatus() {
        return status;
    }

    public double getPrice() {
        return price;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }


    //Setters
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public void setOwner(Reader owner) {
        this.owner = owner;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }


    //Methods

    public void updateStatus(Status status) {
        this.status = status;
    }

    public void changeOwner(Reader newOwner) {
        this.owner = newOwner;
    }

    public void display() {
        System.out.println("Book ID: " + this.bookId);
        System.out.println("Title: " + this.name);
        System.out.println("Author: " + this.author);
        System.out.println("Price: " + this.price);
        System.out.println("Edition: " + this.edition);
        System.out.println("Purchase Date: " + this.dateOfPurchase);
        System.out.println("Available: " + (this.status));
        System.out.println("Owner: " + (this.owner != null ? this.owner.getName() : "None"));
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", author=" + author.getName() +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", edition='" + edition + '\'' +
                ", dateOfPurchase='" + dateOfPurchase + '\'' +
                ", owner=" + owner +
                ", dailyPrice=" + dailyPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Book book)) return false;
        return bookId == book.bookId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(bookId);
    }
}


