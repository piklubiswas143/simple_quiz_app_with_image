package com.example.quizeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
Button startAgain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       startAgain=(Button)findViewById(R.id.sta);

    }

    public void startAgain(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }
}