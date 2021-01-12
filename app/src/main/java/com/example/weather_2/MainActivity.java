package com.example.weather_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String firstName = "Julian";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView mTextViewHomeGreeting = (TextView)findViewById(R.id.TextViewHomeGreeting);
        String formattedText = String.format(getString(R.string.home_greeting), firstName);
        mTextViewHomeGreeting.setText(formattedText);

    }

}