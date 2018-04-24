package com.example.hussnain.islamicquotes;

public class DataBaseAyat {
    private String randomayat;
    private String ayat;
    public DataBaseAyat(){

    }
    public DataBaseAyat(String randomayat,String ayat) {
        this.randomayat = randomayat;
        this.ayat=ayat;
    }

    public String getAyat() {
        return ayat;
    }

    public void setAyat(String ayat) {
        this.ayat = ayat;
    }

    public String getRandomayat() {
        return randomayat;
    }

    public void setRandomayat(String randomayat) {
        this.randomayat = randomayat;
    }
}
