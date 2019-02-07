package com.example.lessonone.screens;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.lessonone.R;
import com.example.lessonone.utils.ViewUtilities;

public class OutputFragment extends Fragment implements View.OnClickListener {

    float temperature;
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    public void onClick(View view) {

    }

    // При создании фрагмента, укажем его макет
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_output, container, false);
        return view;
    }

    // Активити создана, можно к ней обращаться. Выполним начальные действия
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        ViewUtilities.makeToast(getContext(), "onCreate");
        Log.d(TAG, "onCreate");

        Intent intent = getActivity().getIntent();
        int city = intent.getIntExtra("city", -1);
        boolean pressure = intent.getBooleanExtra("pressure", false);
        boolean wind = intent.getBooleanExtra("wind", false);
        boolean humidity = intent.getBooleanExtra("humidity", false);

        TextView place = getActivity().findViewById(R.id.place);

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

        TextView t = getActivity().findViewById(R.id.t);
        temperature = -14.5f;
        t.setText(getResources().getString(R.string.text_degrees, temperature));

        final TextView wType = getActivity().findViewById(R.id.w_type);
        wType.setText(R.string.weather_type);

        TextView pressure2 = getActivity().findViewById(R.id.pressure_2);
        if (pressure) pressure2.setVisibility(View.VISIBLE);

        TextView wind2 = getActivity().findViewById(R.id.wind_2);
        if (wind) wind2.setVisibility(View.VISIBLE);

        TextView humidity2 = getActivity().findViewById(R.id.humidity_2);
        if (humidity) humidity2.setVisibility(View.VISIBLE);

        Button buttonBack = getActivity().findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // onBackPressed();
                getActivity().finish();
                Log.d(TAG, "обработка нажатия кнопки Back");
            }
            /* public void onClick(View v) {
                 // Code here executes on main thread after user presses button
                 wType.setText(R.string.weather_update);
             } */
        });

        Button buttonDoubleCheck = getActivity().findViewById(R.id.button_double_check);
        buttonDoubleCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("http://yandex.ru/pogoda");
                intent.setData(uri);
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                } else ViewUtilities.makeToast(getActivity().getApplicationContext(), "There is no relevant app");

                Log.d(TAG, "обработка нажатия кнопки Double check with Yandex");
            }
        });

        Button buttonShare = getActivity().findViewById(R.id.button_share);
        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(Intent.ACTION_VIEW);
                //Uri uri = Uri.parse("http://yandex.ru/pogoda");
                Uri uri = Uri.parse("mailto:");
                intent.setData(uri);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"a@a.a"}); // Email address
                intent.putExtra(Intent.EXTRA_SUBJECT, "Email subject"); // Email subject
                intent.putExtra(Intent.EXTRA_TEXT, "Email body"); // Email body
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                } else ViewUtilities.makeToast(getActivity().getApplicationContext(), "There is no relevant app");

                Log.d(TAG, "обработка нажатия кнопки Share with friends");
            }
        });

        /* Button buttonGetWeather = getActivity().findViewById(R.id.button_get_weather);
        final RadioGroup radioGroupCity = getActivity().findViewById(R.id.radio_group_city);
        final CheckBox checkboxPressure = getActivity().findViewById(R.id.checkbox_pressure);
        final CheckBox checkboxWind = getActivity().findViewById(R.id.checkbox_wind);
        final CheckBox checkboxHumidity = getActivity().findViewById(R.id.checkbox_humidity);
        // TextView service = findViewById(R.id.service);

        buttonGetWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                intent.putExtra("city", radioGroupCity.getCheckedRadioButtonId());
                intent.putExtra("pressure", checkboxPressure.isChecked());
                intent.putExtra("wind", checkboxWind.isChecked());
                intent.putExtra("humidity", checkboxHumidity.isChecked());
                startActivity(intent);
                Log.d(TAG, "обработка нажатия кнопки Get Weather");
            }
        }); */

        // service.setText(""+R.id.a+"\n"+R.id.b+"\n"+R.id.c);

    }


    @Override
    public void onStart() {
        super.onStart();
        ViewUtilities.makeToast(getContext(), "onStart");
        Log.d(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        ViewUtilities.makeToast(getContext(), "onResume");
        Log.d(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        ViewUtilities.makeToast(getContext(), "onPause");
        Log.d(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        ViewUtilities.makeToast(getContext(), "onStop");
        Log.d(TAG, "onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ViewUtilities.makeToast(getContext(), "onDestroy");
        Log.d(TAG, "onDestroy");
    }

}