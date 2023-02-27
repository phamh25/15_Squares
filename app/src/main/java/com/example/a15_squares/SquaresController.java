package com.example.a15_squares;

import android.util.Log;
import android.view.View;

public class SquaresController implements View.OnClickListener{

    private SquaresView view;
    private SquaresModel model;

    // SquaresController constructor
    public SquaresController(SquaresView view) {
        this.view =  view;
        this.model = view.getModel();
    }

    // Logs every time a button is clicked
    public void onClick(View view){
        Log.d("button","button");
    }

}
