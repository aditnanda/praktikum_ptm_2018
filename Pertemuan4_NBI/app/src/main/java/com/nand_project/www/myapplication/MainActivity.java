package com.nand_project.www.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView myrv;
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter myAdapter;

    ArrayList<Data> lstData;

    JsonArrayRequest ArrayRequest;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myrv = findViewById(R.id.recyclerview);
        lstData = new ArrayList<>();

        initData();


    }

    private void initData() {
        String url ="http://ptmdaskom.nand-project.com/contoh_sederhana.php";
        ArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;

                for (int i = 0; i<response.length(); i++){
                    try {
                        jsonObject = response.getJSONObject(i);
                        Data modal = new Data();
                        modal.setNama(jsonObject.getString("nama"));
                        modal.setMobile(jsonObject.getString("mobile"));

                        lstData.add(modal);
                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }
                setRvAdapter(lstData);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(ArrayRequest);
    }

    private void setRvAdapter(ArrayList<Data> lst) {
        myAdapter = new RecyclerViewAdapter(MainActivity.this,lst);
        layoutManager = new LinearLayoutManager(this);
        myrv.setLayoutManager(layoutManager);
        myrv.setAdapter(myAdapter);
    }
}
