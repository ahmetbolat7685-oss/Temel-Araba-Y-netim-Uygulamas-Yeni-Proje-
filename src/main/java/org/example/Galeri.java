package org.example;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Scanner;

public class Galeri {
    public static void main(String[] args)  throws  Exception {

        ArrayList<Araba> mevcutArabalar = new ArrayList<>(); // Araba classında mevcutArabalar değişkeni tutan bir ArrayList dizisidir

        //Projede her çekeceğim veriye dizi tanımladım içine veri ekledim
        ArrayList<String> arabaLink = new ArrayList<>();
        ArrayList<String> arabaMarka = new ArrayList<>();
        ArrayList<String> arabaModel = new ArrayList<>();
        ArrayList<String> arabaYil = new ArrayList<>();
        ArrayList<String> arabaKilometre = new ArrayList<>();
        ArrayList<String> arabaSeri = new ArrayList<>();
        ArrayList<String> arabaVitesTipi = new ArrayList<>();
        ArrayList<String> arabaYakıtTipi = new ArrayList<>();
        ArrayList<String> arabaKasaTipi = new ArrayList<>();
        ArrayList<String> arabaResimleri = new ArrayList<>();


        mevcutArabalar.add(new Araba(1, "Toyota", "Corolla", 2020, 20000)); // add = eklemek anlamına gelir
        mevcutArabalar.add(new Araba(2, "Skoda", "Wolswogen", 2010, 30000));
        mevcutArabalar.add(new Araba(3, "Renault", "Clio", 2025, 40000));
        mevcutArabalar.add(new Araba(4, "Wolswogen", "Jetta", 2023, 50000));
        mevcutArabalar.add(new Araba(5, "Renault", "Toros", 2024, 60000));


        ArrayList<String> satisKayitlari = new ArrayList<>(); // String tipinde tutan ve değerleri satisKayitlarına atanan bir String ArrayList dizisi

        Scanner scanner = new Scanner(System.in);
        while (true) { // sonsuz döngü başlatıldı

            boolean sonuc = false; // ilk önce sonuc başlatılmadığı false yapıyoruz

            System.out.println("===Galeri Yönetim Sistemi===");

            System.out.println("1-Tüm Arabaları Listele");

            System.out.println("2-Fiyata Göre Filtrele");

            System.out.println("3-Markaya Göre Ara");

            System.out.println("4-Yeni Bir Arabaya Ekleme");

            System.out.println("5-Fiyata Göre Filtreleme Ve Markaya Göre Arama");

            System.out.println("6-Arabayı Satın Al");

            System.out.println("7-Satışları GÖrüntüle");

            System.out.println("8-Çıkış");

            System.out.print("Seçiminizi Giriniz:");
            int secim = scanner.nextInt(); // seçimi giriyoruz

            scanner.nextLine();// Enter hatası
            if (secim == 1) {
                // arabaLinkleri adlı bir arrayList oluşturdum

                for (int i = 0; i <= 20; i++) { // başlangıçta ilk 0 dan 20 kadar olan bir for döngüsü oluşturdum

                    String url = "https://www.arabam.com/ikinci-el";// String tipinde linkim 20 kere dönüyor
                    if (i > 1) {// for da ki 0 1 den büyükse url ?page girip sayfa atlıyor
                        url += "?page=" + i; // hangi sayfa numarası olduğunu belirtir ?page
                    }
                    Document doc = Jsoup.connect(url).get();// kullandığımız url Jsoup.connet ile get  html sayfasında ki linke gidildi documente doca atıldı

                    Elements elements = doc.body().select("a[href].link-overlay");// Elements ile  linkte genel bir elentsleri alıyoruz ve linkin selectorünü alıyoruz

                    for (Element element : elements) {// Element ile linkin selector yapısında dönülüyor ve
                        String link = element.absUrl("href");// elements linkinde dönüldü ve linkin uzunluğunu hepsini alıd absUrl ile
                        if (!arabaLink.contains(link)) { // eğer arabalink de link olarak yazılan href" linki var mı yoksa
                            arabaLink.add(link); // linki arabaLink arrayList ekle
                        }
                    }
                }
                for (int i = 0; i < arabaLink.size(); i++) { // arabalink arrayListeden dön yani Linklerde dön
                    System.out.println(arabaLink.get(i));// Linkin i. ci linkini ekrana yazdır
                }
                // arabalinkin uzunluğunu al yani linklerin sizenı al

                for (String ilanMarka : arabaLink) {// arabalinklerin dizisinde dönüldü ve ilanMarkaya atandı

                    Document doc = Jsoup.connect(ilanMarka).get();// Documente doc ile de ilanMarkasında olan linklerine get ile erişildi ve doca atandı

                    Elements elements = doc.select("div.property-item");// Elenments hepsinin üzerinde dönülüyor ve slect ile div propertyin yani sayfanın hepsini alıyoruz

                    for (Element element : elements) {// Element ile sadece elements üzerinde dönülüyor
                        Element element1 = element.selectFirst("div.property-key");
                        Element element2 = element.selectFirst("div.property-value");


                        if (element1 != null && element1.text().equals("Marka")) {// element1 yani div.property-key  element 1 boş değilse şart doğruysa element1t.text yani yazılı ismi "Markaya eşitse " arbaModel
                            arabaMarka.add(element2.text()); //arabaMarkaya arabanın ismini ekle
                            System.out.println("Marka: " + element2.text() + " " + " Link: " + ilanMarka);// element2 yani araba ismi ve ilanMarkayı Yazdır
                        }

                        if (element1 != null && element1.text().equals("Model")) {
                            arabaModel.add(element2.text());
                            System.out.println("Model: " + element2.text() + " " + " Link: " + ilanMarka);
                        }

                        if (element1 != null && element1.text().equals("Yıl")) {
                            arabaYil.add(element2.text());
                            System.out.println("Yıl :" + element2.text() + " " + "Link:" + ilanMarka);
                        }

                        if (element1 != null && element1.text().equals("Kilometre")) {
                            arabaKilometre.add(element2.text());
                            System.out.println("Kilometre" + element2.text() + " " + "Link:" + ilanMarka);
                        }

                        if (element1 != null && element1.text().equals("Seri")) {
                            arabaSeri.add(element2.text());
                            System.out.println("Seri:" + element2.text() + " " + "Link:" + ilanMarka);
                        }

                        if (element1 != null && element1.text().equals("Vites Tipi")) {
                            arabaVitesTipi.add(element2.text());
                            System.out.println("Vites Tipi:" + element2.text() + " " + "Link:" + ilanMarka);
                        }

                        if (element1 != null && element1.text().equals("Yakıt Tipi")) {
                            arabaYakıtTipi.add(element2.text());
                            System.out.println("Yakıt Tipi:" + element2.text() + " " + "Link:" + ilanMarka);
                        }

                        if (element1 != null && element1.text().equals("Kasa Tipi")) {
                            arabaKasaTipi.add(element2.text());// element1.text in valuesi yani ismi
                            System.out.println("Kasa Tipi:" + element2.text() + " " + "Link:" + ilanMarka);
                        }
                        Elements img = doc.getElementsByTag("img");
                        for (Element el : img) {
                            String src = el.hasAttr("data-src") ? el.absUrl("data-src") : el.absUrl("src");
                           String alt = el.attr("alt");

                            System.out.println("Resim: " + src+ilanMarka);
                           //System.out.println("Alt: " + alt);

                            arabaResimleri.add(src);
                        }

                    }
                }
                System.out.println("Araba Linkleri"+arabaLink.size());
                System.out.println("Araba Markaları"+arabaMarka.size());
                System.out.println("Araba Modelleri"+arabaModel.size());
                System.out.println("Araba Yıl :"+arabaYil.size());
                System.out.println("Araba Kilometre:"+arabaKilometre.size());
                System.out.println("Araba Seri:"+arabaSeri.size());
                System.out.println("Vites Tipi:"+arabaVitesTipi.size());
                System.out.println("Yakıt Tipi:"+ arabaYakıtTipi.size());
                System.out.println("Araba Resimleri"+arabaResimleri);
            }
            else if (secim==2){
            }

            else if (secim == 3) { // Fiyata göre Arabalar Filtrelendi

                System.out.print("Fiyat Giriniz:");
                double fiyat = scanner.nextDouble();

                for (Araba h : mevcutArabalar) {
                    if (h.fiyat <= fiyat) {
                        sonuc = true;
                        h.yazdir();
                    }
                }
                if (!sonuc) {
                    System.out.println("Bu Fiyata Uygun Araç Bulunamadı");
                }

            } else if (secim == 3) {// Markaya Göre Aranıyor

                System.out.print("Markaya Göre Ara:");
                String marka = scanner.nextLine();

                for (Araba d : mevcutArabalar) {// araba classın içinde arabalar dizisine döndük ve d değişkenine atadık
                    if (d.marka.equalsIgnoreCase(marka)) { // burada (d dizisinde ki marka ile girilen marka eşit mi diyede kontrol ediliyor)  equalsIgnoreCase :  İki Diziyi karşılaştırırken büyük küçük harf ayrımına takılmaz , ama equals kullanıldığında eşitlenen kelime bire bir aynı olmak zorunadadır
                        d.yazdir(); // d üzerinde yazdir metodum çalışıyor
                        sonuc = true;// marka
                    }
                }
                if (!sonuc) { // marka ismi yanlış girildiyse de bulundu eşit değildir
                    System.out.println("Lütfen  Aracın Marka Bilgisini Doğru Giriniz");
                }
            } else if (secim == 4) {

                System.out.println("Eklemek İstediğiniz Arabanın Bilgilerini Giriniz");

                System.out.print("İd giriniz:");
                int id = scanner.nextInt();

                scanner.nextLine();

                System.out.print("Marka Giriniz:");
                String marka = scanner.nextLine();

                System.out.print("Marka Giriniz:");
                String model = scanner.nextLine();

                System.out.print("Yıl giriniz:");
                int yil = scanner.nextInt();

                System.out.print("Fiyatı Giriniz:");
                double fiyat = scanner.nextDouble();

                Araba araba1 = new Araba(id, marka, model, yil, fiyat);

                System.out.println("Araba Başarılı Bİr Şekilde Eklenmiştir");
                System.out.println(id + " " + marka + " " + model + " " + yil + " " + fiyat);
            } else if (secim == 5) {

                System.out.print("Fiyat Giriniz:");
                double fiyat = scanner.nextDouble();

                scanner.nextLine();

                System.out.print("Marka Bilgisini Giriniz:");
                String marka = scanner.nextLine();

                for (Araba x : mevcutArabalar) {
                    if (x.fiyat <= fiyat && x.marka.equals(marka)) {
                        sonuc = true;
                        x.yazdir();
                    }
                }
                if (!sonuc) {
                    System.out.println("Lütfen Aracın Fiyatını ve Marka Bilgilerini Doğru Giriniz!!  ");
                }
            } else if (secim == 6)// Arabayı Satın Al
            {
                System.out.print("Satın almak istediğiniz araba ID:");
                int id = scanner.nextInt();

                scanner.nextLine();

                System.out.print("Müşteri Adı:");
                String musteriAdi = scanner.nextLine();

                System.out.print("Müşteri Soyadı:");
                String musteriSoyadi = scanner.nextLine();

                Müsteri musteri = new Müsteri(id, musteriAdi, musteriSoyadi); // müsteri sınıfından nesne türetildi getter setter kullanılmak için

                for (int i = 0; i < mevcutArabalar.size(); i++) {

                    Araba k = mevcutArabalar.get(i); // get(i) mevcutarablar dizisinde for döngüsü döner get(i) ile i. ci elemanını döndürür ve k ye atar
                    if (k.getId() == id) { // eğer getId ile == kullanıcının girdiği id eşitse

                        mevcutArabalar.remove(i); // remove(kaldır) demek mevcutarabalar dizisinde (i) indexsde ki diziyi kaldırdım

                        String kayit = musteri.getAd() + " " + musteri.getSoyad() + " " + k.marka + " " + k.model + " " + k.yil + "  " + k.fiyat + "TL";

                        satisKayitlari.add(kayit); // kayit değişkene atanan id marka model yil fiyat bilgileri satiskayitlari.addd ekleniyor ArrayListine yani

                        System.out.println("Satış Gerçekleşti!");

                        System.out.println(musteriAdi + " " + musteriSoyadi + " " + k.marka + " " + k.model + " " + k.yil + " " + k.fiyat);
                        sonuc = true;
                    }
                }
                if (!sonuc) {
                    System.out.println("Satış Gerçekleşmedi"); // MevcutArabalar listesindeki id ler birden fazla satışı yapılacağı zaman Satış Gerçekleşmeyecek sonuca eşit değil çnkü
                }

            } else if (secim == 7) { //  satiskayitlari string olduğu için string tipinde diziyi saklıyor
                System.out.println("----SATIŞLAR----");
                for (String s : satisKayitlari) {
                    System.out.println(s);
                }
            } else if (secim == 8) {
                System.out.println("Sistemden Çıkış Yapıldı");
                sonuc = false;
                break;
            }
        }// while bitiş

    }
}
