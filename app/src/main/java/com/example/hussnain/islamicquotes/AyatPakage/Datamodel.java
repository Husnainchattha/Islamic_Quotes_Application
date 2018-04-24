package com.example.hussnain.islamicquotes.AyatPakage;

import java.io.Serializable;

public class Datamodel implements Serializable {
       private int number;
       private String text;
       private int numberInSurah;
       private int manzil;
       private int page;
       private int ruku;
       private SurahAdress surah;

       public int getNumber() {
              return number;
       }

       public void setNumber(int number) {
              this.number = number;
       }

       public String getText() {
              return text;
       }

       public void setText(String text) {
              this.text = text;
       }

       public int getNumberInSurah() {
              return numberInSurah;
       }

       public void setNumberInSurah(int numberInSurah) {
              this.numberInSurah = numberInSurah;
       }

       public int getManzil() {
              return manzil;
       }

       public void setManzil(int manzil) {
              this.manzil = manzil;
       }

       public int getPage() {
              return page;
       }

       public void setPage(int page) {
              this.page = page;
       }

       public int getRuku() {
              return ruku;
       }

       public void setRuku(int ruku) {
              this.ruku = ruku;
       }

       public SurahAdress getSurah() {
              return surah;
       }

       public void setSurah(SurahAdress surah) {
              this.surah = surah;
       }

    public static class SurahAdress implements Serializable {
        private int number;
        private String name;

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
