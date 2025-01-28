package org.s15challange;
import java.util.ArrayList;
import java.util.List;


public class Author extends Person {
    private List<Book> books = new ArrayList<>();

    public Author(String name, List<Book> books) {
        super(name);
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

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
}
