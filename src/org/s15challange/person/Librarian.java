package org.s15challange.person;

import org.s15challange.Bill;
import org.s15challange.book.Book;
import org.s15challange.Library;
import org.s15challange.Status;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Librarian {
    private String name;
    private int password;
    private Library library;

    //Constructors
    public Librarian(String name, int password,Library library) {
        this.name = name;
        this.password = password;
        this.library =library;
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getPassword() {
        return password;
    }


    //Methods
    public Book searchBookWithName( String search) {
        for(Book book: library.getBooks().values()){
            if(book.getTitle().equals(search)){
                return book;
            }
        }
        return null;
    }


    public Book searchBookWithId (Integer search) {
        return library.getBooks().get(search);
    }


    public Book searchBookWithAuthor( String search) {

        for(Book book: library.getBooks().values()){
            if(book.getAuthor().getName().equals(search)){
                return book;
            }
        }
        return null;
    }


    public Bill issueBook(Book book, Reader reader) {
        if (book.getStatus() != Status.AVAILABLE) {
            System.out.println("Book is not available for borrowing.");
        }
        if (reader.getBooks().size() >= reader.getRecord().getMaxBookLimit()) {
            System.out.println("Maximum 5 books allowed!");
        }

        library.lendBook(book, reader);
        return new Bill(reader, book);
    }


    public void returnBook(Book book, Reader reader) {
        if (book.getOwner() == null || !book.getOwner().equals(reader)) {
            System.out.println("This book is not borrowed by the given reader.");
        }
        library.takeBackBook(book, reader);
        System.out.println("Book returned: " + book.getTitle());
    }


    public int loanPeriod (String issueDate){
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate issueDateParsed = LocalDate.parse(issueDate, formatter);
        LocalDate today = LocalDate.now();
        int days = (int) ChronoUnit.DAYS.between(issueDateParsed, today);
        return days;

    }


    public double calculateFine( String issueDate) {
         int daysLate =loanPeriod(issueDate)- 30; //10 gün sonra gecikme bedeli uygulanır
        if (daysLate > 0) {
            return daysLate * 5; // Her gün için 5 TL ceza
        } else {
            return 0; // Gecikme 10 günü geçmediyse ceza yok
        }
    }



    public double createBill(Book book,String issueDate) {
        int days =loanPeriod(issueDate);
        if (book == null) {
            System.out.println("Invalid book.");
            return 0;
        }
        double fine = calculateFine(issueDate);
        return book.getDailyPrice()*days + fine;
    }



    public boolean verifyMember(Reader reader) {
        return reader != null && reader.getRecord() != null;
    }



    public void refundBook(Book book, Reader reader,String issueDate) {
        if (book.getOwner() != null && book.getOwner().equals(reader)) {
            System.out.println("This book is still borrowed by the reader.");
        }
        double refundAmount = book.getDailyPrice()*loanPeriod(issueDate);
        System.out.println("Refund issued to " + reader.getName() + ": " + refundAmount + " TL");
    }



    @Override
    public String toString() {
        return "Librarian{" +
                "name='" + name + '\'' +
                ", password=" + password +
                ", library=" + library +
                '}';
    }
}
