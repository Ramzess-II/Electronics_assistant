package com.example.electronics_assistant.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.example.electronics_assistant.MainActivity;
import com.example.electronics_assistant.R;

public class SplashScreen extends AppCompatActivity {

    private final int TIME_SLEEP = 4000;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_skren);
        text = findViewById(R.id.textView_animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                text.animate().translationY(1500);
            }
        },TIME_SLEEP/2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashScreen.this, MainActivity.class);
                SplashScreen.this.startActivity(mainIntent);
                SplashScreen.this.finish();
            }
        },TIME_SLEEP);
    }
}