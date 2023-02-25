package com.example.a15_squares;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // program create initialization
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        // view and controller
        SquaresView squaresView = findViewById(R.id.squares);
        SquaresController squaresController = new SquaresController(squaresView);

        // start game on create
        squaresView.startGame();

        // Buttons
        Button[] b = squaresView.buttons();

        // member variables
        int[][] squaresArray = squaresView.squaresArray; // makes array for squares layout

        // buttons
        // b1
        b[0].setOnClickListener(squaresController);
        b[0].setText(String.format(Locale.US, "%d", squaresArray[0][0]));


        // b12
        b[1].setOnClickListener(squaresController);
        b[1].setText(String.format(Locale.US, "%d", squaresArray[0][1]));

        // b13
        b[2].setOnClickListener(squaresController);
        b[2].setText(String.format(Locale.US, "%d", squaresArray[0][2]));

        // b14
        b[3].setOnClickListener(squaresController);
        b[3].setText(String.format(Locale.US, "%d", squaresArray[0][3]));

        // b21
        b[4].setOnClickListener(squaresController);
        b[4].setText(String.format(Locale.US, "%d", squaresArray[1][0]));

        // b22
        b[5].setOnClickListener(squaresController);
        b[5].setText(String.format(Locale.US, "%d", squaresArray[1][1]));

        // b23
        b[6].setOnClickListener(squaresController);
        b[6].setText(String.format(Locale.US, "%d", squaresArray[1][2]));

        // b24
        b[7].setOnClickListener(squaresController);
        b[7].setText(String.format(Locale.US, "%d", squaresArray[1][3]));

        // b31
        b[8].setOnClickListener(squaresController);
        b[8].setText(String.format(Locale.US, "%d", squaresArray[2][0]));

        // b32
        b[9].setOnClickListener(squaresController);
        b[9].setText(String.format(Locale.US, "%d", squaresArray[2][1]));

        // b33
        b[10].setOnClickListener(squaresController);
        b[10].setText(String.format(Locale.US, "%d", squaresArray[2][2]));

        // b34
        b[11].setOnClickListener(squaresController);
        b[11].setText(String.format(Locale.US, "%d", squaresArray[2][3]));

        // b41
        b[12].setOnClickListener(squaresController);
        b[12].setText(String.format(Locale.US, "%d", squaresArray[3][0]));

        // b42
        b[13].setOnClickListener(squaresController);
        b[13].setText(String.format(Locale.US, "%d", squaresArray[3][1]));

        // b43
        b[14].setOnClickListener(squaresController);
        b[14].setText(String.format(Locale.US, "%d", squaresArray[3][2]));

        // b44
        b[15].setOnClickListener(squaresController);
        b[15].setText(String.format(Locale.US, "%d", squaresArray[3][3]));

        // reset button
        Button reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });
    }
}