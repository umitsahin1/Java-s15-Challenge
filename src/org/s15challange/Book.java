package org.s15challange;


public class Book {
    private int bookId;
    private Author author;
    private String name;
    private double price;
    private Status status;
    private String edition;
    private String dateOfPurchase;
    private Reader owner;

    // Constructor
    public Book(int bookId, Author author, String name, double price, String edition, String dateOfPurchase, Status status, Person owner) {
        this.bookId = bookId;
        this.author = author;
        this.name = name;
        this.price = price;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
        this.status = Status.AVAILABLE;
        this.owner = null;
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

    // Setters
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
}


