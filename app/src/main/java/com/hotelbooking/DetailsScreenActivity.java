package com.hotelbooking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

import static com.hotelbooking.AmenitiesFragment.AMENITIES_KEY;

public class DetailsScreenActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_screen);

        Button book = findViewById(R.id.book);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bookingIntent = new Intent(DetailsScreenActivity.this, BookingScreenActivity.class);
                bookingIntent.putExtra(BookingScreenActivity.HOTEL_NAME, "The Metroplace Hotels");
                bookingIntent.putExtra(BookingScreenActivity.ADDRESS, "Phase III, Zenith Building, Ascendas IT Park, CSIR Road, Taramani, Chennai, Tamil Nadu 600113");
                startActivity(bookingIntent);
            }
        });

        ImageView share = findViewById(R.id.share);
        share.setOnClickListener(this);
        setAmenitiesAdapter();
    }

    private void setAmenitiesAdapter() {
        ArrayList<String> list = new ArrayList<>();
        list.add("600 guestrooms");
        list.add("Near the beach");
        list.add("11 restaurants and 4 bars/lounges");
        list.add("Full-service spa");
        list.add("5 outdoors pool");
        list.add("WiFi in the loby");
        AmenitiesFragment amenitiesFragment = new AmenitiesFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(AMENITIES_KEY, list);
        amenitiesFragment.setArguments(bundle);
        addFragment(amenitiesFragment);
    }

    /**
     * Used to add the fragment that passed in method argument
     *
     * @param fragment Fragment to add in activity
     */
    private void addFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.amenities_fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.share:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String hotelName = "The Metroplace Hotels";
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, hotelName);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
                break;
        }
    }
}
