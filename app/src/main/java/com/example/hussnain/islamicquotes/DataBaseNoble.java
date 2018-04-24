package com.example.hussnain.islamicquotes;

public class DataBaseNoble {
    public String quotby;
    public String writerby;
public DataBaseNoble(){

}
    public DataBaseNoble(String quotby, String writerby) {
        this.quotby = quotby;
        this.writerby = writerby;
    }

    public String getQuotby() {
        return quotby;
    }

    public void setQuotby(String quotby) {
        this.quotby = quotby;
    }

    public String getWriterby() {
        return writerby;
    }

    public void setWriterby(String writerby) {
        this.writerby = writerby;
    }
}
