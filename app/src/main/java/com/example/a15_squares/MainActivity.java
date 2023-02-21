package com.example.a15_squares;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // member variables
        Random rand = new Random();
        int randomNum = rand.nextInt(15)+1;

        // program create initialization
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        // view and controller
        SquaresView squaresView = findViewById(R.id.squares);
        SquaresController squaresController = new SquaresController(squaresView);

        // randomizes numbers on buttons on create


        // buttons
        // b11
        Button b11 = findViewById(R.id.b11);
        b11.setOnClickListener(squaresController);
        b11.setText("" + randomNum);

        // b12
//        Button b12 = findViewById(R.id.b12);
//        b12.setOnClickListener(squaresController);
//        b12.setText("" + randomNum);

        squaresView.randomizeNumbers();


    }
}