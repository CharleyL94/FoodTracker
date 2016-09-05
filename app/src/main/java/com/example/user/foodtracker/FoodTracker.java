package com.example.user.foodtracker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by user on 05/09/2016.
 */
public class FoodTracker extends AppCompatActivity {

    Button mSubmitEntry;
    EditText mUserEntry;
    Button mAdviceButton;

    private String file = "inputdata";

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

                saveToFile(entry);
                readFromFile();


                Intent intent = new Intent(FoodTracker.this, FoodSubmit.class);
                startActivity(intent);
            }
        });
        mAdviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("main", "Advice button clicked");
                Intent intent = new Intent(FoodTracker.this, FoodAdvice.class);
                startActivity(intent);
            }
        });


    } // onCreate

    private void saveToFile(String savedText){

        String textWithNewLine = savedText + "\n";

        try {
            FileOutputStream fOut = openFileOutput(file, MODE_APPEND);
            fOut.write(textWithNewLine.getBytes());
            fOut.close();
            Toast.makeText(getBaseContext(),"file saved", Toast.LENGTH_SHORT).show();
        }

        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void readFromFile(){
        Context ctx = getApplicationContext();
        File mySavedFile = ctx.getFileStreamPath(file);
        Log.d("readfile", mySavedFile.exists() + "" );

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


    }
}