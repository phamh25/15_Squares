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
        int [] randIntArr = randomizeNumbers(); // instance of random numbers
        int [][] squaresArray = new int[4][4]; // new 2D array
        // turns randomized number 1D array into a 2D array
        for(int i = 0; i < squaresArray.length; i++) {
            for (int j = 0; j < squaresArray[i].length; j++) {
                squaresArray[i][j] = randIntArr[(i * squaresArray[i].length) + j];
            }
        }
        // assigns class squaresArray to random 2D array
        this.squaresArray = squaresArray;
    }

    // Method that determines if a square movement is a valid move
    public void isValid (int id) {
        // loop through given array
        Button clicked = findViewById(id);
        if (model.isButtonPressed) {
            for (int i = 0; i < squaresArray.length; i++) {
                for (int j = 0; j < squaresArray[i].length; j++) {
                    // if tile is at row 3 col 2
                    if (i == 3 && j == 2) {
                        // if tile to the right == 0 (is invisible)
                        if (squaresArray[i][j + 1] == 0) {
                            switchButtonRight(i, j);
                            Button invisible = findViewById(R.id.b16);
                            invisible.setText(String.format(Locale.US, "%d", squaresArray[3][3]));
                            clicked.setText(String.format(Locale.US, "%d", squaresArray[3][2]));
                            clicked.setVisibility(INVISIBLE);
                            invisible.setVisibility(VISIBLE);
                        }
                        // if tile top is == 0
                        if (squaresArray[i-1][j] == 0) {
                            switchButtonTop(i, j);
                            Button invisible = findViewById(R.id.b11);
                            invisible.setText(String.format(Locale.US, "%d", squaresArray[3][2]));
                            clicked.setText(String.format(Locale.US, "%d", squaresArray[2][2]));
                            clicked.setVisibility(INVISIBLE);
                            invisible.setVisibility(VISIBLE);
                        }
                    }
                    // if tile is at row 2 col 2
                    if (i == 2 && j == 2) {
                        // if tile down == 0
                        if (squaresArray[i+1][j] == 0) {
                            switchButtonDown(i, j);
                            Button invisible = findViewById(R.id.b15);
                            invisible.setText(String.format(Locale.US, "%d", squaresArray[3][2]));
                            clicked.setText(String.format(Locale.US, "%d", squaresArray[2][2]));
                            clicked.setVisibility(INVISIBLE);
                            invisible.setVisibility(VISIBLE);
                        }
                    }
                }
            }
        }
    }


    public void switchButtonRight(int i, int j) {
        int temp = squaresArray[i][j];
        squaresArray[i][j] = 0; // set clicked tile to invisible (0)
        squaresArray[i][j+1] = temp; // set invisible to visible
    }

    public void switchButtonLeft(int i, int j) {
        int temp = squaresArray[i][j];
        squaresArray[i][j] = 0; // set clicked tile to invisible (0)
        squaresArray[i][j-1] = temp; // set invisible to visible
    }

    public void switchButtonTop(int i, int j) {
        int temp = squaresArray[i][j];
        squaresArray[i][j] = 0; // set clicked tile to invisible (0)
        squaresArray[i-1][j] = temp; // set invisible to visible
    }

    public void switchButtonDown(int i, int j) {
        int temp = squaresArray[i][j];
        squaresArray[i][j] = 0; // set clicked tile to invisible (0)
        squaresArray[i+1][j] = temp; // set invisible to visible
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