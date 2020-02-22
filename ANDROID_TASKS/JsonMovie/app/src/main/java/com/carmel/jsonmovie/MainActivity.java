package com.carmel.jsonmovie;

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
import Model.ExampleItem;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnItemClickListener {
    public static final String EXTRA_URL = "poster_path";
    public static final String EXTRA_TITLE = "original_title";
    public static final String EXTRA_RELEASE = "release_date";
    public static final String EXTRA_OVERVIEW = "overview";

    private RecyclerView mRecyclerView;
    private MyAdapter myAdapter;
    private ArrayList<ExampleItem> mExampleItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(myAdapter);

        mExampleItem = new ArrayList<>();

        parseJSON();
    }

    private void parseJSON() {
        String url = "https://api.themoviedb.org/3/movie/upcoming?api_key=e71a5346f06f5cfba7b4514c607ce80e&region=US";

        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("results");

                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject object=jsonArray.getJSONObject(i);
                        ExampleItem exampleItem=new ExampleItem(object.getString("original_title"),object.getString("poster_path"),object.getString("release_date"),object.getString("overview"));
                        mExampleItem.add(exampleItem);
                    }
                    myAdapter=new MyAdapter(getApplicationContext(),mExampleItem);
                    mRecyclerView.setAdapter(myAdapter);
                    myAdapter.setOnItemClickListener(MainActivity.this);
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
        Intent detailIntent = new Intent(this,MovieDetails.class);
        ExampleItem clickedItem = mExampleItem.get(position);

        detailIntent.putExtra(EXTRA_URL,clickedItem.getMimageview());
        detailIntent.putExtra(EXTRA_TITLE,clickedItem.getMtextview());
        detailIntent.putExtra(EXTRA_RELEASE,clickedItem.getMrelease());
        detailIntent.putExtra(EXTRA_OVERVIEW,clickedItem.getMoverview());

        startActivity(detailIntent);
    }
}