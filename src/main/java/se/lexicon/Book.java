package se.lexicon;

import java.util.Objects;
import java.util.UUID;

public class Book {
    private final String id;
    private final String title;
    private final String author;
    private boolean isAvailable;
    private Person currentBorrower;

    public Book(String title, String author) {
        this.id = UUID.randomUUID().toString();
        this.title = Objects.requireNonNull(title, "Title cannot be null");
        this.author = Objects.requireNonNull(author, "Author cannot be null");
        this.isAvailable = true;
    }

    public Book(String title, String author, Person borrower) {
        this(title, author);
        setBorrower(borrower);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean getAvailability() {
        return isAvailable;
    }

    public Person getCurrentBorrower() {
        return currentBorrower;
    }

    public void setBorrower(Person borrower) {
        this.currentBorrower = borrower;
        this.isAvailable = (borrower == null);
    }

    public String displayBookInfo() {
        String borrowerInfo = currentBorrower != null ? " Borrower ID: " + currentBorrower.getId() : "Available";
        return String.format("Book[ID: %s, Title: %s, Author: %s, Status: %s]", id, title, author, borrowerInfo);
    }
}
