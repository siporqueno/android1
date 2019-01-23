package com.example.lessonone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double temperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView place = findViewById(R.id.PLACE);
        place.setText(R.string.city_country);

        TextView T = findViewById(R.id.T);
        temperature = -14.5;
        T.setText(getResources().getString(R.string.text_degrees, temperature));

        final TextView WType = findViewById(R.id.W_TYPE);
        WType.setText(R.string.WT);


        final Button button = findViewById(R.id.refresh_button);
         button.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 // Code here executes on main thread after user presses button
                 WType.setText(R.string.weather_update);
             }
         });


    }
}
