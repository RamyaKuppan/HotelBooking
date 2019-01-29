package com.hotelbooking;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class AmenitiesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<String> amenitiesList;
    private Context context;

    AmenitiesAdapter(Context context, ArrayList<String> amenitiesList) {
        this.amenitiesList = amenitiesList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_amenities, viewGroup, false);
        return new AmenitiesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((AmenitiesViewHolder) viewHolder).amenities.setText(amenitiesList.get(i));
    }

    @Override
    public int getItemCount() {
        return amenitiesList.size();
    }
}
