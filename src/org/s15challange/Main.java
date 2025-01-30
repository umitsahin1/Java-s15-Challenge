package org.s15challange;

import org.s15challange.book.Book;
import org.s15challange.person.Author;
import org.s15challange.person.Librarian;
import org.s15challange.person.Reader;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Yazarlar
        Author author1 = new Author("John Doe", new HashSet<>());
        Author author2 = new Author("Jane Smith", new HashSet<>());

        // Kitaplar
        Book book1 = new Book(1, author1, "Java Programming", 50.0, "1st Edition", "2023-01-01", Status.AVAILABLE, null, 1);
        Book book2 = new Book(2, author1, "Advanced Java", 60.0, "2nd Edition", "2023-06-15", Status.AVAILABLE, null, 2);
        Book book3 = new Book(3, author2, "Python Basics", 40.0, "1st Edition", "2023-03-10", Status.AVAILABLE, null, 1.5);


        // Üye kayıtları
        MemberRecord studentRecord = new MemberRecord(1, Type.STUDENT, "Alice", "123 Main St", "123-456-7890") {
        };
        MemberRecord academicRecord = new MemberRecord(2, Type.FACULTY, "Bob", "456 Elm St", "987-654-3210") {
        };

        // Okuyucular
        Reader reader1 = new Reader("Alice", studentRecord);
        Reader reader2 = new Reader("Bob", academicRecord);

        // Kütüphane
        Map<Integer, Book> bookMap = new HashMap<>();
        Set<Reader> readerSet = new HashSet<>();
        Library library = new Library(bookMap, readerSet);

        // Kütüphaneye kitap ekleme
        library.newBook(book1);
        library.newBook(book2);
        library.newBook(book3);

        // Kütüphaneci
        Librarian librarian = new Librarian("Carol", 1234, library);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter author name:");
        String authorName = scanner.nextLine();
        Author newAuthor = new Author(authorName, new HashSet<>());
        System.out.println("Enter book id:");
        int bookId = scanner.nextInt();
        System.out.println("Enter book name:");
        String name = scanner.nextLine();
        System.out.println("Enter book price:");
        double price = scanner.nextDouble();
        System.out.println("Enter book edition:");
        String edition = scanner.nextLine();
        System.out.println("Daily Price");
        double dailyPrice = scanner.nextDouble();

        Book kitap = new Book(bookId, newAuthor, name, price, edition, null, Status.AVAILABLE, null, dailyPrice);
        System.out.println(kitap.toString());
        library.newBook(kitap);

        System.out.println("Select one parameter for search : [id, name, author]");
        String searchType = scanner.nextLine();

        switch (searchType) {
            case "id":
                System.out.println("Enter bookId:");
                Integer searchbookId = Integer.valueOf(scanner.nextLine());
                Book searcBook = librarian.searchBookWithId(searchbookId);
                if (Objects.nonNull(searcBook)) {
                    System.out.println(searcBook.toString());
                } else {
                    System.out.println("Book not found");
                }
                break;

            case "name":
                System.out.println("Enter bookName:");
                String searchbookName = scanner.nextLine();
                Book searchBook2 = librarian.searchBookWithName(searchbookName);
                if (Objects.nonNull(searchBook2)) {
                    System.out.println(searchBook2.toString());
                } else {
                    System.out.println("Book not found");
                }
                break;

            case "author":
                System.out.println("Enter bookAuthor:");
                String searchbookAuthor = scanner.nextLine();
                Book searchBook3 = librarian.searchBookWithAuthor(searchbookAuthor);
                if (Objects.nonNull(searchBook3)) {
                    System.out.println(searchBook3.toString());
                } else {
                    System.out.println("Book not found");
                }
                break;

            default:
                System.out.println("Wrong input");
        }

    }

}

