package com.example.a15_squares;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
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

        // member variables
        int[][] squaresArray = squaresView.squaresArray();

        // buttons
        // b11
        Button b11 = findViewById(R.id.b11);
        b11.setOnClickListener(squaresController);
        b11.setText(String.format(Locale.US, "%d", squaresArray[0][0]));


        // b12
        Button b12 = findViewById(R.id.b12);
        b12.setOnClickListener(squaresController);
        b12.setText(String.format(Locale.US, "%d", squaresArray[0][1]));

        // b13
        Button b13 = findViewById(R.id.b13);
        b13.setOnClickListener(squaresController);
        b13.setText(String.format(Locale.US, "%d", squaresArray[0][2]));

        // b14
        Button b14 = findViewById(R.id.b14);
        b14.setOnClickListener(squaresController);
        b14.setText(String.format(Locale.US, "%d", squaresArray[0][3]));

        // b21
        Button b21 = findViewById(R.id.b21);
        b21.setOnClickListener(squaresController);
        b21.setText(String.format(Locale.US, "%d", squaresArray[1][0]));

        // b22
        Button b22 = findViewById(R.id.b22);
        b22.setOnClickListener(squaresController);
        b22.setText(String.format(Locale.US, "%d", squaresArray[1][1]));

        // b23
        Button b23 = findViewById(R.id.b23);
        b23.setOnClickListener(squaresController);
        b23.setText(String.format(Locale.US, "%d", squaresArray[1][2]));

        // b24
        Button b24 = findViewById(R.id.b24);
        b24.setOnClickListener(squaresController);
        b24.setText(String.format(Locale.US, "%d", squaresArray[1][3]));

        // b31
        Button b31 = findViewById(R.id.b31);
        b31.setOnClickListener(squaresController);
        b31.setText(String.format(Locale.US, "%d", squaresArray[2][0]));

        // b32
        Button b32 = findViewById(R.id.b32);
        b32.setOnClickListener(squaresController);
        b32.setText(String.format(Locale.US, "%d", squaresArray[2][1]));

        // b33
        Button b33 = findViewById(R.id.b33);
        b33.setOnClickListener(squaresController);
        b33.setText(String.format(Locale.US, "%d", squaresArray[2][2]));

        // b34
        Button b34 = findViewById(R.id.b34);
        b34.setOnClickListener(squaresController);
        b34.setText(String.format(Locale.US, "%d", squaresArray[2][3]));

        // b41
        Button b41 = findViewById(R.id.b41);
        b41.setOnClickListener(squaresController);
        b41.setText(String.format(Locale.US, "%d", squaresArray[3][0]));

        // b42
        Button b42 = findViewById(R.id.b42);
        b42.setOnClickListener(squaresController);
        b42.setText(String.format(Locale.US, "%d", squaresArray[3][1]));

        // b43
        Button b43 = findViewById(R.id.b43);
        b43.setOnClickListener(squaresController);
        b43.setText(String.format(Locale.US, "%d", squaresArray[3][2]));

        // b44
        Button b44 = findViewById(R.id.b44);
        b44.setOnClickListener(squaresController);
        b44.setText(String.format(Locale.US, "%d", squaresArray[3][3]));

        // reset button
        Button reset = findViewById(R.id.reset);
        reset.setOnClickListener(squaresController);
    }
}