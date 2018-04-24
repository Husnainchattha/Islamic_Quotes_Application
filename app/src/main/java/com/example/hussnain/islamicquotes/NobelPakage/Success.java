package com.example.hussnain.islamicquotes.NobelPakage;

import java.io.Serializable;

public class Success implements Serializable {
    private int total;

    public Success(int total) {
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
