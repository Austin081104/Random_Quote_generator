package com.example.randomquote;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.DocumentReference;

import java.util.ArrayList;
import java.util.List;

public class FirestoreHelper {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference quotesRef = db.collection("Quotes");

    public void saveQuote(String quote, String author) {
        QuoteModel quoteModel = new QuoteModel(quote, author);
        quotesRef.add(quoteModel);
    }

    public interface FirestoreCallback {
        void onCallback(List<QuoteModel> quoteList);
    }

    public void getSavedQuotes(FirestoreCallback callback) {
        quotesRef.get().addOnCompleteListener(task -> {
            List<QuoteModel> quotes = new ArrayList<>();
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    String quote = document.getString("quote");
                    String author = document.getString("author");
                    String id = document.getId();
                    quotes.add(new QuoteModel(id, quote, author));
                }
            }
            callback.onCallback(quotes);
        });
    }

    public void deleteQuote(String docId) {
        quotesRef.document(docId).delete();
    }
}
