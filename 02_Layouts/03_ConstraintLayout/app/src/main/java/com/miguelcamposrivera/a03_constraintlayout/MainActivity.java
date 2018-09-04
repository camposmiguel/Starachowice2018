package com.miguelcamposrivera.a03_constraintlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    TextView price, location;
    ImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the view component references
        price = findViewById(R.id.textViewPrice);
        location = findViewById(R.id.textViewLocation);
        photo = findViewById(R.id.imageViewPhoto);

        // change the price
        price.setText("€ 350");
        location.setText("Seville");

        // Load the image into the imageViewPhoto
        Picasso.get()
                .load("https://www.hotelartsbarcelona.com/app/uploads/2017/06/infinity-pool-hotel-arts-barcelona-1800x840.jpg")
                .into(photo);
    }
}
