package com.example.e176688c.androidmovieproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class PresentationFilm extends AppCompatActivity {

    private TextView titre;
    private TextView resume;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation_film);
        String extras = getIntent().getStringExtra("film");
        Gson gson = new Gson();
        FilmData filmData = gson.fromJson(extras, FilmData.class);
        titre = findViewById(R.id.textView2);
        titre.setText(filmData.getTitle());
        resume = findViewById(R.id.Robert);
        resume.setText(filmData.getOverview());
        img = findViewById(R.id.imageView);
        Picasso.get().load("https://image.tmdb.org/t/p/w500"+filmData.getPoster_path()).into(img);
    }
}
