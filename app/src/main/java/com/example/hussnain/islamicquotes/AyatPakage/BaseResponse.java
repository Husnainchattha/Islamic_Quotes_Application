package com.example.hussnain.islamicquotes.AyatPakage;


import java.io.Serializable;

public class BaseResponse implements Serializable {
    private int code;
    private String status;
    private Datamodel data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Datamodel getData() {
        return data;
    }

    public void setData(Datamodel data) {
        this.data = data;
    }
}
