package main.com.library.models.people;

import main.com.library.models.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person {
    private List<Book> books;

    public Author(String name, String id) {
        super(name, id);
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String whoYouAre() {
        return "I am an author.";
    }
}
