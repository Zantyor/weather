package com.example.weather_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String firstName = "Côme";
    private TextView mTextViewHomeGreeting;
    private ImageView mImageViewHomeMeteoFranceLogo;
    public static String MESSAGE_KEY = "hello";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewHomeGreeting = findViewById(R.id.TextViewHomeGreeting);
        String formattedText = String.format(getString(R.string.home_greeting), firstName);
        mTextViewHomeGreeting.setText(formattedText);


        Button mButtonHomeScreen1 = findViewById(R.id.ButtonHomeScreen1);
        mButtonHomeScreen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mTextViewHomeGreeting.setTextColor(getResources().getColor(R.color.purple_200, getResources().newTheme()));
                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                intent.putExtra(MESSAGE_KEY, "hello");
                startActivity(intent);
            }
        });

        Button mButtonHomeScreen2 = findViewById(R.id.ButtonHomeScreen2);
        mButtonHomeScreen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mTextViewHomeGreeting.setTextColor(getResources().getColor(R.color.purple_200, getResources().newTheme()));
                Intent intent = new Intent(MainActivity.this, UmbrellaActivity.class);
                startActivity(intent);
            }
        });



        mImageViewHomeMeteoFranceLogo = findViewById(R.id.ImageViewHomeMeteoFranceLogo);
        mImageViewHomeMeteoFranceLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WebViewMeteoFranceActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        firstName = "Gregoire";
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        firstName = "Cedric";
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}