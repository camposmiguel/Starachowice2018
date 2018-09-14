package com.miguelcr.a02_duckhunt;

import android.graphics.Point;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    Random rand;
    ImageView duck;
    TextView tvCounter, tvTimer;
    int counter = 100;
    boolean gameOver = false;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        duck = findViewById(R.id.imageViewDuck);
        tvCounter = findViewById(R.id.textViewCounter);
        tvTimer = findViewById(R.id.textViewTimer);

        tvCounter.setText(String.valueOf(counter));

        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = 0;
                tvCounter.setText("0");
                startTimer();
                gameOver = false;
                fab.hide();
            }
        });

        // Hide toolbar
        getSupportActionBar().hide();

        // Hide FAB
        fab.hide();

        // Initialize the random object
        rand = new Random();

        // start the countdown timer
        startTimer();

    }

    private void startTimer() {
        new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                tvTimer.setText(millisUntilFinished / 1000 + "s");
            }

            public void onFinish() {
                tvTimer.setText("Game over");
                fab.show();
                gameOver = true;
            }
        }.start();
    }

    public void duckClicked(View view) {
        if(gameOver) {
            Toast.makeText(this, "Game is over!", Toast.LENGTH_SHORT).show();
        } else {
            // Get screen dimensions
            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int screenWidth = size.x - duck.getWidth();
            int screenHeight = size.y - duck.getHeight();

            int randomX = rand.nextInt((screenWidth - 0) + 1) + 0;
            int randomY = rand.nextInt((screenHeight - 0) + 1) + 0;

            // Changing the ImageView duck position
            duck.setX(randomX);
            duck.setY(randomY);

            // increase the counter
            counter++;
            tvCounter.setText(String.valueOf(counter));
        }

    }
}
