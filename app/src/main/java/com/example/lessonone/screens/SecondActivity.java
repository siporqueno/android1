package com.example.lessonone.screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lessonone.R;
import com.example.lessonone.utils.ViewUtilities;

public class SecondActivity extends AppCompatActivity {

    double temperature;
    int city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ViewUtilities.makeToast(getApplicationContext(), "SECOND onCreate");
        Intent intent = getIntent();
        int city = intent.getIntExtra("city",-1);
        boolean pressure = intent.getBooleanExtra("pressure", false);
        boolean wind = intent.getBooleanExtra("wind", false);
        boolean humidity = intent.getBooleanExtra("humidity", false);

        TextView place = findViewById(R.id.place);

        city = city - 3*(int) (city/3);
        switch (city) {
            case -1: place.setText("City is not selected"); break;
            case 0: place.setText(R.string.spb); break;
            case 1: place.setText(R.string.kaz); break;
            case 2: place.setText(R.string.mos); break;
            default: place.setText("Something went wrong "+city);
        }
        // place.setText(""+city);

        TextView T = findViewById(R.id.T);
        temperature = -14.5;
        T.setText(getResources().getString(R.string.text_degrees, temperature));

        final TextView WType = findViewById(R.id.W_TYPE);
        WType.setText(R.string.WT);

        TextView pr2 = findViewById(R.id.PR2);
        if (pressure) pr2.setVisibility(View.VISIBLE);

        TextView wd2 = findViewById(R.id.WD2);
        if (wind) wd2.setVisibility(View.VISIBLE);

        TextView hm2 = findViewById(R.id.HM2);
        if (humidity) hm2.setVisibility(View.VISIBLE);

        Button button2 = findViewById(R.id.back_button);
        button2.setOnClickListener(new View.OnClickListener() {
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

    @Override
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
    }
}
