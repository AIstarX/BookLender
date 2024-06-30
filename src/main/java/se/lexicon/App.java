package se.lexicon;

import se.lexicon.Book;
import se.lexicon.Person;

public class App {
    public static void main(String[] args) {
        // Create book instances
        Book book1 = new Book("Java the complete reference", "Herbert Schildt");
        Book book2 = new Book("Head First Java", "Katty Sierra");

        // Display book information
        System.out.println("Initial Book Information:");
        System.out.println(book1.displayBookInfo());
        System.out.println(book2.displayBookInfo());
        System.out.println();

        // Create a person instance
        Person person1 = new Person("Tony", "Luna");

        // Display person information
        System.out.println("Initial Person Information:");
        System.out.println(person1.displayPersonInfo());
        System.out.println();

        // Loan a book to the person
        person1.borrowBook(book1);

        // Display person and book information after borrowing
        System.out.println("Person Information after borrowing a book:");
        System.out.println(person1.displayPersonInfo());
        System.out.println("Book Information after being borrowed:");
        System.out.println(book1.displayBookInfo());
        System.out.println(book2.displayBookInfo());
        System.out.println();

        // Return the borrowed book
        person1.returnBook(book1);

        // Display person and book information after returning
        System.out.println("Person Information after returning the book:");
        System.out.println(person1.displayPersonInfo());
        System.out.println("Book Information after being returned:");
        System.out.println(book1.displayBookInfo());
        System.out.println(book2.displayBookInfo());
    }
}
