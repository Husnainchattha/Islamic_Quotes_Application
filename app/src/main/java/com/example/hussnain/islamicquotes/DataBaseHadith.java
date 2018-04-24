package com.example.hussnain.islamicquotes;

public class DataBaseHadith {
    private String hadith;
    private String author;
public DataBaseHadith(){

}
    public DataBaseHadith(String hadith, String author) {
        this.hadith = hadith;
        this.author = author;
    }

    public String getHadith() {
        return hadith;
    }

    public void setHadith(String hadith) {
        this.hadith = hadith;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
