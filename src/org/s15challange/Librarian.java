package org.s15challange;

public class Librarian {
    private String name;
    private int password;

    public Librarian(String name, int password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getPassword() {
        return password;
    }

    public void searchBook(Book book, String search){

       if(book.getTitle() == search) {
           book.display();
       }
    }
}
