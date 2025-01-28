import library.*;
import users.Admin;
import users.Guest;
import users.Member;
import users.Person;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        initializeLibrary(library);

        boolean running = true;

        while (running) {
            System.out.println("\n=== Kütüphane Sistemine Hoş Geldiniz ===");
            System.out.println("Lütfen bir rol seçin:");
            System.out.println("1. Misafir");
            System.out.println("2. Üye");
            System.out.println("3. Admin");
            System.out.println("0. Çıkış");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Misafir olarak devam ediliyor...");
                    System.out.print("Misafir adı giriniz: ");
                    String guestName = scanner.nextLine();
                    Guest guest = new Guest(guestName, library);
                    System.out.println("Misafir başarıyla oluşturuldu ");
                    handleGuestOperations(scanner, guest, library);
                    break;
                case 2:
                    System.out.println("Üye olarak devam ediliyor...");
                    System.out.print("Üye adı giriniz: ");
                    String memberName = scanner.nextLine();
                    System.out.print("Üye bütçesi giriniz: ");
                    double memberBudget = scanner.nextDouble();
                    Member member = new Member(memberName,library,memberBudget);
                    System.out.println("Üye başarıyla oluşturuldu ");
                    handleMemberOperations(scanner, member, library);
                    break;
                case 3:
                    System.out.println("Admin olarak devam ediliyor...");
                    System.out.print("Admin adı giriniz: ");
                    String adminName = scanner.nextLine();
                    Admin admin = new Admin(adminName, library);
                    System.out.println("Admin başarıyla oluşturuldu ");
                    handleAdminOperations(scanner, admin, library);
                    break;
                case 0:
                    System.out.println("Sistemden çıkılıyor. İyi günler!");
                    running = false;
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
        scanner.close();
    }
    private static void handleGuestOperations(Scanner scanner, Guest guest, Library library){
        while (true) {
            System.out.println("\n=== Misafir İşlemleri ===");
            System.out.println("1. Kitap Ara");
            System.out.println("0. Ana Menüye Dön");
            System.out.print("Seçiminiz: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) break;

            switch (choice) {
                case 1:
                    searchBooks(scanner, guest, library);
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }
    private static void handleMemberOperations(Scanner scanner, Member member, Library library){
        while (true) {
            System.out.println("\n=== Üye İşlemleri ===");
            System.out.println("1. Kitap Ara");
            System.out.println("2. Kitap Ödünç Al");
            System.out.println("3. Kitap İade Et");
            System.out.println("0. Ana Menüye Dön");
            System.out.print("Seçiminiz: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) break;

            switch (choice) {
                case 1:
                    searchBooks(scanner, member, library);
                    break;
                case 2:
                    System.out.print("Ödünç almak istediğiniz kitabın ID'sini girin: ");
                    int bookIdToBorrow = scanner.nextInt();
                    scanner.nextLine();
                    member.borrowBook(bookIdToBorrow);
                    System.out.println("Güncel kitaplar: ");
                    library.getBooks().forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("İade etmek istediğiniz kitabın ID'sini girin: ");
                    int returnBookId = scanner.nextInt();
                    scanner.nextLine();
                    member.returnBook(returnBookId);
                    System.out.println("\n"+"Güncel kitaplar: ");
                    library.getBooks().forEach(System.out::println);
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }
    private static void handleAdminOperations(Scanner scanner, Admin admin, Library library){
        while (true) {
            System.out.println("\n=== Admin İşlemleri ===");
            System.out.println("1. Kitap Ara");
            System.out.println("2. Kitap Ekle");
            System.out.println("3. Kitap Sil");
            System.out.println("4. Kitap Bilgilerini Güncelle");
            System.out.println("0. Ana Menüye Dön");
            System.out.print("Seçiminiz: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Enter karakterini temizle

            if (choice == 0) break;

            switch (choice) {
                case 1:
                    searchBooks(scanner, admin, library);
                    break;
                case 2:
                    System.out.print("Eklenecek kitabın idsi: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Eklenecek kitabın adı: ");
                    String bookName = scanner.nextLine();
                    System.out.print("Eklenecek kitabın fiyatı: ");
                    double bookPrice = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Eklenecek kitabın yazarı: ");
                    String bookAuthor = scanner.nextLine();
                    System.out.print("Eklenecek kitabın kategorisi: ");
                    String bookCategory = scanner.nextLine();
                    Book newBook = new Book(bookId, bookName, bookPrice, bookAuthor, bookCategory);
                    admin.addBookToLibrary(library, newBook);
                    System.out.println("\nGüncel kitaplar: ");
                    library.getBooks().forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Silinecek kitabın ID'si: ");
                    int bookIdToRemove = scanner.nextInt();
                    scanner.nextLine();
                    admin.removeBookFromLibrary(library, bookIdToRemove);
                    System.out.println("\nMGüncel kitaplar:");
                    library.getBooks().forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Güncellenmek istenen kitabın ID'sini girin: ");
                    int bookIdToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Yeni kitap ismi: ");
                    String updatedBookName = scanner.nextLine();
                    System.out.print("Yeni kitap fiyatı: ");
                    double updatedBookPrice = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Yeni yazar: ");
                    String updatedAuthor = scanner.nextLine();
                    System.out.print("Yeni kategori: ");
                    String updatedCategory = scanner.nextLine();
                    System.out.print("Yeni durum (true/false): ");
                    boolean updatedStatus = scanner.nextBoolean();
                    scanner.nextLine();
                    Book updatedBookDetails = new Book(updatedBookName, updatedBookPrice, updatedAuthor, updatedCategory);
                    updatedBookDetails.setStatus(updatedStatus);
                    admin.updateBookInfo(library, bookIdToUpdate, updatedBookDetails);
                    System.out.println("\nMGüncel kitaplar:");
                    library.getBooks().forEach(System.out::println);
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }
    private static void searchBooks(Scanner scanner, Guest guest, Library library) {
        System.out.println("\nHangi kritere göre arama yapmak istersiniz?");
        System.out.println("1. ID ile");
        System.out.println("2. Yazar ile");
        System.out.println("3. Kategori ile");
        System.out.println("4. Durum (status) ile");
        System.out.println("5. Kitap İsmi ile");
        System.out.print("Seçiminiz: ");

        int searchChoice = scanner.nextInt();
        scanner.nextLine(); // Enter karakterini temizle

        switch (searchChoice) {
            case 1:
                System.out.print("Aranacak ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                guest.findBookById(library,id);
                break;
            case 2:
                System.out.print("Aranacak Yazar: ");
                String author = scanner.nextLine();
                guest.findBooksByAuthor(library,author);
                break;
            case 3:
                System.out.print("Aranacak Kategori: ");
                String category = scanner.nextLine();
                guest.findBooksByCategory(library,category);
                break;
            case 4:
                System.out.print("Aranacak Durum (true/false): ");
                boolean status = scanner.nextBoolean();
                scanner.nextLine();
                guest.findAvailableBooks(library);
                break;
            case 5:
                System.out.print("Aranacak Kitap İsmi: ");
                String name = scanner.nextLine();
                guest.findBookByName(library,name);
                break;
            default:
                System.out.println("Geçersiz seçim!");
        }
    }
    private static void initializeLibrary(Library library) {
        library.getBooks().add(new Book(1, "1984", 25.0,"George Orwell", "Kurgu"));
        library.getBooks().add(new Book(2, "Kozmos", 35.0, "Carl Sagan", "Bilim"));
        library.getBooks().add(new Book(3, "Nutuk", 40.0,"Mustafa Kemal Atatürk", "Tarih"));
        library.getBooks().add(new Book(4, "Hayvan Çiftliği", 20,"George Orwell", "Kurgu"));
        library.getBooks().add(new Book(5, "Sapiens", 50,"Yuval Noah Harari", "Tarih"));

        System.out.println("Kütüphane sistemi başlatılıyor. Mevcut kitaplar:");
        library.getBooks().forEach(System.out::println);
    }
}





