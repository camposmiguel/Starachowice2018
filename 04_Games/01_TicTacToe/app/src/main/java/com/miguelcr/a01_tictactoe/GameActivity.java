package com.miguelcr.a01_tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    ImageView iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9;
    boolean isPlayingPlayer1 = true;
    int[] selectedCells = {0,0,0,0,0,0,0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        iv1 = findViewById(R.id.imageView1);
        iv2 = findViewById(R.id.imageView2);
        iv3 = findViewById(R.id.imageView3);
        iv4 = findViewById(R.id.imageView4);
        iv5 = findViewById(R.id.imageView5);
        iv6 = findViewById(R.id.imageView6);
        iv7 = findViewById(R.id.imageView7);
        iv8 = findViewById(R.id.imageView8);
        iv9 = findViewById(R.id.imageView9);

    }

    public void cellClicked(View view) {
        int id = view.getId();
        ImageView ivToChange = null;
        int positionClicked = 0;

        if(id == R.id.imageView1) {
            ivToChange = iv1;
            positionClicked = 0;
        } else if(id == R.id.imageView2) {
            ivToChange = iv2;
            positionClicked = 1;
        } else if(id == R.id.imageView3) {
            ivToChange = iv3;
            positionClicked = 2;
        } else if(id == R.id.imageView4) {
            ivToChange = iv4;
            positionClicked = 3;
        } else if(id == R.id.imageView5) {
            ivToChange = iv5;
            positionClicked = 4;
        } else if(id == R.id.imageView6) {
            ivToChange = iv6;
            positionClicked = 5;
        } else if(id == R.id.imageView7) {
            ivToChange = iv7;
            positionClicked = 6;
        } else if(id == R.id.imageView8) {
            ivToChange = iv8;
            positionClicked = 7;
        } else if(id == R.id.imageView9) {
            ivToChange = iv9;
            positionClicked = 8;
        }

        // If the cell is empty (is equal 0)
        if(selectedCells[positionClicked] == 0 ) {
            if (isPlayingPlayer1) {
                ivToChange.setImageResource(R.drawable.ic_player_one);
                isPlayingPlayer1 = false;
                selectedCells[positionClicked] = 1;
            } else {
                ivToChange.setImageResource(R.drawable.ic_player_two);
                isPlayingPlayer1 = true;
                selectedCells[positionClicked] = 2;
            }
        } else {
            Toast.makeText(this, "Try with other cell", Toast.LENGTH_SHORT).show();
        }

    }
}
