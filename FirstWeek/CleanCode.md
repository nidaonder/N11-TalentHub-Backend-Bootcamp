## CLEAN CODE

1. ANLAMLI İSİMLENDİRMELER:

* İyi isim seçmek zaman alır, ancak uzun vadede daha çok zaman kazandırır.
* Küçük "l" ya da büyük "O" kullanımı kafa karışıklığına neden olabilir.
* A1, A2, A3 vb. isimlendirmeler anlamlı değildir.
* Benzer anlama gelen, fakat farklı işler yapan isimlendirmeler kafa karışıklığına neden olabilir.
* ProductInfo, ProductData gibi benzer anlamlı class isimleri tercih edilmelidir.
* Methodlar ve değişkenler anlamlı isimlendirmelere sahip olmalıdır.
* Sınıf isimleri, fiil olmamalıdır; örneğin, Customer, WikiPage, Account gibi.
* Methodlar fiil içermelidir.
* Erişim belirleyiciler ve getter, setter, Boolean dönen değerler için standart kurallar kullanılmalıdır.
* Farklı parametreli constructorlar yerine static builder metotları kullanılmalıdır.
* Adresle ilgili değişkenler için anlamlı prefix kullanılabilir (örneğin, addrFirstName, addrLastName).

2. FONKSİYONLAR:
* Bir methodun uzunluğu bir ekrandan fazla olmamalıdır.
* Methodlar tek bir iş yapmalıdır (Single Responsibility Principle).
* Methodlar mümkünse parametre almamalı veya en fazla 3 parametre almalıdır.
* Boolean parametrelerden kaçınılmalıdır.
* Birden çok argüman gerekiyorsa bunlar nesneler ile sarmalanmalıdır.

3. SWITCH CASE:
* Switch case yapısı genellikle toplu ve tek bir yerde duracaksa kullanılabilir.

4. YAN ETKİLER:
* Fonksiyonların yan etkileri minimized edilmelidir.
* Temiz kod yazımı, fonksiyonların birbirleriyle çakışmamasına ve sistemi bozmamasına odaklanmalıdır.

5. HATA YÖNETİMİ:
*Hata kodları yerine exceptionlar tercih edilmelidir.
*Exceptionlar açıklayıcı hata mesajları içermelidir.

6. TRY CATCH:
Try-Catch blokları ayrılmalı ve temiz bir şekilde kullanılmalıdır.

7. YORUMLAR (COMMENT LINES):
* Kötü koda yorum yazmak yerine kodu iyileştirmek tercih edilmelidir.
* Yanlış yorum, hiç yorum olmamasından daha kötüdür.
* Kod, kendini açıklamalıdır; gereksiz yorumlar yazılmamalıdır.

8. FORMATLAMA:
* Kodun biçimi, okunabilirliği artırmak için düzenlenmelidir.
* Kod yazım kurallarına uymak önemlidir.

9. GAZETE METAFORU:
* Kod, temel işlevi üstte, detaylar altta olacak şekilde düzenlenmelidir.
* İsimlendirme açık ve anlaşılır olmalıdır.

10. DİKEY UZUNLUK & UZAKLIK:
* Değişkenler ve kontrol değişkenleri kullanıldıkları yere en yakın yerde tanımlanmalıdır.
* Fonksiyonlar birbirine yakın olmalıdır.

11. NESNE VE VERİ YAPILARI:
* Değişkenler private olmalı, gerekirse getter-setter kullanılmalıdır.
* Sınıflar küçük ve anlamlı olmalıdır.
* Bağımlılıklar interface'ler aracılığıyla yapılmalıdır.

12. ERROR HANDLING:
* Hata kodları yerine exceptionlar kullanılmalıdır.
* Hata mesajları açıklayıcı olmalıdır.
* Null değer dönmek yerine özel durum nesneleri kullanılabilir.

13. UNIT TEST:
* Testler FIRST kuralına (Fast, Independent, Repeatable, Self-Validating, Timely) uygun olmalıdır.
* Birim testleri zamanında yazılmalıdır (TDD).

14. SINIFLAR:
* Sınıf içindeki sıralama belirli bir düzeni takip etmelidir.
* Sınıflar küçük ve anlamlı olmalıdır.
* Genel isimlendirmelerden kaçınılmalıdır.

15. SİSTEMLER:
* Oluşturma aşamaları ve kullanma aşamaları ayrılmalıdır.
* Dependency Inversion Principle kullanılmalıdır.

16. ACİLİYET
* Kent Beck'e göre eğer bir yazılım tasarımı basitse, aşağıdaki kurallara uymalıdır. (Önem sırasına göre.)
* Tüm testleri çalıştırın.
* Tekrarlanmış kodlar yazmayın.
* Açıklayıcı olun. (Doğru isimlendirmeler, design pattern kullanımları, iyi yazılmış testler.)
* Sınıf ve metot satır sayısını minimuma indirin.