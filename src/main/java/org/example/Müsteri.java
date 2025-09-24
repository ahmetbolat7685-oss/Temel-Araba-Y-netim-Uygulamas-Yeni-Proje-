package org.example;

public class Müsteri {

    int id;
    String ad;
    String soyad;

    public Müsteri(int id, String ad, String soyad) {

        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = id;

    }

    public String getAd() {
        return ad;
    }

    public void setAd() {
        this.ad = ad;

    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad() {
        this.soyad = soyad;
    }
}
