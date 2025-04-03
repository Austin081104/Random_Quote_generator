package com.example.randomquote;

public class Quote {
    private String id;   // Firestore document ID
    private String quote;
    private String author;

    public Quote() {} // Required for Firebase

    public Quote(String id, String quote, String author) {
        this.id = id;
        this.quote = quote;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public String getQuote() {
        return quote;
    }

    public String getAuthor() {
        return author;
    }
}
