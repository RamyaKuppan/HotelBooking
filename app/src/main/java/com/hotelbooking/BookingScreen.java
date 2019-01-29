package com.hotelbooking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BookingScreen extends AppCompatActivity {

    public static String ADDRESS = "Address";
    public static String HOTEL_NAME = "Hotel Name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_screen);
        String name = getIntent().getStringExtra(HOTEL_NAME);
        String address = getIntent().getStringExtra(ADDRESS);

        TextView hotelName= findViewById(R.id.hotel_name);
        TextView addressView = findViewById(R.id.address);
        hotelName.setText(name);
        addressView.setText(address);

    }
}
