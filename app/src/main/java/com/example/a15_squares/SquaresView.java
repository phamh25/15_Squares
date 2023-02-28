/******************************************************************************
//
// Main Class File:  MainActivity.java
// File:             SquaresView.java
// Semester:         CS 301 Spring 2023
// Date:             2/28/2023
// Author:           Heidi Pham
// Lecturer's Name:  Dr. Steven Libby
//
/******************************************************************************/
package com.example.a15_squares;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TableLayout;
import java.util.Locale;
import java.util.Random;

/**
 * A class that constructs the view of the game and handles
 * and creates the main methods
 * @author <Heidi Pham>
 */
public class SquaresView extends TableLayout {
    // Instances
    private SquaresModel model = new SquaresModel();
    public int[][] squaresArray; // a 2D array that represents the squares

    /**
     * SquaresView constructor
     * @param context - context, theme
     * @param attrs - attributes
     */
    public SquaresView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * Randomizes a 1D array
     * @return randomInts array
     */
    private int[] randomizeNumbers() {
        // Variables
        Random rand = new Random();
        int[] randomInts = new int[16];

        // Initializes array of ints 1-15
        for (int i = 0; i < randomInts.length - 1; i++) {
            randomInts[i] = i + 1;
        }

        /***************************************************************************************
         *    Title: <How to shuffle an array in Java>
         *    Author: <Pankaj>
         *    Date: <2022>
         *    Availability: <https://www.digitalocean.com/community/tutorials/shuffle-array-java>
         ***************************************************************************************/
        // Randomly shuffles array of ints, leaves last element always 0
        for (int i = 0; i < randomInts.length - 1; i++) {
            int randomIndexToSwap = rand.nextInt(randomInts.length - 1);
            int temp = randomInts[randomIndexToSwap];
            randomInts[randomIndexToSwap] = randomInts[i];
            randomInts[i] = temp;
        }
        return randomInts;
    }

    /** 2D Array Representation of Board */
    private void squaresArray() {
        // Variables
        int[] randIntArr = randomizeNumbers(); // randomized number 1D array
        int[][] squaresArray = new int[4][4]; // new 2D array

        // Turns randomized number 1D array into a 2D array
        for (int i = 0; i < squaresArray.length; i++) {
            for (int j = 0; j < squaresArray[i].length; j++) {
                squaresArray[i][j] = randIntArr[(i * squaresArray[i].length) + j];
            }
        }
        this.squaresArray = squaresArray;
    }

    /**
     * Method that returns an array of buttons to be used
     * @return Button array
     */
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

    /**
     * Method that moves the clicked button for a valid move
     * @param id - id of clicked button
     */
    public void isValid(int id) {
        // Variables
        Button clicked = findViewById(id);
        int c = clicked.getId(); // id of clicked button
        Button[] b = buttons();

        // Check for all cases of each button
        if (c == R.id.b1) { // b1
            checkSpot(0, 0, 0, 1, b[0], b[1]); // right
            checkSpot(0, 0, 1, 0, b[0], b[4]); // below
        }
        else if (c == R.id.b2) { // b2
            checkSpot(0, 1, 0, 2, b[1], b[2]); // right
            checkSpot(0, 1, 0, 0, b[1], b[0]); // left
            checkSpot(0, 1, 1, 1, b[1], b[5]); // below
        }
        else if (c == R.id.b3) { // b3
            checkSpot(0, 2, 0, 3, b[2], b[3]); // right
            checkSpot(0, 2, 0, 1, b[2], b[1]); // left
            checkSpot(0, 2, 1, 2, b[2], b[6]); // below
        }
        else if (c == R.id.b4) { // b4
            checkSpot(0, 3, 0, 2, b[3], b[2]); // left
            checkSpot(0, 3, 1, 3, b[3], b[7]); // below
        }
        else if (c == R.id.b5) { // b5
            checkSpot(1, 0, 0, 0, b[4], b[0]); // above
            checkSpot(1, 0, 1, 1, b[4], b[5]); // right
            checkSpot(1, 0, 2, 0, b[4], b[8]); // below
        }
        else if (c == R.id.b6) { // b6
            checkSpot(1, 1, 0, 1, b[5], b[1]); // above
            checkSpot(1, 1, 1, 2, b[5], b[6]); // right
            checkSpot(1, 1, 1, 0, b[5], b[4]); // left
            checkSpot(1, 1, 2, 1, b[5], b[9]); // below
        }
        else if (c == R.id.b7) { // b7
            checkSpot(1, 2, 0, 2, b[6], b[2]); // above
            checkSpot(1, 2, 1, 3, b[6], b[7]); // right
            checkSpot(1, 2, 1, 1, b[6], b[5]); // left
            checkSpot(1, 2, 2, 2, b[6], b[10]); // below
        }
        else if (c == R.id.b8) { // b8
            checkSpot(1, 3, 0, 3, b[7], b[3]); // above
            checkSpot(1, 3, 1, 2, b[7], b[6]); // left
            checkSpot(1, 3, 2, 3, b[7], b[11]); // below
        }
        else if (c == R.id.b9) { // b9
            checkSpot(2, 0, 1, 0, b[8], b[4]); // above
            checkSpot(2, 0, 2, 1, b[8], b[9]); // right
            checkSpot(2, 0, 3, 0, b[8], b[12]); // below
        }
        else if (c == R.id.b10) { // b10
            checkSpot(2, 1, 1, 1, b[9], b[5]); // above
            checkSpot(2, 1, 2, 2, b[9], b[10]); // right
            checkSpot(2, 1, 2, 0, b[9], b[8]); // left
            checkSpot(2, 1, 3, 1, b[9], b[13]); // below
        }
        else if (c == R.id.b11) { // b11
            checkSpot(2, 2, 1, 2, b[10], b[6]); // above
            checkSpot(2, 2, 2, 3, b[10], b[11]); // right
            checkSpot(2, 2, 2, 1, b[10], b[9]); // left
            checkSpot(2, 2, 3, 2, b[10], b[14]); // below
        }
        else if (c == R.id.b12) { // b12
            checkSpot(2, 3, 1, 3, b[11], b[7]); // above
            checkSpot(2, 3, 2, 2, b[11], b[10]); // left
            checkSpot(2, 3, 3, 3, b[11], b[15]); // below
        }
        else if (c == R.id.b13) { // b13
            checkSpot(3, 0, 2, 0, b[12], b[8]); // above
            checkSpot(3, 0, 3, 1, b[12], b[13]); // left
        }
        else if (c == R.id.b14) { // b14
            checkSpot(3, 1, 2, 1, b[13], b[9]); // above
            checkSpot(3, 1, 3, 2, b[13], b[14]); // right
            checkSpot(3, 1, 3, 0, b[13], b[12]); // left
        }
        else if (c == R.id.b15) { // b15
            checkSpot(3, 2, 2, 2, b[14], b[10]); // above
            checkSpot(3, 2, 3, 3, b[14], b[15]); // right
            checkSpot(3, 2, 3, 1, b[14], b[13]); // left
        }
        else if (c == R.id.b16) { // b16
            checkSpot(3, 3, 2, 3, b[15], b[11]); // above
            checkSpot(3, 3, 3, 2, b[15], b[14]); // left
        }
    }

    /**
     * Helper method that checks if the clicked button can be moved
     * @param i - row of clicked button
     * @param j - col of clicked button
     * @param ii - row of checked button
     * @param jj - col of checked button
     * @param one - clicked button
     * @param two - checked button
     */
    private void checkSpot(int i, int j, int ii, int jj, Button one, Button two) {
        // Checks between 2 elements if there is an empty spot
        if (squaresArray[ii][jj] == 0) {
            // Switch element numbs in 2D array
            squaresArray[ii][jj] = squaresArray[i][j];
            squaresArray[i][j] = 0;

            // Switch button texts
            one.setText(String.format(Locale.US, "%d", squaresArray[i][j]));
            two.setText(String.format(Locale.US, "%d", squaresArray[ii][jj]));

            // Switch button visibilities
            one.setVisibility(INVISIBLE);
            two.setVisibility(VISIBLE);
        }
    }

    /** Method that sees if the game has been won */
    public void hasWon() {
        model.hasWon = squaresArray[0][0] == 1 && squaresArray[0][1] == 2 && squaresArray[0][2] == 3
                && squaresArray[0][3] == 4 && squaresArray[1][0] == 5 && squaresArray[1][1] == 6
                && squaresArray[1][2] == 7 && squaresArray[1][3] == 8 && squaresArray[2][0] == 9
                && squaresArray[2][1] == 10 && squaresArray[2][2] == 11 && squaresArray[2][3] == 12
                && squaresArray[3][0] == 13 && squaresArray[3][1] == 14 && squaresArray[3][2] == 15;
    }

    /** Game is started */
    public void startGame () {
        squaresArray(); // makes a random array
        hasWon();
    }

    /** Model for SquaresModel */
    public SquaresModel getModel () {
        return model;
    }
}