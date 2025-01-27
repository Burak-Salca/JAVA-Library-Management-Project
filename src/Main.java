import library.*;
import users.Admin;
import users.Member;

import java.util.Map;


public class Main {
    public static void main(String[] args) {

        //Kütüphane ve kadrolar oluşturuldu
        Library library = new Library();

        //Kitaplar getirildi
        Book book1 = new Book(1,"book1",100,"Ahmet Ümit","Polisiye");
        Book book2 = new Book(2,"book2",100,"Lütfü Livaneli","Polisiye");
        Book book3 = new Book(3,"book3",100,"Namık Kemal","Edebiyat");
        Book book4 = new Book(4,"book4",100,"Atatürk","Söylev");
        Book bookDuplicate = new Book(1,"bookDuplicate", 100,"Author One", "Category One");


        //Kütüphane görevlisi kaydı yapıldı
        Admin admin1 = new Admin(1,"admin1",library);
        Member member1 = new Member(1,"member1",library,10000,null);
        Member member2 = new Member(2,"member2",library,10000,null);

        //Kitaplar kütüpahane sistemine eklenmesi-çıkarılması-güncellenmesi
        admin1.addBookToLibrary(library,book1);
        admin1.addBookToLibrary(library,book2);
        admin1.addBookToLibrary(library,book3);
        admin1.addBookToLibrary(library,book4);
        admin1.addBookToLibrary(library, bookDuplicate);
        //admin1.removeBookFromLibrary(library,book3.getBookId());
        //admin1.removeBookFromLibrary(library,book2.getBookId());
        admin1.updateBookInfo(library, book3.getBookId(), new Book("updatedBook3",100,"Cemal Süreyya","Şiir"));
        //admin1.removeBookFromLibrary(library,book3.getBookId());
        admin1.findBookById(library,1);
        admin1.findBooksByCategory(library,"polisiye");
        member1.borrowBook(1);
        member1.borrowBook(2);
        member2.borrowBook(3);
        member1.returnBook(1);
        
        System.out.println("\n***************************************");
        System.out.println("Ödünç alınan kitaplar:");
        for (Map.Entry<Book, Member> entry : library.getBorrowedBooks().entrySet()) {
            System.out.println("Kitap: " + entry.getKey().getBookName() + " -> Üye: " + entry.getValue().getName());
        }

        System.out.println("\n***************************************");
        //Kütüphanedeki kitaplar
        System.out.println("\nKütüphanedeki Kitaplar::");
        for (Book book : library.getBooks()) {
            System.out.println("ID: " + book.getBookId() + " - " +book.getBookName() + " - " + book.getAuthor() + " - " + book.getCategory() + " - " + book.getStatus());
        }
        System.out.println("\n***************************************");
        //Kütüphanedeki kategoriler
        System.out.println("\nKategoriler:");
        for (String category : library.getCategories()) {
            System.out.println(category);
        }
        System.out.println("\n***************************************");
        //Kütüphanedi yazarlar
        System.out.println("\nYazarlar:");
        for (String author : library.getAuthors()) {
            System.out.println(author);
        }
        System.out.println("\n***************************************");



    }
}