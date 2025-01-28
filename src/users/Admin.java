package users;


import library.Book;
import library.Library;
import operations.AdminOperations;

import java.util.Map;

public class Admin extends Guest implements AdminOperations {


    public Admin( String name, Library library) {
        super( name, library);
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

    @Override
    public void updateBookInfo(Library library, int bookId, Book updatedBookDetails) {
        Book bookToUpdate = null;
        // ID kontrolü
        for (Book book : library.getBooks()) {
            if (book.getBookId() == bookId) {
                bookToUpdate = book;
                break;
            }
        }
        if (bookToUpdate == null) {
            System.out.println( bookId + " id numaralı kitap bulunamadı.");
            return;
        }
        // Güncellemden önce eski kategori ve yazarı al
        String oldCategory = bookToUpdate.getCategory();
        String oldAuthor = bookToUpdate.getAuthor();
        //Güncellemeyi yap
        bookToUpdate.setBookName(updatedBookDetails.getBookName());
        bookToUpdate.setPrice(updatedBookDetails.getPrice());
        bookToUpdate.setAuthor(updatedBookDetails.getAuthor());
        bookToUpdate.setCategory(updatedBookDetails.getCategory());
        bookToUpdate.setStatus(updatedBookDetails.getStatus());
        // Yeni kategori ve yazarı kontrol et
        if (!library.getCategories().contains(bookToUpdate.getCategory())) {
            library.getCategories().add(bookToUpdate.getCategory());
        }
        if (!library.getAuthors().contains(bookToUpdate.getAuthor())) {
            library.getAuthors().add(bookToUpdate.getAuthor());
        }
        // Eski kategori başka kitaplarda kullanılmıyorsa, Set'ten kaldır
        boolean isOldCategoryUsed = library.getBooks().stream()
                .anyMatch(book -> book.getCategory().equalsIgnoreCase(oldCategory));
        if (!isOldCategoryUsed) {
            library.getCategories().remove(oldCategory);
        }
        // Eski yazar başka kitaplarda kullanılmıyorsa, Set'ten kaldır
        boolean isOldAuthorUsed = library.getBooks().stream()
                .anyMatch(book -> book.getAuthor().equalsIgnoreCase(oldAuthor));
        if (!isOldAuthorUsed) {
            library.getAuthors().remove(oldAuthor);
        }
        System.out.println("Kitap bilgileri başarıyla güncellendi: " + bookToUpdate);
    }

    @Override
    public void showBorrowedBooks(Library library) {
        if (library.getBorrowedBooks().isEmpty()) {
            System.out.println("Henüz ödünç alınmış kitap yok.");
        } else {
            System.out.println("\n=== Ödünç Alınan Kitaplar ===");
            for (Map.Entry<Book, Member> entry : library.getBorrowedBooks().entrySet()) {
                Book book = entry.getKey();
                Member member = entry.getValue();
                System.out.println("Kitap: " + book.getBookName() + " | Üye: " + member.getName());
            }
        }
    }
}
