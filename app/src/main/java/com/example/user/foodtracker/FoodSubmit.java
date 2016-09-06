package com.example.user.foodtracker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by user on 05/09/2016.
 */
public class FoodSubmit extends AppCompatActivity {

//    TextView mSubmitText;
    ListView mFoodList;
    private String file = "inputdata";



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_list);


//        mSubmitText = (TextView) findViewById(R.id.submit_text);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        mFoodList = (ListView) findViewById(R.id.food_list);


        ArrayList<String> listOfFood;
        listOfFood = this.readFromFile();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_row,
                R.id.row, listOfFood);
        mFoodList.setAdapter(adapter);

    }

    private ArrayList<String> readFromFile(){
        Context ctx = getApplicationContext();
        File mySavedFile = ctx.getFileStreamPath(file);
        Log.d("readfile", "File found:" + Boolean.toString(mySavedFile.exists()));

        Scanner myScanner = null;

        try{
            myScanner = new Scanner(mySavedFile);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        ArrayList<String> arrayOfLines = new ArrayList<String>();

        while (myScanner.hasNextLine()){
            arrayOfLines.add( (String) myScanner.nextLine());
        }

        for (int i = 0; i < arrayOfLines.size(); i++){
            Log.d("readfile", arrayOfLines.get(i));
        }
        return arrayOfLines;



    }
}
