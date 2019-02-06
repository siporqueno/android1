package com.example.lessonone.screens;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.lessonone.R;
import com.example.lessonone.utils.ViewUtilities;

// import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtilities.makeToast(getApplicationContext(), "onCreate");
        Log.d(TAG, "onCreate");
        /*
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
                Log.d(TAG, "обработка нажатия кнопки Get Weather");
            }
        });
        */

        // service.setText(""+R.id.a+"\n"+R.id.b+"\n"+R.id.c);

    }

    @Override
    protected void onStart() {
        super.onStart();
        ViewUtilities.makeToast(getApplicationContext(), "onStart");
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        ViewUtilities.makeToast(getApplicationContext(), "onResume");
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        ViewUtilities.makeToast(getApplicationContext(), "onPause");
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        ViewUtilities.makeToast(getApplicationContext(), "onStop");
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ViewUtilities.makeToast(getApplicationContext(), "onDestroy");
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        ViewUtilities.makeToast(getApplicationContext(), "onRestart");
        Log.d(TAG, "onRestart");
    }
}
