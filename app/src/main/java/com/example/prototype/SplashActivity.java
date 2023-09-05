package com.example.prototype;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.prototype.resultcalculator.MainActivity;

public class SplashActivity extends AppCompatActivity {
    View rootView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rootView = findViewById(android.R.id.content);
        intent = new Intent(SplashActivity.this, SFD_BMD_Activity.class);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        }, 1000);

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Remove the pending delayed start of the activity
                handler.removeCallbacksAndMessages(null);
                // Optionally, you can also disable the click listener on rootView to prevent further clicks
                rootView.setOnClickListener(null);

                // Start the activity
                startActivity(intent);
                finish();
            }
        });
    }
}
