package com.example.e176688c.androidmovieproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Resultats extends AppCompatActivity {

    private ScrollView scrollViewResults;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultats);

        android.support.constraint.ConstraintLayout container= findViewById(R.id.container);
        listView = findViewById(R.id.listResults);

        Gson gson = new Gson();
        String extras = getIntent().getStringExtra("json");
        System.out.println(extras);
        FilmData[] filmData = gson.fromJson(extras, FilmData[].class);
        System.out.println(filmData[0].getTitle());

        Type listType = new TypeToken<ArrayList<FilmData>>() {}.getType();

        ArrayList<FilmData> yourList = new Gson().fromJson(extras, listType);
        System.out.println(yourList);
        MovieAdapter filmDataArrayAdapter = new MovieAdapter(this, yourList);
        listView.setAdapter(filmDataArrayAdapter);

        /*final String search = getIntent().getStringExtra("search");
        final String date = getIntent().getStringExtra("date");
        Ion.with(getApplicationContext())
                .load("https://api.themoviedb.org/3/search/movie?api_key=47429c75658c20baa526d62ef06a9d92&language=FR&query="+ search +"&page=1&include_adult=false&year="+ date)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        Gson gson = new Gson();
                        JsonArray results = result.getAsJsonArray("results");
                        System.out.println(search);
                        FilmData[] filmData = gson.fromJson(results, FilmData[].class);
                        ArrayAdapter<FilmData> filmDataArrayAdapter = new ArrayAdapter<FilmData>(getApplicationContext(), android.R.layout.simple_list_item_1, filmData);
                        listView.setAdapter(filmDataArrayAdapter);
                    }
                });*/
    }

    }
