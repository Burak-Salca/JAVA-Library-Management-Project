package operations;

import library.Book;
import library.Library;

import java.util.List;


public interface GuestOperations {
    Book findBookById(Library library, int bookId);
    Book findBookByName(Library library, String bookName);
    List<Book> findBooksByAuthor(Library library, String author);
    List<Book> findBooksByCategory(Library library, String category);
    List<Book> findAvailableBooks(Library library);
}
