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
    boolean gameOver = false;

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
        if(gameOver) {
            Toast.makeText(this, "GAME IS OVER", Toast.LENGTH_SHORT).show();
        } else {
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
                // 1. We're selecting the cell clicked
                if (isPlayingPlayer1) {
                    ivToChange.setImageResource(R.drawable.ic_player_one);
                    selectedCells[positionClicked] = 1;
                } else {
                    ivToChange.setImageResource(R.drawable.ic_player_two);
                    selectedCells[positionClicked] = 2;
                }

                // 2. Check if exist a solution
                checkWinner();


            } else {
                Toast.makeText(this, "Try with other cell", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void checkWinner() {
        /*

            This is our matrix game

            0 | 1 | 2
            ----------
            3 | 4 | 5
            ----------
            6 | 7 | 8

            We have 8 different solutions:

            1. 0,1,2
            2. 3,4,5
            3. 6,7,8
            4. 0,3,6
            5. 1,4,7
            6. 2,5,8
            7. 0,4,8
            8. 2,4,6

         */

        boolean existSolution = false;

        if(selectedCells[0] == selectedCells[1]
                && selectedCells[0] == selectedCells[2]
                && selectedCells[0] != 0) {
            // 1. 0,1,2
            existSolution = true;

        } else if(selectedCells[3] == selectedCells[4]
                && selectedCells[3] == selectedCells[5]
                && selectedCells[3] != 0) {
            //2. 3,4,5
            existSolution = true;
        } else if(selectedCells[6] == selectedCells[7]
                && selectedCells[6] == selectedCells[8]
                && selectedCells[6] != 0) {
            //3. 6,7,8
            existSolution = true;
        } else if(selectedCells[0] == selectedCells[3]
                && selectedCells[0] == selectedCells[6]
                && selectedCells[0] != 0) {
            //4. 0,3,6
            existSolution = true;
        } else if(selectedCells[1] == selectedCells[4]
                && selectedCells[1] == selectedCells[7]
                && selectedCells[1] != 0) {
            //3. 1,4,7
            existSolution = true;
        } else if(selectedCells[2] == selectedCells[5]
                && selectedCells[2] == selectedCells[8]
                && selectedCells[2] != 0) {
            //4. 2,5,8
            existSolution = true;
        }   else if(selectedCells[2] == selectedCells[5]
                && selectedCells[2] == selectedCells[8]
                && selectedCells[2] != 0) {
            //5. 1,4,7
            existSolution = true;
        } else if(selectedCells[2] == selectedCells[5]
                && selectedCells[2] == selectedCells[8]
                && selectedCells[2] != 0) {
            //6. 2,5,8
            existSolution = true;
        }  else if(selectedCells[2] == selectedCells[5]
                && selectedCells[2] == selectedCells[8]
                && selectedCells[2] != 0) {
            // 7. 0,4,8
            existSolution = true;
        }   else if(selectedCells[2] == selectedCells[5]
                && selectedCells[2] == selectedCells[8]
                && selectedCells[2] != 0) {
            // 8. 2,4,6
            existSolution = true;
        }

        String winnerMessage = "";
        if(isPlayingPlayer1) {
            winnerMessage = "Player 1 is the Winner!";
            isPlayingPlayer1 = false;
        } else {
            winnerMessage = "Player 2 is the Winner!";
            isPlayingPlayer1 = true;
        }

        if(existSolution) {
            Toast.makeText(this, winnerMessage, Toast.LENGTH_SHORT).show();
        }


    }
}
