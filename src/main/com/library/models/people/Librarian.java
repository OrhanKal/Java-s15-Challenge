package main.com.library.models.people;

import main.com.library.models.entity.Book;
import main.com.library.models.entity.Library;

public class Librarian extends Person {
    public Librarian(String name, String id) {
        super(name, id);
    }

    @Override
    public String whoYouAre() {
        return "I am a librarian.";
    }

    public void addBook(Book book, Library library) {
        library.addBook(book);
    }

    public void lendBook(Book book, Reader reader) {
        if (!book.isBorrowed()) {
            book.setBorrowed(true);
            reader.borrowBook(book);
            System.out.println(book.getTitle() + " has been lent to " + reader.getName());
        } else {
            System.out.println("The book is already borrowed.");
        }
    }

    public void returnBook(Book book, Reader reader) {
        book.setBorrowed(false);
        reader.returnBook(book);
        System.out.println(book.getTitle() + " has been returned by " + reader.getName());
    }

    public boolean verifyMember(Reader reader) {
        return reader != null; //eğer kayıtlı bir kullanıcıysa true döner
    }

    public double calculateFine(Reader reader) {
        int overdueDays = 5; //örneğin kullanıcı 5 gün gecikmiş olsun
        return overdueDays * 1.5; //günlük 1.5 birim ceza
    }

    public void createBill(Reader reader) {
        double fineAmount = calculateFine(reader);
        System.out.println("Invoice generated for " + reader.getName() + ": " + fineAmount + " USD");
    }
}

