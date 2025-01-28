



# 📚 Kütüphane Yönetim Sistemi

## 🚀 Proje Tanımı
Bu proje, kullanıcıların bir kütüphane sistemi üzerinden kitapları aramasını, ödünç almasını ve iade etmesini sağlayan bir **kütüphane yönetim sistemidir**. Ayrıca, **admin** kullanıcıları kitap ekleme, silme ve güncelleme gibi yönetimsel işlemler yapabilirler. Proje, kullanıcıların farklı rollerle (Misafir, Üye, Admin) farklı yetkilerle işlem yapabilmesini sağlar.

## 🔧 Sistemde Yapılabilecekler

Sistemde aşağıdaki işlemleri gerçekleştirebilirsiniz:

1. **🔍 Kitap Arama**: Kitapları ID, yazar, kategori, durum (kullanılabilirlik) veya isimle arayabilirsiniz.
2. **📚 Kitap Ödünç Alma (Üye)**: Üyeler, mevcut kitaplar arasından bir kitabı ödünç alabilirler.
3. **↩️ Kitap İade Etme (Üye)**: Üyeler, ödünç aldıkları kitapları geri iade edebilirler.
4. **➕ Kitap Ekleme (Admin)**: Admin kullanıcıları yeni kitaplar ekleyebilir.
5. **❌ Kitap Silme (Admin)**: Admin kullanıcıları mevcut kitapları sistemden silebilir.
6. **✏️ Kitap Bilgilerini Güncelleme (Admin)**: Admin kullanıcıları, kitapların bilgilerini güncelleyebilir.

## 👥 Roller ve Tanımları

Sistemde üç ana rol bulunmaktadır:

### 1. **👤 Misafir**
Misafir kullanıcılar, sisteme herhangi bir üyelik olmadan erişebilirler. Misafir olarak giriş yapan kullanıcılar yalnızca kitap arama işlemleri yapabilirler. Kitap ödünç alma veya iade etme işlemlerini gerçekleştiremezler.

### 2. **💼 Üye**
Üyeler, sisteme kayıtlı kullanıcılar olup, kitap ödünç alma ve iade etme işlemleri yapabilirler. Ayrıca kitapları arayabilirler. Üyeler, sistemdeki kitapların mevcut durumuna göre işlem yapabilirler.

### 3. **🛠️ Admin**
Admin kullanıcıları, sisteme tam erişimi olan yönetici rolüdür. Admin'ler kitap ekleyebilir, silebilir ve mevcut kitapların bilgilerini güncelleyebilir. Ayrıca, tüm ödünç alınan kitapları görüntüleyebilirler.

## 🖥️ Sistem Kullanımı

### 1️⃣ Adım: Sistemi Başlatın
Projenizi çalıştırmak için terminal veya IDE kullanarak `Main` sınıfını çalıştırın. 

### 2️⃣ Adım: Rol Seçimi
Sistemi çalıştırdığınızda, bir rol seçmeniz istenecektir. Aşağıdaki seçenekler mevcuttur:
1. **Misafir**: Kitapları arayabilirsiniz.
2. **Üye**: Kitapları arayabilir, ödünç alabilir ve iade edebilirsiniz.
3. **Admin**: Kitapları ekleyebilir, silebilir ve güncelleyebilirsiniz.

### 3️⃣ Adım: İşlem Yapın
Rolünüze göre ilgili işlemleri seçebilirsiniz. Kitap arama, ödünç alma, iade etme veya admin olarak kitap yönetimi işlemleri yapılabilir.

## ⚙️ Gerekli Bağımlılıklar
- Java 8 veya daha yeni bir sürüm
- IDE: IntelliJ IDEA, Eclipse veya herhangi bir Java IDE'si


