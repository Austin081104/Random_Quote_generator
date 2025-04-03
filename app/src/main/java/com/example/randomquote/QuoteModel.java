package com.example.randomquote;

public class QuoteModel {
    private String id;
    private String quote;
    private String author;

    // Empty constructor for Firestore
    public QuoteModel() { }

    // Constructor for saving new quotes (without ID)
    public QuoteModel(String quote, String author) {
        this.quote = quote;
        this.author = author;
    }

    // Constructor for retrieving quotes (with ID)
    public QuoteModel(String id, String quote, String author) {
        this.id = id;
        this.quote = quote;
        this.author = author;
    }

    public String getId() { return id; }
    public String getQuote() { return quote; }
    public String getAuthor() { return author; }
}
