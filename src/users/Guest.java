package users;


import library.Book;
import library.Library;
import operations.GuestOperations;

import java.util.ArrayList;
import java.util.List;

public class Guest extends Person implements GuestOperations{

    public Guest( String name, Library library) {
        super(name, library);
    }

    //Id ile search etme
    @Override
    public Book findBookById(Library library, int bookId) {
        for (Book book : library.getBooks()) {
            if (book.getBookId() == bookId) {
                System.out.println( bookId + " id numralı kitap: " + book);
                return book;
            }
        }
        System.out.println( bookId + " id numralı kitap bulunamadı.");
        return null;
    }

    //Name ile search etme
    @Override
    public Book findBookByName(Library library, String bookName) {
        for (Book book : library.getBooks()) {
            if (book.getBookName().equalsIgnoreCase(bookName)) {
                System.out.println(bookName + " isimli kitap: " + book);
                return book;
            }
        }
        System.out.println(bookName + " isimli kitap bulunamadı.");
        return null;
    }

    @Override
    public List<Book> findBooksByAuthor(Library library, String author) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : library.getBooks()) {
            // Kitabın yazarını kontrol et
            if (book.getAuthor().contains(author)) {
                booksByAuthor.add(book);
            }
        }
        if (booksByAuthor.isEmpty()) {
            System.out.println(author + " isimli yazara ait kitap bulunamadı.");
        }
        else {
            System.out.println(author + " isimli yazara ait bulunan kitaplar:");
            for (Book book : booksByAuthor) {
                System.out.println(book);
            }
        }
        return booksByAuthor;
    }

    @Override
    public List<Book> findBooksByCategory(Library library, String category) {
        List<Book> booksByCategory = new ArrayList<>();
        for (Book book : library.getBooks()) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                booksByCategory.add(book);
            }
        }

        if (booksByCategory.isEmpty()) {
            System.out.println(category + " kategorisine ait kitap bulunamadı.");
        } else {
            System.out.println(category + " kategorisine ait bulunan kitaplar:");
            for (Book book : booksByCategory) {
                System.out.println(book);
            }
        }
        return booksByCategory;
    }

    @Override
    public List<Book> findAvailableBooks(Library library) {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : library.getBooks()) {
            if (book.getStatus()) {
                availableBooks.add(book);
            }
        }

        if (availableBooks.isEmpty()) {
            System.out.println("Müsait durumda kitap bulunamadı.");
        } else {
            System.out.println("Müsait durumda bulunan kitaplar:");
            for (Book book : availableBooks) {
                System.out.println(book);
            }
        }
        return availableBooks;
    }


}
