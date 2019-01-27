package com.example.lessonone.screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;

import com.example.lessonone.R;
import com.example.lessonone.utils.ViewUtilities;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtilities.makeToast(getApplicationContext(), "onCreate");
        Button buttonGetWeather = findViewById(R.id.button_get_weather);
        final RadioGroup radioGroupCity = findViewById(R.id.radio_group_city);
        final CheckBox checkboxPressure = findViewById(R.id.checkbox_pressure);
        final CheckBox checkboxWind = findViewById(R.id.checkbox_wind);
        final CheckBox checkboxHumidity = findViewById(R.id.checkbox_humidity);
        // TextView service = findViewById(R.id.service);

        buttonGetWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("city", radioGroupCity.getCheckedRadioButtonId());
                intent.putExtra("pressure", checkboxPressure.isChecked());
                intent.putExtra("wind", checkboxWind.isChecked());
                intent.putExtra("humidity", checkboxHumidity.isChecked());
                startActivity(intent);
            }
        });

        // service.setText(""+radioGroupCity.getCheckedRadioButtonId());

    }

    @Override
    protected void onStart() {
        super.onStart();
        ViewUtilities.makeToast(getApplicationContext(), "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        ViewUtilities.makeToast(getApplicationContext(), "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        ViewUtilities.makeToast(getApplicationContext(), "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        ViewUtilities.makeToast(getApplicationContext(), "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ViewUtilities.makeToast(getApplicationContext(), "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        ViewUtilities.makeToast(getApplicationContext(), "onRestart");
    }
}
