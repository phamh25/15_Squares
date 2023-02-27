package com.example.a15_squares;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Program create initialization
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        // View and controller
        SquaresView squaresView = findViewById(R.id.squares);
        SquaresController squaresController = new SquaresController(squaresView);
        SquaresModel squaresModel = squaresView.getModel();

        // Start game on create
        squaresView.startGame();

        // Instances
        int[][] squaresArray = squaresView.squaresArray; // makes random array for squares layout
        Button[] b = squaresView.buttons(); // array of the buttons used for the game

        // Sets text for each button to randomized numbers
        b[0].setText(String.format(Locale.US, "%d", squaresArray[0][0])); // b1
        b[1].setText(String.format(Locale.US, "%d", squaresArray[0][1])); // b2
        b[2].setText(String.format(Locale.US, "%d", squaresArray[0][2])); // b3
        b[3].setText(String.format(Locale.US, "%d", squaresArray[0][3])); // b4
        b[4].setText(String.format(Locale.US, "%d", squaresArray[1][0])); // b5
        b[5].setText(String.format(Locale.US, "%d", squaresArray[1][1])); // b6
        b[6].setText(String.format(Locale.US, "%d", squaresArray[1][2])); // b7
        b[7].setText(String.format(Locale.US, "%d", squaresArray[1][3])); // b8
        b[8].setText(String.format(Locale.US, "%d", squaresArray[2][0])); // b9
        b[9].setText(String.format(Locale.US, "%d", squaresArray[2][1])); // b10
        b[10].setText(String.format(Locale.US, "%d", squaresArray[2][2])); // b11
        b[11].setText(String.format(Locale.US, "%d", squaresArray[2][3])); // b12
        b[12].setText(String.format(Locale.US, "%d", squaresArray[3][0])); // b13
        b[13].setText(String.format(Locale.US, "%d", squaresArray[3][1])); // b14
        b[14].setText(String.format(Locale.US, "%d", squaresArray[3][2])); // b15
        b[15].setText(String.format(Locale.US, "%d", squaresArray[3][3])); // b16

        // A reset button that resets the game
        Button reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });

        // Sets onClickListener for buttons and shows an alertDialog when player wins
        for (int i = 0; i < b.length; i++) {
            b[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    squaresView.isValid(view.getId()); // checks if button can be moved
                    squaresView.hasWon();
                    if (squaresModel.hasWon) { // if game has won
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("You Won!");
                        builder.setCancelable(true);

                        // Exit Button on alert popup
                        builder.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finishAffinity();
                            }
                        });

                        // Restart Button on alert popup
                        builder.setNegativeButton("Restart", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                startActivity(new Intent(MainActivity.this, MainActivity.class));
                            }
                        });
                        AlertDialog popup = builder.create();
                        popup.show();
                    }
                }
            });
        }
    }
}






