package com.carmel.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import static com.carmel.weather.MainActivity.EXTRA_DATE;
import static com.carmel.weather.MainActivity.EXTRA_STATE;
import static com.carmel.weather.MainActivity.EXTRA_SPEED;
import static com.carmel.weather.MainActivity.EXTRA_HUMIDITY;
import static com.carmel.weather.MainActivity.EXTRA_TEMP;
import static com.carmel.weather.MainActivity.EXTRA_MINTEMP;
import static com.carmel.weather.MainActivity.EXTRA_MAXTEMP;
import static com.carmel.weather.MainActivity.EXTRA_DIRECTION;
import static com.carmel.weather.MainActivity.EXTRA_PREDICT;




public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String date = intent.getStringExtra(EXTRA_DATE);
        String state = intent.getStringExtra(EXTRA_STATE);
        String speed = intent.getStringExtra(EXTRA_SPEED);
        String humidity = intent.getStringExtra(EXTRA_HUMIDITY);
        String temp = intent.getStringExtra(EXTRA_TEMP);
        String mintemp = intent.getStringExtra(EXTRA_MINTEMP);
        String maxtemp = intent.getStringExtra(EXTRA_MAXTEMP);
        String direction = intent.getStringExtra(EXTRA_DIRECTION);
        String predict = intent.getStringExtra(EXTRA_PREDICT);

        TextView ddate = findViewById(R.id.detaildate);
        TextView dstate = findViewById(R.id.detailstate);
        TextView dspeed = findViewById(R.id.detailspeed);
        TextView dhumidity = findViewById(R.id.detailhumidity);
        TextView dtemp = findViewById(R.id.temp);
        TextView dmintemp = findViewById(R.id.mintemp);
        TextView dmaxtemp = findViewById(R.id.maxtemp);
        TextView ddirection = findViewById(R.id.direction);
        TextView dpredict = findViewById(R.id.predict);


        ddate.setText(String.format("DATE: %s", date));
        dstate.setText(String.format("WEATHER: %s",state));
        dspeed.setText(String.format("WIND SPEED: %s mph", speed));
        dhumidity.setText(String.format("HUMIDITY: %s %%", humidity));
        dtemp.setText(String.format("TEMP: %s C", temp));
        dmintemp.setText(String.format("MIN TEMP: %s C", mintemp));
        dmaxtemp.setText(String.format("MAX TEMP: %s C", maxtemp));
        ddirection.setText(String.format("WIND DIRECTION: %s", direction));
        dpredict.setText(String.format("PREDICTABILITY: %s %%", predict));
    }
}
