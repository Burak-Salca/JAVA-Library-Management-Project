package library;

import users.Member;

import java.util.Date;

public class Receipt {
    private static int idCounter = 1;
    private int id;
    private Book borrowedBook;
    private Date borrowDate;
    private double price;
    private Member member;

    public Receipt(Book borrowedBook, double price, Member member) {
        this.id = idCounter++;
        this.borrowedBook = borrowedBook;
        this.borrowDate = new Date();
        this.price = price;
        this.member = member;
    }

    public int getId() {
        return id;
    }

    public Book getBorrowedBook() {
        return borrowedBook;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public double getPrice() {
        return price;
    }

    public Member getMember() {
        return member;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", borrowedBook=" + borrowedBook.getBookName() +
                ", borrowDate=" + borrowDate +
                ", price=" + price +
                ", member=" + member.getName() +  // Üye adını ekliyoruz
                '}';
    }
}
