package com.lilbro.rickyapitest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String URL = "https://rickandmortyapi.com/api/character";
    private List<Character> listCharacter;
    private characterAdapter adapter;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listCharacter = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerV);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray characters = response.getJSONArray("results");
                    Toast.makeText(MainActivity.this,characters.getJSONObject(0).getString("name") , Toast.LENGTH_LONG).show();
                    for(int i=0; i<characters.length(); i++){
                        listCharacter.add(new Character(
                                characters.getJSONObject(0).getString("name"),
                                characters.getJSONObject(0).getString("status"),
                                characters.getJSONObject(0).getString("species"),
                                characters.getJSONObject(0).getString("gender"),
                                characters.getJSONObject(0).getString("image")
                        ));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                adapter = new characterAdapter(listCharacter);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Erreur chargement API "+error.toString(), Toast.LENGTH_LONG).show();
                    }
                }

        );

        requestQueue.add(objectRequest);
    }
}
