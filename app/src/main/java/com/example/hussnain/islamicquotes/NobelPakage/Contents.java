package com.example.hussnain.islamicquotes.NobelPakage;

import java.io.Serializable;
import java.util.List;

public class Contents implements Serializable {
private List<Quots> quotes;

    public Contents(List <Quots> quotes) {
        this.quotes = quotes;
    }

    public List <Quots> getQuotes() {
        return quotes;
    }

    public void setQuotes(List <Quots> quotes) {
        this.quotes = quotes;
    }
}
