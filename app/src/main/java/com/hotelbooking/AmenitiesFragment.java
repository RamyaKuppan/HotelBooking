package com.hotelbooking;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class AmenitiesFragment extends Fragment {

    public static String AMENITIES_KEY = "Amenities key";

    ArrayList<String> amenitiesList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        amenitiesList = (ArrayList<String>) getArguments().getSerializable(AMENITIES_KEY);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_amenities, container, false);
        RecyclerView amenitiesView = view.findViewById(R.id.amenities_list);
        AmenitiesAdapter adapter = new AmenitiesAdapter(getContext(), amenitiesList);
        amenitiesView.setLayoutManager(new LinearLayoutManager(getContext()));
        amenitiesView.setAdapter(adapter);
        return view;
    }
}
