package com.example.randomquote;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SavedQuotesAdapter extends RecyclerView.Adapter<SavedQuotesAdapter.ViewHolder> {
    private List<QuoteModel> quoteList;
    private FirestoreHelper firestoreHelper;

    public SavedQuotesAdapter(List<QuoteModel> quoteList) {
        this.quoteList = quoteList;
        this.firestoreHelper = new FirestoreHelper();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quote, parent, false);
        view.setBackgroundResource(R.drawable.card_bg);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        QuoteModel quote = quoteList.get(position);
        holder.quoteText.setText(quote.getQuote());
        holder.authorText.setText(quote.getAuthor());

        holder.deleteBtn.setOnClickListener(v -> {
            firestoreHelper.deleteQuote(quote.getId());
            quoteList.remove(position);
            notifyItemRemoved(position);
        });
    }

    @Override
    public int getItemCount() {
        return quoteList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView quoteText, authorText;
        Button deleteBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            quoteText = itemView.findViewById(R.id.quoteText);
            authorText = itemView.findViewById(R.id.authorText);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);
        }
    }
}
