package com.example.user.foodtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by user on 05/09/2016.
 */
public class FoodSubmit extends AppCompatActivity {

    TextView mSubmitText;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);


        mSubmitText = (TextView)findViewById(R.id.submit_text);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
    }
}
