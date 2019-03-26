package com.example.e176688c.androidmovieproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Films extends AppCompatActivity {

    private EditText nomFilm;
    private TextView textViewDate;
    private Spinner genre;
    private EditText number;
    private ImageView searchImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.films);

        nomFilm = findViewById(R.id.recherche);
        textViewDate = findViewById(R.id.textViewDate);
        genre = findViewById(R.id.spinnerGenre);
        number = findViewById(R.id.number);
        searchImage = findViewById(R.id.searchImage);

        searchImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Vous avez cliqué sur l'image",Toast.LENGTH_LONG).show();
            }
        });
    }
}
