package operations;

import Library.Book;
import Library.Library;


public interface AdminOperations  {

    void addBookToLibrary(Library library, Book book);
    void removeBookFromLibrary(Library library,int bookId);
    /*void updateBookInfo(int bookId, Book newBookDetails);
    Book findBookById(Library library, int bookId);
    Book findBookByName(Library library, String bookName);
    List<Book> findBooksByWriter(Library library, String writerName);
    List<Book> findBooksByCategory(Library library, String categoryName);*/

}
