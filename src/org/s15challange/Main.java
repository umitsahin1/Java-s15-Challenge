package org.s15challange;

import org.s15challange.book.Book;
import org.s15challange.person.Author;
import org.s15challange.person.Librarian;
import org.s15challange.person.Reader;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Book> kitaplar = new HashMap<>();
        Set<Reader> okuyucular = new HashSet<>();
        Library kütüphane = new Library(kitaplar, okuyucular);

        // Kütüphaneci kurulumu
        Librarian kütüphaneci = new Librarian("Alice", 1234, kütüphane);

        // Test kullanıcısı (Okuyucu)
        MemberRecord kayit = new MemberRecord(1, Type.STUDENT, "John Doe", "123 Elm Street", "555-1234") {
            @Override
            public void payBill(double amount) {
                super.payBill(amount);
            }
        };
        Reader okuyucu1 = new Reader("John Doe", kayit);

        // Okuyucuyu kütüphaneye ekleme
        okuyucular.add(okuyucu1);

        while (true) {
            // Menü gösterimi
            System.out.println("\n** Kütüphane Sistemi **");
            System.out.println("1. Yeni kitap ekle");
            System.out.println("2. Kitap ID ile ara");
            System.out.println("3. Kitap İsim ile ara");
            System.out.println("4. Kitap Yazar ile ara");
            System.out.println("5. Kitap ödünç al");
            System.out.println("6. Kitap geri ver");
            System.out.println("7. Tüm kitapları listele");
            System.out.println("8. Çıkış");
            System.out.print("Bir seçenek girin (1-8): ");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    // Yeni kitap ekleme
                    System.out.print("Kitap ID'sini girin: ");
                    int kitapId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Kitap Başlığını girin: ");
                    String baslik = scanner.nextLine();
                    System.out.print("Kitap Yazarını girin: ");
                    String yazarAd = scanner.nextLine();
                    System.out.print("Kitap Fiyatını girin: ");
                    double fiyat = scanner.nextDouble();
                    System.out.print("Kitap Günlük Fiyatını girin: ");
                    double gunlukFiyat = scanner.nextDouble();
                    System.out.print("Kitap Baskısını girin: ");
                    scanner.nextLine();
                    String baski = scanner.nextLine();
                    System.out.print("Satın alım tarihini girin (yyyy-MM-dd): ");
                    String alımTarihi = scanner.nextLine();


                    Book yeniKitap = new Book(kitapId, new Author(yazarAd, new HashSet<>()), baslik, fiyat, baski, alımTarihi, Status.AVAILABLE, null, gunlukFiyat);
                    kütüphane.newBook(yeniKitap);
                    System.out.println("Kitap eklendi: " + yeniKitap.getTitle());
                    break;

                case 2:
                    // Kitap ID ile ara
                    System.out.print("Aranacak Kitap ID'sini girin: ");
                    int kitapIdArama = scanner.nextInt();
                    Book kitapById = kütüphaneci.searchBookWithId(kitapIdArama);
                    if (kitapById != null) {
                        System.out.println("Kitap ID ile bulundu: " + kitapById.getTitle());
                    } else {
                        System.out.println("Kitap bulunamadı.");
                    }
                    break;

                case 3:
                    // Kitap ismi ile ara
                    System.out.print("Aranacak Kitap Başlığını girin: ");
                    String kitapBaslikArama = scanner.nextLine();
                    Book kitapByName = kütüphaneci.searchBookWithName(kitapBaslikArama);
                    if (kitapByName != null) {
                        System.out.println("Kitap Başlık ile bulundu: " + kitapByName.getTitle());
                    } else {
                        System.out.println("Kitap bulunamadı.");
                    }
                    break;

                case 4:
                    // Kitap yazar ile ara
                    System.out.print("Aranacak Yazar Adını girin: ");
                    String yazarAdArama = scanner.nextLine();
                    Book kitapByAuthor = kütüphaneci.searchBookWithAuthor(yazarAdArama);
                    if (kitapByAuthor != null) {
                        System.out.println("Kitap Yazar ile bulundu: " + kitapByAuthor.getTitle());
                    } else {
                        System.out.println("Kitap bulunamadı.");
                    }
                    break;

                case 5:
                    // Kitap ödünç alma
                    System.out.print("Ödünç alınacak Kitap ID'sini girin: ");
                    int kitapIdOduncAlma = scanner.nextInt();
                    Book kitapOduncAl = kütüphaneci.searchBookWithId(kitapIdOduncAlma);
                    if (kitapOduncAl != null && kitapOduncAl.getOwner() == null) {
                        kütüphaneci.issueBook(kitapOduncAl, okuyucu1);
                        System.out.println("Kitap ödünç alındı: " + kitapOduncAl.getTitle());
                        System.out.println("Ödünç alınan kitap sayısı:" + okuyucu1.getRecord().getNoBooksIssued() );
                    } else {
                        System.out.println("Kitap ya mevcut değil ya da başka bir kullanıcı tarafından ödünç alındı.");
                    }
                    break;

                case 6:
                    // Kitap geri verme
                    System.out.print("Geri verilecek Kitap ID'sini girin: ");
                    int kitapIdGeriVerme = scanner.nextInt();
                    Book kitapGeriVer = kütüphaneci.searchBookWithId(kitapIdGeriVerme);
                    if (kitapGeriVer != null && kitapGeriVer.getOwner() != null) {
                        okuyucu1.returnBook(kitapGeriVer);
                        System.out.println("Kitap geri verildi: " + kitapGeriVer.getTitle());
                    } else {
                        System.out.println("Kitap bulunamadı veya siz bu kitabı ödünç almadınız.");
                    }
                    break;

                case 7:
                    // Tüm kitapları listele
                    kütüphane.showBooks();
                    break;

                case 8:
                    // Çıkış
                    System.out.println("Sistemden çıkılıyor. Hoşçakalın!");
                    return;

                default:
                    System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
            }
        }
    }
}
