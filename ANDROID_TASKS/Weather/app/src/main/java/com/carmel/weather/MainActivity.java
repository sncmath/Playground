package com.carmel.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import Adapter.MyAdapter;
import Model.ListItem;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnItemClickistener {
    public static final String EXTRA_DATE = "applicable_date";
    public static final String EXTRA_STATE = "weather_state_name";
    public static final String EXTRA_SPEED = "wind_speed";
    public static final String EXTRA_HUMIDITY = "humidity";
    public static final String EXTRA_TEMP = "the_temp";
    public static final String EXTRA_MINTEMP = "min_temp";
    public static final String EXTRA_MAXTEMP = "max_temp";
    public static final String EXTRA_DIRECTION= "wind_direction_compass";
    public static final String EXTRA_PREDICT = "predictability";




    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private ArrayList<ListItem> listItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        listItems=new ArrayList<>();

        parseJSON();
    }

    private void parseJSON(){
        String url = "https://www.metaweather.com/api/location/2295420/";

        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("consolidated_weather");

                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject object=jsonArray.getJSONObject(i);
                        ListItem listitems = new ListItem(object.getString("applicable_date"),object.getString("weather_state_name"),object.getString("wind_speed"),object.getString("humidity"),object.getString("the_temp"),object.getString("min_temp"),object.getString("max_temp"),object.getString("wind_direction_compass"),object.getString("predictability"));
                        listItems.add(listitems);
                    }
                    adapter = new MyAdapter(listItems, getApplicationContext());
                    recyclerView.setAdapter(adapter);
                    adapter.setOnItemClickListener(MainActivity.this);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue=Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        ListItem ClickedItem = listItems.get(position);

        detailIntent.putExtra(EXTRA_DATE,ClickedItem.getDate());
        detailIntent.putExtra(EXTRA_STATE,ClickedItem.getWeatherstate());
        detailIntent.putExtra(EXTRA_SPEED,ClickedItem.getSpeed());
        detailIntent.putExtra(EXTRA_HUMIDITY,ClickedItem.getHumidity());
        detailIntent.putExtra(EXTRA_TEMP,ClickedItem.getTemp());
        detailIntent.putExtra(EXTRA_MINTEMP,ClickedItem.getMintemp());
        detailIntent.putExtra(EXTRA_MAXTEMP,ClickedItem.getMaxtemp());
        detailIntent.putExtra(EXTRA_DIRECTION,ClickedItem.getDirection());
        detailIntent.putExtra(EXTRA_PREDICT,ClickedItem.getPredict());

        startActivity(detailIntent);
    }
}
