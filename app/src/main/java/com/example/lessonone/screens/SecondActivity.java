package com.example.lessonone.screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lessonone.R;

public class SecondActivity extends AppCompatActivity {

    double temperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // ViewUtilities.makeToast(getApplicationContext(), "SECOND onCreate");
        Intent intent = getIntent();
        int city = intent.getIntExtra("city",-1);
        boolean pressure = intent.getBooleanExtra("pressure", false);
        boolean wind = intent.getBooleanExtra("wind", false);
        boolean humidity = intent.getBooleanExtra("humidity", false);

        TextView place = findViewById(R.id.place);

        // city = city - 3*(int) (city/3);

        switch (city) {
            case -1: place.setText("City is not selected"+city); break;
            case R.id.a: place.setText(R.string.kaz); break;
            case R.id.b: place.setText(R.string.mos); break;
            case R.id.c: place.setText(R.string.spb); break;
            default: place.setText("Something went wrong "+city);
        }

        // place.setText(""+city+"\n"+R.id.a+"\n"+R.id.b+"\n"+R.id.c);

        TextView T = findViewById(R.id.T);
        temperature = -14.5;
        T.setText(getResources().getString(R.string.text_degrees, temperature));

        final TextView WType = findViewById(R.id.W_TYPE);
        WType.setText(R.string.WT);

        TextView pressure2 = findViewById(R.id.pressure_2);
        if (pressure) pressure2.setVisibility(View.VISIBLE);

        TextView wind2 = findViewById(R.id.wind_2);
        if (wind) wind2.setVisibility(View.VISIBLE);

        TextView humidity2 = findViewById(R.id.humidity_2);
        if (humidity) humidity2.setVisibility(View.VISIBLE);

        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent2);
            }
            /* public void onClick(View v) {
                 // Code here executes on main thread after user presses button
                 WType.setText(R.string.weather_update);
             } */
         });

    }

    /* @Override
    protected void onStart() {
        super.onStart();
        ViewUtilities.makeToast(getApplicationContext(), "SECOND onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        ViewUtilities.makeToast(getApplicationContext(), "SECOND onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        ViewUtilities.makeToast(getApplicationContext(), "SECOND onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        ViewUtilities.makeToast(getApplicationContext(), "SECOND onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ViewUtilities.makeToast(getApplicationContext(), "SECOND onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        ViewUtilities.makeToast(getApplicationContext(), "SECOND onRestart");
    } */
}
