package com.example.e176688c.androidmovieproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;


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
                .withResponse()
                .setCallback(new FutureCallback<Response<JsonObject>>() {

                    @Override
                    public void onCompleted(Exception e, Response<JsonObject> result) {
                        //JsonArray test = result.getAsJsonArray();
                        System.out.println("heyyyy   "+result);

                    }
                });

        searchImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Vous avez cliqué sur l'image",Toast.LENGTH_LONG).show();
            }
        });
    }

}
