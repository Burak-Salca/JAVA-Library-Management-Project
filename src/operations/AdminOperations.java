package operations;

import library.Book;
import library.Library;


public interface AdminOperations  {
    void addBookToLibrary(Library library, Book book);
    void removeBookFromLibrary(Library library,int bookId);
    void updateBookInfo(Library library,int bookId, Book updatedBookDetails);
}
