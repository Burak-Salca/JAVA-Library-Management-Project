package operations;

import Library.Book;
import Library.Library;
import java.util.List;


public interface AdminOperations  {

    void addBookToLibrary(Book book);
    void removeBookFromLibrary(int bookId);
    void updateBookInfo(int bookId, Book newBookDetails);
    Book findBookById(Library library, int bookId);
    Book findBookByName(Library library, String bookName);
    List<Book> findBookByWriter(Library library, String writerName);
    List<Book> findBooksByCategory(Library library, String categoryName);
}
