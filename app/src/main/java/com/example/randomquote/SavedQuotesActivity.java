package com.example.randomquote;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SavedQuotesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SavedQuotesAdapter adapter;
    private FirestoreHelper firestoreHelper;
    private List<QuoteModel> quoteList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_quotes);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        firestoreHelper = new FirestoreHelper();

        firestoreHelper.getSavedQuotes(quotes -> {
            quoteList.addAll(quotes);
            adapter = new SavedQuotesAdapter(quoteList);
            recyclerView.setAdapter(adapter);
        });
    }
}
