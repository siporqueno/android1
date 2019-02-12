package com.example.lessonone.screens;

import android.support.annotation.NonNull;
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
        TextView textView= (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.text_view_item,viewGroup, false);
        TempHistViewHolder tempHistViewHolder = new TempHistViewHolder(textView);
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

        TextView textView;

        public TempHistViewHolder(@NonNull final TextView textView) {
            super(textView);
            this.textView=textView;
            this.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ViewUtilities.makeToast(textView.getContext(), "position "+getLayoutPosition());
                }
            });
        }
    }
}
