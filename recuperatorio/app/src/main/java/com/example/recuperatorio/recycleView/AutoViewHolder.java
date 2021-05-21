package com.example.recuperatorio.recycleView;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recuperatorio.MyOnItemClick;
import com.example.recuperatorio.R;

public class AutoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView tvMake;
    TextView tvModel;

    private MyOnItemClick listener;
    private int position;


    public AutoViewHolder(@NonNull View itemView, MyOnItemClick listener) {
        super(itemView);
        this.tvMake = itemView.findViewById(R.id.tvMarca);
        this.tvModel = itemView.findViewById(R.id.tvModelo);
        this.listener = listener;

        itemView.setOnClickListener(this);


    }

    public void setPosition(int position){
        this.position = position;
    }

    @Override
    public void onClick(View view) {
        this.listener.onItemClick(this.position);
    }
}
