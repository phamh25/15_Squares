/******************************************************************************
 //
 // Main Class File:  MainActivity.java
 // File:             SquaresController.java
 // Semester:         CS 301 Spring 2023
 //
 // Author:           Heidi Pham
 // Lecturer's Name:  Dr. Steven Libby
 //
 /******************************************************************************/
package com.example.a15_squares;

import android.util.Log;
import android.view.View;

/**
 * A class that initializes a part of the button actions of the game
 * @author <Heidi Pham>
 */
public class SquaresController implements View.OnClickListener{

    private SquaresView view;
    private SquaresModel model;

    /**
     * SquaresController constructor
     * @param view - the view of the game
     */
    public SquaresController(SquaresView view) {
        this.view =  view;
        this.model = view.getModel();
    }

    /**
     * A method that builds an onClickListener for this class
     * @param view - the view of the game
     */
    public void onClick(View view){
        Log.d("button","button");
    }
}
