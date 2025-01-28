package users;

import library.Library;
import library.Book;
import library.Receipt;
import operations.MemberOperations;

import java.util.ArrayList;
import java.util.List;

public class Member extends Guest implements MemberOperations {

    private double budget;
    private List<Book> borrowedBooks;


    public Member(String name, Library library, double budget) {
        super(name, library);
        this.budget = budget;
        this.borrowedBooks = new ArrayList<>();
    }

    @Override
    public void borrowBook(int bookId) {
        Book bookToBorrow = findBookById(getLibrary(),bookId);
        if (bookToBorrow == null) {
            System.out.println("Kitap bulunamadı.\n");
        } else if (!bookToBorrow.getStatus()) {
            System.out.println("Kitap müsait değil.\n");
        } else if (budget < bookToBorrow.getPrice()) {
            System.out.println("Yeterli bütçeniz yok.\n");
        } else if (borrowedBooks.size() >= 5) {
            System.out.println("Kitap limiti aşıldı! En fazla 5 kitap ödünç alabilirsiniz.\n");
        } else {
            bookToBorrow.setStatus(false);
            borrowedBooks.add(bookToBorrow);
            getLibrary().getBorrowedBooks().put(bookToBorrow, this);
            budget -= bookToBorrow.getPrice();
            //Fiş oluşturma
            Receipt receipt = new Receipt(bookToBorrow, bookToBorrow.getPrice(),this);
            getLibrary().getReceipts().add(receipt);
            System.out.println("\n"+"Ödünç işlemi başarılı! \nFiş: " + receipt);
            System.out.println(getName() + " adlı üye " + bookToBorrow.getBookName() + " kitabını ödünç aldı." + " güncel bütçe: "+ budget);
        }
        System.out.println(getName() + " adlı üyenin sahip olduğu kitaplar: ");
        for (Book book : borrowedBooks) {
            System.out.print(book.getBookName() + ", ");
        }
        System.out.println("\n");
    }
    @Override
    public void returnBook(int bookId) {
        Book bookToReturn = null;
        for (Book book : borrowedBooks) {
            if (book.getBookId() == bookId) {
                bookToReturn = book;
                break;
            }
        }
        if (bookToReturn == null) {
            System.out.println("İade etmek istediğiniz kitaba sahip değilsiniz.\n");
        }
        else {
            bookToReturn.setStatus(true);
            borrowedBooks.remove(bookToReturn);
            getLibrary().getBorrowedBooks().remove(bookToReturn, this);
            budget += bookToReturn.getPrice();
            //Fişin geri iade edilmesi
            Receipt receiptToRemove = null;
            for (Receipt receipt : getLibrary().getReceipts()) {
                if (receipt.getBorrowedBook().equals(bookToReturn) && receipt.getMember().equals(this)) {
                    receiptToRemove = receipt;
                    break;
                }
            }

            if (receiptToRemove != null) {
                getLibrary().getReceipts().remove(receiptToRemove);
            }
            System.out.println(getName() + " adlı üye " + bookToReturn.getBookName() + " kitabını geri verdi." + " güncel bütçe: "+ budget );
        }
        System.out.println(getName() + " adlı üyenin sahip olduğu kitaplar: ");
        for (Book book : borrowedBooks) {
            System.out.print(book.getBookName() + ", ");
        }
        System.out.println("\n");
    }
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    @Override
    public String toString() {
        return "Member{" +
                "budget=" + budget +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}
