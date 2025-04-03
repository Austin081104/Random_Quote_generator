package com.example.randomquote;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView quoteText, authorText;
    private ImageButton fetchBtn, saveBtn, shareBtn, copyBtn;
    private Button viewSavedBtn;
    private FirestoreHelper firestoreHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteText = findViewById(R.id.quoteText);
        authorText = findViewById(R.id.authorText);
        fetchBtn = findViewById(R.id.fetchBtn);
        saveBtn = findViewById(R.id.saveBtn);
        shareBtn = findViewById(R.id.shareBtn);
        copyBtn = findViewById(R.id.copyBtn);
        viewSavedBtn = findViewById(R.id.viewSavedBtn);

        CardView cardView = findViewById(R.id.cardView);
        cardView.setCardBackgroundColor(Color.parseColor("#ffd60a")); // White Background

        firestoreHelper = new FirestoreHelper();

        fetchBtn.setOnClickListener(v -> fetchRandomQuote());
        saveBtn.setOnClickListener(v -> saveQuote());
        shareBtn.setOnClickListener(v -> shareQuote());
        copyBtn.setOnClickListener(v -> copyToClipboard());
        viewSavedBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SavedQuotesActivity.class);
            startActivity(intent);
        });


    }

    private void fetchRandomQuote() {
        QuoteService service = RetrofitClient.getService();
        service.getRandomQuote().enqueue(new Callback<Quote>() {
            @Override
            public void onResponse(Call<Quote> call, Response<Quote> response) {
                if (response.isSuccessful()) {
                    Quote quote = response.body();
                    quoteText.setText(quote.getQuote());
                    authorText.setText("- " + quote.getAuthor());

                    // Animation effect
                    quoteText.setAlpha(0f);
                    authorText.setAlpha(0f);
                    quoteText.animate().alpha(1f).setDuration(500);
                    authorText.animate().alpha(1f).setDuration(500);
                }
            }

            @Override
            public void onFailure(Call<Quote> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to fetch", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void saveQuote() {
        firestoreHelper.saveQuote(quoteText.getText().toString(), authorText.getText().toString());
        Toast.makeText(this, "Quote Saved!", Toast.LENGTH_SHORT).show();
    }

    private void shareQuote() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, quoteText.getText().toString() + "\n" + authorText.getText().toString());
        startActivity(Intent.createChooser(intent, "Share via"));
    }

    private void copyToClipboard() {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Quote", quoteText.getText().toString());
        clipboard.setPrimaryClip(clip);
        Toast.makeText(this, "Copied!", Toast.LENGTH_SHORT).show();
    }
}
