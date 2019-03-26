package com.example.e176688c.androidmovieproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class Films extends AppCompatActivity {

    private EditText nomFilm;
    private TextView textViewDate;
    private Spinner genre;
    private SeekBar seekBar;
    private ImageView searchImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.films);

        nomFilm = findViewById(R.id.recherche);
        textViewDate = findViewById(R.id.textViewDate);
        genre = findViewById(R.id.spinnerGenre);
        seekBar = findViewById(R.id.seekBar);
        searchImage = findViewById(R.id.searchImage);

    }
}
