package com.example.user.foodtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.InputStream;

/**
 * Created by user on 05/09/2016.
 */
public class FoodTracker extends AppCompatActivity {

    Button mSubmitEntry;
    EditText mUserEntry;
    Button  mAdviceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSubmitEntry = (Button) findViewById(R.id.button);
        mUserEntry = (EditText) findViewById(R.id.editText);
        mAdviceButton = (Button) findViewById(R.id.button3);

        mSubmitEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String entry = mUserEntry.getText().toString();
                Intent intent = new Intent(FoodTracker.this, FoodSubmit.class);
                startActivity(intent);

                mAdviceButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(FoodTracker.this, FoodAdvice.class);
                        startActivity(intent);
                    }


                });

            });


        }


