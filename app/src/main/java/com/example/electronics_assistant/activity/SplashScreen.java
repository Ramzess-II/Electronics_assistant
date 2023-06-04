package com.example.electronics_assistant.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.electronics_assistant.MainActivity;
import com.example.electronics_assistant.R;

public class SplashScreen extends AppCompatActivity {

    private final int TIME_SLEEP = 4000;
    private float alph = (float) 0.05;
    private TextView text;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_skren);
        text = findViewById(R.id.textView_animation);
        imageView = findViewById(R.id.splashIMG);

        final Handler handler1 = new Handler();
        handler1.post(new Runnable() {
            @Override
            public void run() {
                handler1.postDelayed(this, 30); // Запускаем код снова с задержкой в одну секунду
                alph += 0.02;
                imageView.setAlpha(alph);
                text.setAlpha(alph);
            }
        });

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