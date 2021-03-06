package com.example.lessonone.screens;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lessonone.R;
import com.example.lessonone.utils.ViewUtilities;

class TempHistAdapter extends RecyclerView.Adapter<TempHistAdapter.TempHistViewHolder> {

    private final String[] temperaturesHistory;

    TempHistAdapter(String[] temperaturesHistory){
        this.temperaturesHistory = temperaturesHistory;
    }

    @NonNull
    @Override
    public TempHistViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        CardView cardView= (CardView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_item,viewGroup, false);
        TempHistViewHolder tempHistViewHolder = new TempHistViewHolder(cardView);
        return tempHistViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TempHistViewHolder tempHistViewHolder, int i) {
        tempHistViewHolder.textView.setText(temperaturesHistory[i]);
    }

    @Override
    public int getItemCount() {
        return temperaturesHistory.length;
    }

    class TempHistViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView textView;

        public TempHistViewHolder(@NonNull final CardView cardView) {
            super(cardView);
            this.textView=(TextView)cardView.findViewById(R.id.second_text_view_in_card_view);
            this.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ViewUtilities.makeToast(textView.getContext(), "position "+getLayoutPosition());
                }
            });
        }
    }
}
