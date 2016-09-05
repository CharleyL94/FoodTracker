package com.example.user.foodtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by user on 05/09/2016.
 */
public class FoodAdvice extends AppCompatActivity {

    TextView mAdviceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice);

//        mAdviceButton = (Button) findViewById(R.id.button3);

        Intent intent = getIntent();
    }
}
