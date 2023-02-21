package com.example.a15_squares;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import java.util.Arrays;
import java.util.Random;

public class SquaresView extends TableLayout {
    private SquaresModel model = new SquaresModel();

    public SquaresView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    // Method that randomizes the numbers in an array
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
    public int[][] squaresArray() {
        int [] randIntArr = randomizeNumbers(); // instance of random numbers
        int [][] squaresArray = new int[4][4]; // new 2D array

        // turns randomized number 1D array into a 2D array
        for(int i = 0; i < squaresArray.length; i++) {
            for (int j = 0; j < squaresArray[i].length; j++) {
                squaresArray[i][j] = randIntArr[(i * squaresArray[i].length) + j];
                System.out.println(squaresArray[i][j]);
            }
        }
        return squaresArray;
    }

    // Method that determines if a square movement is a valid move
    public void isValid (Button button, Button space) {
        if (model.isButtonPressed) {
//            if (button == findViewById()) {
//
//            }
        }
    }

    public SquaresModel getModel() {
        return model;
    }
}
