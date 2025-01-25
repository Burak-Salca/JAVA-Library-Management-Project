package Users;


import Library.Book;
import Library.Library;
import operations.AdminOperations;

public class Admin extends People implements AdminOperations {

    private Library library;

    public Admin(int id, String name, Library library) {
        super(id, name);
        this.library = library;
    }

    @Override
    public void addBookToLibrary(Library library, Book book) {
        // Kitap ID'sini kontrol et
        for (Book existingBook : library.getBooks()) {
            if (existingBook.getBookId() == book.getBookId()) {
                System.out.println(book.getBookId() + " id numralı kitap zaten mevcut.");
                return; // Kitap zaten varsa, eklemeyi durdur
            }
        }

        // Kitap ID'si yoksa, kitap eklenebilir
        library.getBooks().add(book);
        System.out.println(book.getBookId() + " id numralı kitap başarıyla eklendi: " + book.getBookName());

        // Kategoriyi kontrol et, eğer yoksa ekle
        if (!library.getCategories().contains(book.getCategory())) {
            library.getCategories().add(book.getCategory());
        }

        // Yazarı kontrol et, eğer yoksa ekle
        if (!library.getAuthors().contains(book.getAuthor())) {
            library.getAuthors().add(book.getAuthor());
        }
    }

    @Override
    public void removeBookFromLibrary(Library library, int bookId) {
        Book bookToRemove = null;
        // Kitap ID'sini kontrol et ve kitap var mı bak
        for (Book book : library.getBooks()) {
            if (book.getBookId() == bookId) {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove == null) {
            System.out.println(bookId + " id numaralı kitap mevcut değil.");
            return;
        }
        // Kitap bulundu, books listesinden sil
        library.getBooks().remove(bookToRemove);
        System.out.println(bookId + " id numaralı kitap başarıyla silindi: " + bookToRemove.getBookName());

        // Kategori kontrolü: Eğer kitap silindiğinde, kategoriye ait başka kitap yoksa, kategori setinden sil
        String categoryToRemove = bookToRemove.getCategory();
        boolean categoryExists = false;
        for (Book book : library.getBooks()) {
            if (book.getCategory().equals(categoryToRemove)) {
                categoryExists = true;
                break;
            }
        }
        if (!categoryExists) {
            library.getCategories().remove(categoryToRemove);
        }

        // Yazar kontrolü: Eğer kitap silindiğinde, yazara ait başka kitap yoksa, yazar setinden sil
        String authorToRemove = bookToRemove.getAuthor();
        boolean authorExists = false;
        for (Book book : library.getBooks()) {
            if (book.getAuthor().equals(authorToRemove)) {
                authorExists = true;
                break;
            }
        }
        if (!authorExists) {
            library.getAuthors().remove(authorToRemove);
        }
    }


    /*
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

    //Kitap search etme işlemleri
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
    public List<Book> findBooksByWriter(Library library, String writerName) {
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
    }*/

}
