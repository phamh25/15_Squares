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
        Button b1 = findViewById(R.id.b1);
        Button b2 = findViewById(R.id.b2);
        Button b3 = findViewById(R.id.b3);
        Button b4 = findViewById(R.id.b4);
        Button b5 = findViewById(R.id.b5);
        Button b6 = findViewById(R.id.b6);
        Button b7 = findViewById(R.id.b7);
        Button b8 = findViewById(R.id.b8);
        Button b9 = findViewById(R.id.b9);
        Button b10 = findViewById(R.id.b10);
        Button b11 = findViewById(R.id.b11);
        Button b12 = findViewById(R.id.b12);
        Button b13 = findViewById(R.id.b13);
        Button b14 = findViewById(R.id.b14);
        Button b15 = findViewById(R.id.b15);
        Button b16 = findViewById(R.id.b16);;

        Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9,
                b10, b11, b12, b13, b14, b15, b16};

        // member variables
        int[][] squaresArray = squaresView.squaresArray; // makes array for squares layout

        // buttons
        // b1
        b1.setOnClickListener(squaresController);
        b1.setText(String.format(Locale.US, "%d", squaresArray[0][0]));


        // b12
        b2.setOnClickListener(squaresController);
        b2.setText(String.format(Locale.US, "%d", squaresArray[0][1]));

        // b13
        b3.setOnClickListener(squaresController);
        b3.setText(String.format(Locale.US, "%d", squaresArray[0][2]));

        // b14
        b4.setOnClickListener(squaresController);
        b4.setText(String.format(Locale.US, "%d", squaresArray[0][3]));

        // b21
        b5.setOnClickListener(squaresController);
        b5.setText(String.format(Locale.US, "%d", squaresArray[1][0]));

        // b22
        b6.setOnClickListener(squaresController);
        b6.setText(String.format(Locale.US, "%d", squaresArray[1][1]));

        // b23
        b7.setOnClickListener(squaresController);
        b7.setText(String.format(Locale.US, "%d", squaresArray[1][2]));

        // b24
        b8.setOnClickListener(squaresController);
        b8.setText(String.format(Locale.US, "%d", squaresArray[1][3]));

        // b31
        b9.setOnClickListener(squaresController);
        b9.setText(String.format(Locale.US, "%d", squaresArray[2][0]));

        // b32
        b10.setOnClickListener(squaresController);
        b10.setText(String.format(Locale.US, "%d", squaresArray[2][1]));

        // b33
        b11.setOnClickListener(squaresController);
        b11.setText(String.format(Locale.US, "%d", squaresArray[2][2]));

        // b34
        b12.setOnClickListener(squaresController);
        b12.setText(String.format(Locale.US, "%d", squaresArray[2][3]));

        // b41
        b13.setOnClickListener(squaresController);
        b13.setText(String.format(Locale.US, "%d", squaresArray[3][0]));

        // b42
        b14.setOnClickListener(squaresController);
        b14.setText(String.format(Locale.US, "%d", squaresArray[3][1]));

        // b43
        b15.setOnClickListener(squaresController);
        b15.setText(String.format(Locale.US, "%d", squaresArray[3][2]));

        // b44
        b16.setOnClickListener(squaresController);
        b16.setText(String.format(Locale.US, "%d", squaresArray[3][3]));

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