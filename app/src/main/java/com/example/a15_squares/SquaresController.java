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

    public void onClick(View view){
        Log.d("button","Slide");
        model.isButtonPressed = true;
        view.invalidate();
    }

}
