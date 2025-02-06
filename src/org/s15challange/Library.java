package org.s15challange;

import org.s15challange.book.Book;
import org.s15challange.person.Reader;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Library {
    private Map<Integer, Book> books = new HashMap<>();
    private Set<Reader> readers = new HashSet<>();


    //Constructors
    public Library(Map<Integer, Book> books, Set<Reader> readers) {
        this.books = books;
        this.readers = readers;
    }

    //Getters
    public Map<Integer, Book> getBooks() {
        return books;
    }

    public Set<Reader> getReaders() {
        return readers;
    }


    //Methods

    public void newBook(Book book) {
        books.put(book.getBookId(), book);
    }

    public void lendBook(Book book, Reader reader) {
        if (book.getStatus() == Status.AVAILABLE) {
            reader.borrowBook(book);
        }

    }

    public void takeBackBook(Book book, Reader reader) {
        reader.returnBook(book);
    }

    public void showBooks() {
        for (Book book : books.values()) {
            if(book == null){
                break;
            } else{
            System.out.println(book.getTitle() + " by " + book.getAuthor());}
        }
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", readers=" + readers +
                '}';
    }
}
