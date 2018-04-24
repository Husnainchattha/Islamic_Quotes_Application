package com.example.hussnain.islamicquotes.NobelPakage;

import java.io.Serializable;

public class Quots implements Serializable {
private String quote;
private String author;

    public Quots(String quote, String author) {
        this.quote = quote;
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
