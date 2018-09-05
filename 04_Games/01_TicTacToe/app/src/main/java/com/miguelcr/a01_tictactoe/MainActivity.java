package com.miguelcr.a01_tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startGame(View v) {
        // The lines of code to execute when
        // user click on Start game button...
        Toast.makeText(this, "Start game clicked", Toast.LENGTH_SHORT).show();
    }
}
