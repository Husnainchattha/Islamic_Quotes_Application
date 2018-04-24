package com.example.hussnain.islamicquotes.NobelPakage;

public class NobelQuot {
private Success success;
private Contents contents;

    public NobelQuot(Success success, Contents contents) {
        this.success = success;
        this.contents = contents;
    }

    public Success getSuccess() {
        return success;
    }

    public void setSuccess(Success success) {
        this.success = success;
    }

    public Contents getContents() {
        return contents;
    }

    public void setContents(Contents contents) {
        this.contents = contents;
    }
}
