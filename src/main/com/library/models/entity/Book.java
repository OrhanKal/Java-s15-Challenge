package main.com.library.models.entity;

import main.com.library.models.people.Reader;

public class Book {
    private String id;
    private String title;
    private String author;
    private String category;
    private boolean isBorrowed;
    private String edition;
    private String status;
    private String dateOfPurchase;

    public Book(String id, String title, String author, String category, String edition, String dateOfPurchase) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isBorrowed = false;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
        this.status = "Available";
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

    public String getCategory() {
        return category;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public String getEdition() {
        return edition;
    }

    public String getStatus() {
        return status;
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public void changeOwner(Reader newOwner) {
        System.out.println("Ownership of the book has been transferred to: " + newOwner.getName());
    }
}
