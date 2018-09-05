package com.miguelcamposrivera.a04_constraintlayoutprofile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    ImageView playerPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the imageView (photo) reference
        playerPhoto = findViewById(R.id.imageViewPhoto);

        // Load into the ImageView the football player photo
        Picasso.get()
                .load("http://realmadrid.am/img/players/09_Benzema_380x501Thumb.jpg")
                .into(playerPhoto);

        // Remember to include in the AndroidManifest the INTERNET permission
    }
}
