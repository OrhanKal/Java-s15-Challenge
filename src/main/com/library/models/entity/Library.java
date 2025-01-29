package main.com.library.models.entity;

import main.com.library.models.people.Reader;

import java.util.*;

public class Library {
    private Set<Book> books = new HashSet<>();
    private List<Reader> readers = new ArrayList<>();
    private Map<Reader, List<Book>> borrowedBooks = new HashMap<>(); //reader ve ödünç aldığı kitaplar arasındaki ilişki


    public List<Reader> getReaders() {
        return readers;
    }

    public Reader getReader(String readerId) {
        for (Reader reader : readers) {
            if (reader.getId().equals(readerId)) {
                return reader;
            }
        }
        return null;
    }

    public void lendBook(Book book, Reader reader) {
        if (!book.isBorrowed()) {
            borrowedBooks.putIfAbsent(reader, new ArrayList<>());
            borrowedBooks.get(reader).add(book);
            book.setBorrowed(true);
            System.out.println(book.getTitle() + " has been lent to " + reader.getName());
        } else {
            System.out.println("The book is already borrowed.");
        }
    }

    public void takeBackBook(Book book, Reader reader) {
        if (borrowedBooks.containsKey(reader) && borrowedBooks.get(reader).remove(book)) {
            book.setBorrowed(false);
            System.out.println(book.getTitle() + " has been returned by " + reader.getName());
        } else {
            System.out.println("This book was not borrowed by " + reader.getName());
        }
    }

    public Map<Reader, List<Book>> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addBook(Book book) {
        if (books.add(book)) { //set içine ekleme işlemi
            System.out.println(book.getTitle() + " has been added to the library.");
        } else {
            System.out.println("This book already exists in the library.");
        }
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Book findBookById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> getBooksByCategory(String category) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                result.add(book);
            }
        }
        return result;
    }
}
