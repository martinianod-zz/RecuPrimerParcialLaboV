package com.example.recuperatorio.recycleView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recuperatorio.Auto;
import com.example.recuperatorio.MyOnItemClick;
import com.example.recuperatorio.R;

import java.util.List;

public class AutoAdapter extends RecyclerView.Adapter<AutoViewHolder> {

    List<Auto> autos;
    MyOnItemClick listener;

    public AutoAdapter(List<Auto> autos, MyOnItemClick listener) {

        this.autos = autos;
        this.listener = listener;

    }

    @NonNull
    @Override
    public AutoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_auto, parent, false);
        AutoViewHolder moldeViewHolder = new AutoViewHolder(v, this.listener);

        return moldeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AutoViewHolder holder, int position) {
        Auto auto = this.autos.get(position);
        holder.tvMake.setText(auto.getMake());
        holder.tvModel.setText(auto.getModel());
        holder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return this.autos.size();
    }
}
