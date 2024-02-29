# HIBERNATE
* Hibernate bir ORM aracıdır. Nesne ile veritabanı arasındaki ilişkiyi sağlayarak veritabanı ilişkilerini kolaylaştırır. 
* Database bağımsız çalışır.

## POJO
* Entityler aslında POJO'dur. 
* Java class'larının en basit halidir.
* POJO başka bir sınıftan extend ya da implement olmamış, constructor oluşturulmamış en basit halidir.
* Private değişkenleri vardır.
* Getter ve Setter'lar ile dışarı açılır. (Encapsulation)
* Primary key(id) değişkeni olmalı.
* POJO'yu entity'ye dönüştürmek için bazı ayarlar yapılmalı.

## Anotasyonlar
* Entity
* Table
* Id
* GeneretadValue
* SequenceGenerator
* TableGenerator
* Column
* Version
* Temporal
* Transient
* Lob 

### @Entity
* En temel anatosyondur. POJO'nun veritabanında bir tabloya denk geldiğini belirtir.

### @Table
* Entity anotasyonu ile kullanılır.
* POJO'nun hangi tabloya karşılık geldiğini @Entity anotasyonu ile belirttikten sonra o tablonun özelliklerini 
belirtmek için @Table kullanılır.
* 5 farklı özellik bulunur.
  - name, catalog, schema, uniqeConsraints, indexes.
* name: tablo adı değiştirilir. Kullanılmazsa class adı ile aynı olur.

### @Id
* Mutlaka olmalıdır. Her entity'de olmalı
* Primary key'i belirtir.

### @GeneratedValue
* Primary key değerinin nasıl artacağını belirttiğimiz anotasyondur.
* Strategy ve generator olarak 2 özellik sunar.
* 4 farklı strategy tipi vardır
- AUTO -> default'tur. Arttırma görevi hibernate'e bırakılır
- IDENTITY -> Kullanımı en kolay ancak performans olarak en iyi değil. Her bir insert işlemi için yeni bir değer 
oluşturur.
- SEQUENCE -> En performans. Değer arttırımı bir sequence üzerinden arttırılır. Eğer belirtilmezse hibernate varsayılan 
sequence üzerinden arttırım yapar. Özelleştirmek için @SequenceGenerator kullanılır.
- TABLE -> Günümüzde pek kullanımı yoktur. Sıradaki değeri belirtilen tablodan depolar. Günceller lazım olduğunda yeni 
değeri alır. Bu da uygulamayı yavaşlatır. Özelleştirmek istenirse @TableGenerator kullanılabilir.

### @SequenceGenerator
* Kullanılacak sequence'lerin özelliklerini özelleştirmek için kullanılır. 6 farkı özellik sunar
- name : Generator adı
- sequenceName : sequence adı
- allocationSize : arttırım sayısını belirtir. Default olarak 50'dir.
- initialValue : başlangıç sayısını belirtir. Default 1'dir.
- catalog
- schema

### @TableGenerator
* 11 farklı özellik sunar.

### @Column
* İlgili değişkenin database'deki karşılığı olacak olan column ile alakalı ayarları yapabileceğimiz anotasyondur.

### @Version
* İlgili tablonun versiyonunu tutar.
* Farklı transactionlarda aynı veri üzerinde aynı anda değişiklik yapılmasını önler. (Optimistik Locking)

### @Temporal
* Tarihin database'e hangi formatta yazılacağını belirtir.
* 3 değeri vardır
- DATE : dd.mm.yyyy
- TIME : hh:mm:ss
- DATETIME : dd::mm:yyyy hh:mm:ss

### @Transient
* POJO içinde olmasını istediğimiz ama database'de bir karşılığının olmasını istemediğimiz durumlarda kullanılır.
* Sadece nesnenin yaşam döngüsü süresince ömrü vardır.

### @Lob
* İlgili kolonun Large Object olduğu belirtilir.

### @OneToOne
* Entity içinde entity kullanılıyor ve aralarında birebir ilişki varsa kullanılır.
* 6 farklı özellik sunar;
- fetch : Join yapılan kolonun tamamının getirilip getirilmemesini belirtir. Default EAGER. Sürekli birlikte 
kullanılacak tablolar yapılmadığı sürece EAGER olmamalı!
- cascade : 6 farklı  cascade tipi vardır ; 
1. ALL : tüm işleri yapar
2. MERGE
3. PERSIST
4. REFRESH
5. REMOVE
6. DETACH
- mappedBy : Çift yönlü ilişkilerde kullanılır. (Sadece bir tarafta var)
- optional : Aradaki ilişki zorunlu mu değil mi belirlenir. Default true.
- orphanRemoval :
- targetEntity : İlgili join'e ilişkin referans sınıfının belirtilmesine yarar. Normalde gerekmez. Çünkü referans sınıfı 
zaten alanın tipinden, get mothodundan ya da collection'ların generic tipinden alınabilir. Ancak bazı durumlarda 
bunların hiçbirine ulaşılamaz. Örn: public List kisiListesi. Generic tipi dahi belirlenmemiş. Böyle bir durumda 
@targetEntity ile kisi.class denir. 

### @ManyToMany
* Entity içinde entity + aralarında çoktan çoka ilişki varsa kullanılır.
* Örneğin kitap - yazar ilişkisi. -> Bir kitabın birden fazla yazarı olabilir ve bir yazar birden fazla kitap yazmış 
olabilir.
* 4 farklı özellik sunar.
- fetch
- cascade
- mappedBy -> kullanıldığı entity'deki alan için databasede alan oluşmaz. Entity üzerinde bu alan tutulur.
- targetEntity

### @ManyToOne
* Entity içinde entity kullanılıyor ve aralarında çoka bir ilişkisi varsa kullanılır. En sık kullanılandır.
* Şehir ve ülke ilişkisi.
* 4 farklı özellik sunar
- fetch
- cascade
- optional
- targetEntity

### @OneToMany
* Entity içinde entity kullanılıyor ve aralarında bire çok ilişkisi varsa kullanılır.
* 5 farklı özellik sunar
- fetch
- cascade
- mappedBy
- orphanRemoval
- targetEntity
