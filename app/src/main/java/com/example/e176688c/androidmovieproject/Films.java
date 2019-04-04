package com.example.e176688c.androidmovieproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class Films extends AppCompatActivity {

    private EditText nomFilm;
    private TextView textViewDate;
    private Spinner genre;
    private EditText number;
    private ImageView searchImage;
    private TextView hey;

    private static final String TAG = "CA MORCHE PO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.films);

        nomFilm = findViewById(R.id.recherche);
        textViewDate = findViewById(R.id.textViewDate);
        genre = findViewById(R.id.spinnerGenre);
        number = findViewById(R.id.number);
        searchImage = findViewById(R.id.searchImage);
        hey = findViewById(R.id.textView4);

        Ion.with(getApplicationContext())
                .load("https://api.themoviedb.org/3/genre/movie/list?api_key=47429c75658c20baa526d62ef06a9d92")
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {

                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        Gson gson = new Gson();
                        JsonArray json = result.getAsJsonArray("genres");
                        Genre[] genres = gson.fromJson(json,Genre[].class);

                        Spinner spinGenre = findViewById(R.id.spinnerGenre);
                        ArrayAdapter<Genre> genreUniqueArrayAdapter = new ArrayAdapter<Genre>(getApplicationContext(), android.R.layout.simple_spinner_item, genres);
                        genreUniqueArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinGenre.setAdapter(genreUniqueArrayAdapter);
                    }
                });

        searchImage.setOnClickListener(new View.OnClickListener(){


            public void onClick(View v) {
                EditText date = findViewById(R.id.textViewDate);
                Toast.makeText(getApplicationContext(),"Vous avez cliqué sur l'image",Toast.LENGTH_LONG).show();
                Ion.with(getApplicationContext())
                        .load("https://api.themoviedb.org/3/search/movie?api_key=47429c75658c20baa526d62ef06a9d92&language=FR&query="+ nomFilm.getText() +"&page=1&include_adult=false&year="+date.getText())
                        .asJsonObject()
                        .setCallback(new FutureCallback<JsonObject>() {
                            @Override
                            public void onCompleted(Exception e, JsonObject result) {
                                Gson gson = new Gson();
                                JsonArray json = result.getAsJsonArray("results");
                                FilmData[] filmData = gson.fromJson(json, FilmData[].class);
                                String s = gson.toJson(filmData);
                                System.out.println(filmData);
                                Intent intent = new Intent(Films.this, Resultats.class);
                                intent.putExtra("json",s);
                                startActivity(intent);
                            }
                        });
                /*Intent intent = new Intent(Films.this, Resultats.class);
                System.out.println(nomFilm.getText().toString());
                intent.putExtra("search",nomFilm.getText());
                intent.putExtra("date",date.getText());
                startActivity(intent);*/
            }
        });
    }

}
