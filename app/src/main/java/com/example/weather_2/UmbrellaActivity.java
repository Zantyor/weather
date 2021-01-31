package com.example.weather_2;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class UmbrellaActivity extends AppCompatActivity {

    private ImageView mImageViewWeather;
    private Integer weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umbrella);

        mImageViewWeather = findViewById(R.id.ImageViewWeather);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void onResume() {
        super.onResume();
        String zipCode = "69110";
        getCurrentWeather(zipCode);
    }

    private void getCurrentWeather(String zipCode) {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + ",fr&appid=7b84cb6c4628843c95c6aa9723b671fb";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            weather = getWeather(response);
                            Log.d("MYINT", "value:" + weather);

                            if (weather != null) {
                                displayWeatherTips(weather);
                            } else {
                                Log.i("errortag2", "Erreur à la fin");
                                apiError();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("errortag1", "erreur à dans la réponse");
                        apiError();
                    }
                });

        queue.add(jsonObjectRequest);
    }

    private Integer getWeather(JSONObject response) throws JSONException {

        JSONObject main = response.getJSONObject("main");
        Log.i("TAG2", "Conversion de l'objet main");
        Log.d("humdityTag", main.getString("humidity"));

        return main.getInt("humidity");
    }

    private void displayWeatherTips(Integer humidity) {

        if (0 <= humidity && humidity < 30) {
            mImageViewWeather.setImageResource(R.drawable.sunglasses);
        } else if (30 <= humidity && humidity < 60) {
            mImageViewWeather.setImageResource(R.drawable.like);
        } else {
            mImageViewWeather.setImageResource(R.drawable.umbrella);
        }
    }

    private void apiError() {
        mImageViewWeather.setImageResource(R.drawable.alerte);
    }
}