package com.hotelbooking;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class AmenitiesViewHolder extends RecyclerView.ViewHolder {

    public TextView amenities;

    AmenitiesViewHolder(@NonNull View itemView) {
        super(itemView);
        amenities = itemView.findViewById(R.id.item);
    }
}
