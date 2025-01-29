package main.com.library.models.people;

import main.com.library.models.entity.Book;
import main.com.library.models.progress.MemberRecord;

import java.util.ArrayList;
import java.util.List;

public class Reader extends Person {
    private final int maxBookLimit = 5;
    private int booksIssued = 0;
    private List<Book> borrowedBooks = new ArrayList<>();
    private MemberRecord memberRecord;


    public Reader(String name, String id, MemberRecord memberRecord) {
        super(name, id);
        this.memberRecord = memberRecord;
    }


    public void borrowBook(Book book) {
        if (memberRecord.getBooksIssued() < memberRecord.getMaxBookLimit()) {
            borrowedBooks.add(book);
            memberRecord.increaseBooksIssued(); //memberRecord üzerinden limit kontrolü
            System.out.println(book.getTitle() + " has been borrowed by " + getName());
        } else {
            System.out.println("You have reached the maximum book limit!");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) { //kitabı listeden kaldırır
            memberRecord.decreaseBooksIssued(); //kitap sayısını azaltır
            System.out.println(book.getTitle() + " has been returned by " + getName());
        } else {
            System.out.println("This book was not borrowed by " + getName());
        }
    }

    @Override
    public String whoYouAre() {
        return "I am a reader.";
    }

    public int getMaxBookLimit() {
        return maxBookLimit;
    }

    public int getBooksIssued() {
        return booksIssued;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public MemberRecord getMemberRecord() {
        return memberRecord;
    }
}
