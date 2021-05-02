package com.example.quizeapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Variable declaration
    ProgressBar progressBar;
    TextView score, qurstion;
    Button ture, fals;
    int Arrayindex;
    ImageView image;
    int newscore;
    int counter;

    private Modal[] modals = new Modal[]{
            new Modal("One", true, R.drawable.one),
            new Modal("Two", false, R.drawable.three),
            new Modal("Three", false, R.drawable.two),
            new Modal("Four", true, R.drawable.four),
            new Modal("Five", true, R.drawable.fiv),
            new Modal("Six", true, R.drawable.six),
    };
    final int prograssbar = (int) Math.ceil(100. / modals.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Casting
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        score = (TextView) findViewById(R.id.score);
        qurstion = (TextView) findViewById(R.id.qurstion);
        ture = (Button) findViewById(R.id.truee);
        fals = (Button) findViewById(R.id.falsee);
        image = (ImageView) findViewById(R.id.imageview);

        qurstion.setText(modals[Arrayindex].getQurtion());
        image.setImageResource(modals[Arrayindex].getImage());
        score.setText("0/"+modals.length);

        ture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(true);
                function();
                counter++;


            }
        });
        fals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check(false);
                function();
                counter++;

            }
        });


    }

    public void function() {
        Arrayindex = (Arrayindex + 1) % modals.length;
        if (counter == (modals.length-1)) {
           Toast.makeText(getApplicationContext(),"complate",Toast.LENGTH_SHORT).show();
           AlertDialog.Builder alart = new AlertDialog.Builder(this);
           alart.setTitle("YOUR SCORE");
           alart.setMessage("You Score is "+newscore);
           alart.setCancelable(false);
           alart.setPositiveButton("OK", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which) {
                   startActivity(new Intent(MainActivity.this,MainActivity2.class));
               }
           });
           alart.show();

        }
        qurstion.setText(modals[Arrayindex].getQurtion());
        image.setImageResource(modals[Arrayindex].getImage());
        progressBar.incrementProgressBy(prograssbar);


    }

    public void check(boolean tureflash) {

        boolean defelattf = modals[Arrayindex].isTruefalse();

        if (tureflash == defelattf) {
            newscore = newscore + 1;
            Toast.makeText(getApplicationContext(), "Right", Toast.LENGTH_SHORT).show();
            Log.d("jl", "m");
            score.setText(String.valueOf(newscore + "/" + modals.length));

        } else {
            Toast.makeText(getApplicationContext(), "Worng", Toast.LENGTH_SHORT).show();
        }

    }
}