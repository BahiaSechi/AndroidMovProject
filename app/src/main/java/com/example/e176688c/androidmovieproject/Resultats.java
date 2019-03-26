package com.example.e176688c.androidmovieproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;

public class Resultats extends AppCompatActivity {

    private ScrollView scrollViewResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultats);

        scrollViewResults = findViewById(R.id.scrollViewResults);

    }

    }
