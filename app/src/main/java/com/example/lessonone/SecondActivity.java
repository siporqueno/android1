package com.example.lessonone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    double temperature;
    int city=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        int city = intent.getIntExtra("city",-1);
        boolean pressure = intent.getBooleanExtra("pressure", false);
        boolean wind = intent.getBooleanExtra("wind", false);
        boolean humidity = intent.getBooleanExtra("humidity", false);

        TextView place = findViewById(R.id.PLACE);
        switch (city) {
            case -1: place.setText(""+city+"City is not selected"); break;
            case 1: place.setText(R.string.kaz); break;
            case 2: place.setText(R.string.mos); break;
            case 3: place.setText(R.string.spb); break;
            default: place.setText("Something went wrong"+city);
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
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivityForResult(intent,0);
            }
            /* public void onClick(View v) {
                 // Code here executes on main thread after user presses button
                 WType.setText(R.string.weather_update);
             } */
         });

    }
}
