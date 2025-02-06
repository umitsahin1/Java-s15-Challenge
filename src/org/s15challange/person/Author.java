package org.s15challange.person;

import org.s15challange.book.Book;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class Author extends Person {
    private Set<Book> books = new HashSet<>();

    //Constructors
    public Author(String name, Set<Book> books) {
        super(name);
        this.books = books;
    }

    //Getters
    public Set<Book> getBooks() {
        return books;
    }

    //Setters
    public void setBooks(Set<Book> books) {
        this.books = books;
    }


    //Methods
    public void newBook(Book book) {
        books.add(book);
        System.out.println("New book added: " + book.getTitle());
    }

    public void showBooks() {
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
    }


    @Override
    public void whoYouAre() {
        System.out.println("I am Author" + getName());
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Author author)) return false;
        return Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(books);
    }

    @Override
    public String toString() {
        return "Author{" +
                "books=" + books +
                '}';
    }
}
