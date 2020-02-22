package com.carmel.jsonmovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.carmel.jsonmovie.MainActivity.EXTRA_OVERVIEW;
import static com.carmel.jsonmovie.MainActivity.EXTRA_RELEASE;
import static com.carmel.jsonmovie.MainActivity.EXTRA_TITLE;
import static com.carmel.jsonmovie.MainActivity.EXTRA_URL;

public class MovieDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        Intent intent = getIntent();
        String mimageview = intent.getStringExtra(EXTRA_URL);
        String mtextview = intent.getStringExtra(EXTRA_TITLE);
        String mrelease = intent.getStringExtra(EXTRA_RELEASE);
        String moverview = intent.getStringExtra(EXTRA_OVERVIEW);

        ImageView imageView = findViewById(R.id.imageDetail);
        TextView textView = findViewById(R.id.titleDetail);
        TextView release = findViewById(R.id.releaseDetail);
        TextView overview = findViewById(R.id.overviewDetail);

        Picasso.with(this).load("https://image.tmdb.org/t/p/w200"+mimageview).placeholder(R.mipmap.ic_launcher).into(imageView);
        textView.setText(String.format("Title: %s", mtextview));
        release.setText(String.format("Release On: %s (yyyy-mm-dd)", mrelease));
        overview.setText(String.format("Overview: %s",moverview));
    }
}
