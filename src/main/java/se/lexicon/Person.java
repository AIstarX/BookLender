package se.lexicon;

import java.util.Arrays;

public class Person {
    private static int idCounter = 0;

    private final int id;
    private String firstName;
    private String lastName;
    private Book[] booksLoaned;

    public Person(String firstName, String lastName) {
        this.id = ++idCounter;
        this.firstName = firstName;
        this.lastName = lastName;
        this.booksLoaned = new Book[0];
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Book[] getBooksLoaned() {
        return booksLoaned;
    }

    public void borrowBook(Book book) {
        if (book == null || !book.getAvailability()) {
            throw new IllegalArgumentException("Book is not available for borrowing");
        }
        book.setBorrower(this);
        booksLoaned = Arrays.copyOf(booksLoaned, booksLoaned.length + 1);
        booksLoaned[booksLoaned.length - 1] = book;
    }

    public void returnBook(Book book) {
        if (book == null || book.getCurrentBorrower() != this) {
            throw new IllegalArgumentException("This book was not borrowed by this person");
        }
        book.setBorrower(null);
        Book[] updatedBooks = new Book[booksLoaned.length - 1];
        int index = 0;
        for (Book loanedBook : booksLoaned) {
            if (!loanedBook.equals(book)) {
                updatedBooks[index++] = loanedBook;
            }
        }
        booksLoaned = updatedBooks;
    }

    public String displayPersonInfo() {
        return String.format("Person[ID: %d, First Name: %s, Last Name: %s, Books Loaned: %d]", id, firstName, lastName, booksLoaned.length);
    }
}
