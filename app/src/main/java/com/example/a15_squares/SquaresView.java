package com.example.a15_squares;

import static java.lang.Math.abs;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

public class SquaresView extends TableLayout {
    // instances
    private SquaresModel model = new SquaresModel();
    public int[][] squaresArray;

    // squaresview constructor
    public SquaresView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    // Method that randomizes a 1D array
    public int[] randomizeNumbers() {
        Random rand = new Random();
        int[] randomInts = new int[16];
        // initializes array of ints 1-15
        for (int i = 0; i < randomInts.length - 1; i++) {
            randomInts[i] = i + 1;
        }
        // randomly shuffles array of ints, leaves last element always 0
        for (int i = 0; i < randomInts.length - 1; i++) {
            int randomIndexToSwap = rand.nextInt(randomInts.length - 1);
            int temp = randomInts[randomIndexToSwap];
            randomInts[randomIndexToSwap] = randomInts[i];
            randomInts[i] = temp;
        }
        return randomInts;
    }

    // 2D Array Representation of Board
    public void squaresArray() {
        int[] randIntArr = randomizeNumbers(); // instance of random numbers
        int[][] squaresArray = new int[4][4]; // new 2D array
        // turns randomized number 1D array into a 2D array
        for (int i = 0; i < squaresArray.length; i++) {
            for (int j = 0; j < squaresArray[i].length; j++) {
                squaresArray[i][j] = randIntArr[(i * squaresArray[i].length) + j];
            }
        }
        // assigns class squaresArray to random 2D array
        this.squaresArray = squaresArray;
    }

    // Array of buttons to be used
    public Button[] buttons() {
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

        // Array of buttons
        Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9,
                b10, b11, b12, b13, b14, b15, b16};

        return buttons;
    }

    // Method that determines if a square movement is a valid move
    public void isValid(int id) {
        Button clicked = findViewById(id);
        int c = clicked.getId();
        Button[] b = buttons();

        // for all cases of each button
        if (c == R.id.b1) { // b1
            // check to the right
            checkSpot(0, 0, 0, 1, b[0], b[1]);
            // check below
            checkSpot(0, 0, 1, 0, b[0], b[4]);
        }
        else if (c == R.id.b2) { // b2
            // check to the right
            checkSpot(0, 1, 0, 2, b[1], b[2]);
            // check to the left
            checkSpot(0, 1, 0, 0, b[1], b[0]);
            // check below
            checkSpot(0, 1, 1, 1, b[1], b[5]);
        }
        else if (c == R.id.b3) { // b3
            // check to the right
            checkSpot(0, 2, 0, 3, b[2], b[3]);
            // check to the left
            checkSpot(0, 2, 0, 1, b[2], b[1]);
            // check to below
            checkSpot(0, 2, 1, 2, b[2], b[6]);
        }
        else if (c == R.id.b4) { // b4
            // check to the left
            checkSpot(0, 3, 0, 2, b[3], b[2]);
            // check below
            checkSpot(0, 3, 1, 3, b[3], b[7]);
        }
        else if (c == R.id.b5) { // b5
            // check above
            checkSpot(1, 0, 0, 0, b[4], b[0]);
            // check to the right
            checkSpot(1, 0, 1, 1, b[4], b[5]);
            // check below
            checkSpot(1, 0, 2, 0, b[4], b[8]);
        }
        else if (c == R.id.b6) { // b6
            // check above
            checkSpot(1, 1, 0, 1, b[5], b[1]);
            // check to the right
            checkSpot(1, 1, 1, 2, b[5], b[6]);
            // check to the left
            checkSpot(1, 1, 1, 0, b[5], b[4]);
            // check below
            checkSpot(1, 1, 2, 1, b[5], b[9]);
        }
        else if (c == R.id.b7) { // b7
            // check above
            checkSpot(1, 2, 0, 2, b[6], b[2]);
            // check to the right
            checkSpot(1, 2, 1, 3, b[6], b[7]);
            // check to the left
            checkSpot(1, 2, 1, 1, b[6], b[5]);
            // check below
            checkSpot(1, 2, 2, 2, b[6], b[10]);
        }
        else if (c == R.id.b8) { // b8
            // check above
            checkSpot(1, 3, 0, 3, b[7], b[3]);
            // check to the left
            checkSpot(1, 3, 1, 2, b[7], b[6]);
            // check below
            checkSpot(1, 3, 2, 3, b[7], b[11]);
        }
        else if (c == R.id.b9) { // b9
            // check above
            checkSpot(2, 0, 1, 0, b[8], b[4]);
            // check to the right
            checkSpot(2, 0, 2, 1, b[8], b[9]);
            // check below
            checkSpot(2, 0, 3, 0, b[8], b[12]);
        }
        else if (c == R.id.b10) { // b10
            // check above
            checkSpot(2, 1, 1, 1, b[9], b[5]);
            // check to the right
            checkSpot(2, 1, 2, 2, b[9], b[10]);
            // check to the left
            checkSpot(2, 1, 2, 0, b[9], b[8]);
            // check below
            checkSpot(2, 1, 3, 1, b[9], b[13]);
        }
        else if (c == R.id.b11) { // b11
            // check above
            checkSpot(2, 2, 1, 2, b[10], b[6]);
            // check to the right
            checkSpot(2, 2, 2, 3, b[10], b[11]);
            // check to the left
            checkSpot(2, 2, 2, 1, b[10], b[9]);
            // check below
            checkSpot(2, 2, 3, 2, b[10], b[14]);
        }
        else if (c == R.id.b12) { // b12
            // check above
            checkSpot(2, 3, 1, 3, b[11], b[7]);
            // check to the left
            checkSpot(2, 3, 2, 2, b[11], b[10]);
            // check below
            checkSpot(2, 3, 3, 3, b[11], b[15]);
        }
        else if (c == R.id.b13) { // b13
            // check above
            checkSpot(3, 0, 2, 0, b[12], b[8]);
            // check to the right
            checkSpot(3, 0, 3, 1, b[12], b[13]);
        }
        else if (c == R.id.b14) { // b14
            // check above
            checkSpot(3, 1, 2, 1, b[13], b[9]);
            // check to the right
            checkSpot(3, 1, 3, 2, b[13], b[14]);
            // check to the left
            checkSpot(3, 1, 3, 0, b[13], b[12]);
        }
        else if (c == R.id.b15) { // b15
            // check above
            checkSpot(3, 2, 2, 2, b[14], b[10]);
            // check to the right
            checkSpot(3, 2, 3, 3, b[14], b[15]);
            // check to the left
            checkSpot(3, 2, 3, 1, b[14], b[13]);
        }
        else if (c == R.id.b16) { // b16
            // check above
            checkSpot(3, 3, 2, 3, b[15], b[11]);
            // check to the left
            checkSpot(3, 3, 3, 2, b[15], b[14]);
        }
    }

    public void checkSpot(int i, int j, int ii, int jj, Button one, Button two) {
        // checks between 2 elements if there is an empty spot
        if (squaresArray[ii][jj] == 0) {
            squaresArray[ii][jj] = squaresArray[i][j];
            squaresArray[i][j] = 0;
            one.setText(String.format(Locale.US, "%d", squaresArray[i][j]));
            two.setText(String.format(Locale.US, "%d", squaresArray[ii][jj]));
            one.setVisibility(INVISIBLE);
            two.setVisibility(VISIBLE);
        }
    }

    public void startGame () {
        // game is started
        squaresArray(); // makes a random array
    }

    public void testPrint () {
        for (int i = 0; i < squaresArray.length; i++) {
            for (int j = 0; j < squaresArray[i].length; j++) {
                System.out.println(squaresArray[i][j]);
            }
        }
    }

    public SquaresModel getModel () {
        return model;
    }
}