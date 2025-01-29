package main.com.library.models.progress;

public class MemberRecord {
    private String memberId;
    private String dateOfMembership;
    private int maxBookLimit;
    private int booksIssued;
    private String address;

    public MemberRecord(String memberId, String dateOfMembership, String address) {
        this.memberId = memberId;
        this.dateOfMembership = dateOfMembership;
        this.maxBookLimit = 5;
        this.booksIssued = 0;
        this.address = address;
    }

    public int getMaxBookLimit() {
        return maxBookLimit;
    }

    public int getBooksIssued() {
        return booksIssued;
    }

    public void increaseBooksIssued() {
        if (booksIssued < maxBookLimit) {
            booksIssued++;
        } else {
            System.out.println("Book limit reached!");
        }
    }

    public void decreaseBooksIssued() {
        if (booksIssued > 0) {
            booksIssued--;
        }
    }
}
