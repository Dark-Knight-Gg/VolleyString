package com.example.volleystringrequest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        String url = "https://khoapham.vn/KhoaPhamTraining/json/tien/demo1.json";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String monhoc = response.getString("monhoc");
                            String noihoc = response.getString("noihoc");
                            String website = response.getString("website");
                            String fanpage = response.getString("fanpage");
                            Toast.makeText(MainActivity.this, "Môn học: "+monhoc+"\n"+"Nơi học: "+noihoc+"\nWebsite: "+website+"\nFanpage: "+fanpage, Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Lỗi!", Toast.LENGTH_SHORT).show();
                        Log.d("AAA","Lỗi\n"+error);
                    }
                });
        requestQueue.add(jsonObjectRequest);
    }
}