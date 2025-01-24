package Users;


import Library.Book;
import Library.Library;
import operations.AdminOperations;

import java.util.ArrayList;
import java.util.List;

public class Admin extends People implements AdminOperations {

    private Library library;

    public Admin(int id, String name, Library library) {
        super(id, name);
        this.library = library;
    }

    @Override
    public void addBookToLibrary(Book book) {
        library.getBooks().add(book);
    }

    @Override
    public void removeBookFromLibrary(int bookId) {
        library.getBooks().removeIf(book -> book.getBookId() == bookId);
    }

    @Override
    public void updateBookInfo(int bookId, Book newBookDetails) {
        boolean bookFound = false;
        for (Book book : library.getBooks()) {
            if (book.getBookId() == bookId) {
                book.setBookName(newBookDetails.getBookName());
                book.setWriter(newBookDetails.getWriter());
                book.setCategory(newBookDetails.getCategory());
                book.setStatus(newBookDetails.getStatus());
                bookFound = true;
                break;
            }
        }
        if (!bookFound) {
            System.out.println("Library'de " + bookId + " numaralı kitap bulunamadı.");
        }
    }

    @Override
    public List<Book> findBooksByCategory(Library library, String categoryName) {
        List<Book> booksInCategory = new ArrayList<>();
        for (Book book : library.getBooks()) {
            if (book.getCategory().getCategoryName().equalsIgnoreCase(categoryName)) {
                booksInCategory.add(book);
            }
        }
        if (!booksInCategory.isEmpty()) {
            System.out.println( categoryName + " kategorisine ait kitaplar:");
            for (Book book : booksInCategory) {
                System.out.println(book.getBookName());
            }
        } else {
            System.out.println(categoryName + " kategorisine ait kitap bulunamadı.");
        }
        return booksInCategory;
    }

    @Override
    public List<Book> findBookByWriter(Library library, String writerName) {
        List<Book> booksByWriter = new ArrayList<>();
        for (Book book : library.getBooks()) {
            if (book.getWriter().getWriterName().equalsIgnoreCase(writerName)) {
                booksByWriter.add(book);
            }
        }
        if (!booksByWriter.isEmpty()) {
            System.out.println( writerName + " yazarına ait kitaplar:");
            for (Book book : booksByWriter) {
                System.out.println(book.getBookName());
            }
        } else {
            System.out.println( writerName + " yazarına ait kitap bulunamadı.");
        }
        return booksByWriter;
    }

    @Override
    public Book findBookByName(Library library, String bookName) {
        for (Book book : library.getBooks()) {
            if (book.getBookName().equalsIgnoreCase(bookName)) {
                System.out.println( bookName + " ismindeki kitap bulundu.");
                return book;
            }
        }
        System.out.println( bookName + " ismindeki kitap bulunamadı.");
        return null;
    }

    @Override
    public Book findBookById(Library library, int bookId) {
        for (Book book : library.getBooks()) {
            if (book.getBookId() == bookId) {
                System.out.println( bookId + " id numaralı kitap bulundu: " + book.getBookName());
                return book;
            }
        }
        System.out.println( bookId + " id numaralı kitap bulunamadı.");
        return null;
    }
}
