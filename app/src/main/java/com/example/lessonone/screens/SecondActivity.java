package com.example.lessonone.screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lessonone.R;
import com.example.lessonone.utils.ViewUtilities;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = SecondActivity.class.getSimpleName();

    float temperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ViewUtilities.makeToast(getApplicationContext(), "SECOND onCreate");
        Log.d(TAG, "SECOND onCreate");
        Intent intent = getIntent();
        int city = intent.getIntExtra("city", -1);
        boolean pressure = intent.getBooleanExtra("pressure", false);
        boolean wind = intent.getBooleanExtra("wind", false);
        boolean humidity = intent.getBooleanExtra("humidity", false);

        TextView place = findViewById(R.id.place);

        // city = city - 3*(int) (city/3);

        switch (city) {
            case -1:
                place.setText(getString(R.string.city_not_selected) /*+ city*/);
                break;
            case R.id.a:
                place.setText(R.string.kaz);
                break;
            case R.id.b:
                place.setText(R.string.mos);
                break;
            case R.id.c:
                place.setText(R.string.spb);
                break;
            default:
                place.setText("Something went wrong " + city);
        }

        // place.setText(""+city+"\n"+R.id.a+"\n"+R.id.b+"\n"+R.id.c);

        TextView t = findViewById(R.id.t);
        temperature = -14.5f;
        t.setText(getResources().getString(R.string.text_degrees, temperature));

        final TextView wType = findViewById(R.id.w_type);
        wType.setText(R.string.weather_type);

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
                // onBackPressed();
                finish();
                Log.d(TAG, "обработка нажатия кнопки Back");
            }
            /* public void onClick(View v) {
                 // Code here executes on main thread after user presses button
                 wType.setText(R.string.weather_update);
             } */
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        ViewUtilities.makeToast(getApplicationContext(), "SECOND onStart");
        Log.d(TAG, "SECOND onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        ViewUtilities.makeToast(getApplicationContext(), "SECOND onResume");
        Log.d(TAG, "SECOND onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        ViewUtilities.makeToast(getApplicationContext(), "SECOND onPause");
        Log.d(TAG, "SECOND onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        ViewUtilities.makeToast(getApplicationContext(), "SECOND onStop");
        Log.d(TAG, "SECOND onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ViewUtilities.makeToast(getApplicationContext(), "SECOND onDestroy");
        Log.d(TAG, "SECOND onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        ViewUtilities.makeToast(getApplicationContext(), "SECOND onRestart");
        Log.d(TAG, "SECOND onRestart");
    }
}
