package org.example;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Araba {

    int id;
    String marka;
    String model;
    int yil;
    double fiyat;

    public Araba(int id, String marka, String model, int yil, double fiyat) {

        this.id = id; // değişkenden gelen id consructerdan gelen parametreye atıyoruz
        this.marka = marka;
        this.model = model;
        this.yil = yil;
        this.fiyat = fiyat;

    }

    public int getId() { //
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka() {
        this.marka = marka;
    }

    public String getModel() {
        return model;

    }

    public void setModel() {

        this.model = model;
    }

    public void yazdir() {  // değişkenleri ekrana yazdırdık ve yazdir metodu ile de istediğimiz yerde yazdırabiliriz

        System.out.println( "[İd:]" + id + " " + "Marka:" + marka + " " + "Model:" + model + " " + "YİL:" + yil + " " + "Fiyat:" +
                fiyat); // geriye değer döndürmeyen bir methot tanımlayarak değişkenlerimi yazdırdım
    }
}