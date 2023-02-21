package com.example.a15_squares;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import java.util.Random;

public class SquaresView extends TableLayout {
    private SquaresModel model = new SquaresModel();

    public SquaresView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public void randomizeNumbers() {
        Random rand = new Random();
        int[] randomInts = new int[15];

        // randomizes array of ints
        for (int i = 0; i < randomInts.length; i++) {
            randomInts[i] = rand.nextInt(15-1) + 1;; // storing random integers in an array
            System.out.println(randomInts[i] + " "); // printing each array element
        }
    }

    public SquaresModel getModel() {
        return model;
    }
}
