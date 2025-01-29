package main.com.library.models;

import main.com.library.models.entity.Book;
import main.com.library.models.entity.Library;
import main.com.library.models.people.Librarian;
import main.com.library.models.people.Reader;
import main.com.library.models.progress.MemberRecord;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Librarian librarian = new Librarian("Alice", "L1");
        Reader reader = new Reader("Recep", "R1", new MemberRecord("R1", "20.01.2025", "Maltepe"));

        Book book1 = new Book("B1", "Dune", "Ali Doe", "Bilim Kurgu", "First", "20.01.2025");
        Book book2 = new Book("B2", "Yüzüklerin Efendisi", "Ayşe Smith", "Fantastik", "First", "20.01.2025");

        librarian.addBook(book1, library);
        librarian.addBook(book2, library);

        librarian.lendBook(book1, reader);
        librarian.lendBook(book2, reader);

        System.out.println(reader.getName() + " has borrowed " + reader.getMemberRecord().getBooksIssued() +
                " out of " + reader.getMemberRecord().getMaxBookLimit() + " books.");

        Book book3 = new Book("B3", "Algorithms", "Alan Turing", "Programming", "Second", "21.01.2025");
        librarian.addBook(book3, library);
        librarian.lendBook(book3, reader); // Limitin dolduğu belirtilmeli

        librarian.returnBook(book1, reader);
        System.out.println(reader.getName() + " now has " + reader.getMemberRecord().getBooksIssued() +
                " books borrowed.");
    }
}
