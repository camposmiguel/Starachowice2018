package com.miguelcr.a01_circleimageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    ImageView profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profile = findViewById(R.id.profile_image);

        Picasso.get()
                .load("http://s04.s3c.es/imag/_v0/770x420/e/6/9/cristiano-celebra-gol-reuters.jpg")
                .into(profile);
    }
}
