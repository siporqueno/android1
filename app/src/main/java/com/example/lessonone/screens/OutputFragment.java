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
    String cityName;
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

        // Changed getActivity() for getView() and added check for null

        if (getView().findViewById(R.id.place) != null) {
            TextView place = getView().findViewById(R.id.place);
            switch (city) {
                case -1:
                    cityName = getString(R.string.city_not_selected);
                    break;
                case R.id.a:
                    cityName = getString(R.string.kaz);
                    break;
                case R.id.b:
                    cityName = getString(R.string.mos);
                    break;
                case R.id.c:
                    cityName = getString(R.string.spb);
                    break;
                default:
                    cityName = getString(R.string.sth_wrong);
            }

            place.setText(cityName);

        }


        // place.setText(""+city+"\n"+R.id.a+"\n"+R.id.b+"\n"+R.id.c);

        // Changed getActivity() for getView()
        TextView t = getView().findViewById(R.id.t);
        temperature = -14.5f;
        t.setText(getResources().getString(R.string.text_degrees, temperature));

        // Changed getActivity() for getView()
        final TextView wType = getView().findViewById(R.id.w_type);
        wType.setText(R.string.weather_type);

        // Changed getActivity() for getView()
        TextView pressure2 = getView().findViewById(R.id.pressure_2);
        if (pressure) pressure2.setVisibility(View.VISIBLE);

        // Changed getActivity() for getView()
        TextView wind2 = getView().findViewById(R.id.wind_2);
        if (wind) wind2.setVisibility(View.VISIBLE);

        // Changed getActivity() for getView()
        TextView humidity2 = getView().findViewById(R.id.humidity_2);
        if (humidity) humidity2.setVisibility(View.VISIBLE);

        /*// Changed getActivity() for getView()
        Button buttonBack = getView().findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // onBackPressed();
                getActivity().finish();
                Log.d(TAG, "обработка нажатия кнопки Back");
            }
             *//*public void onClick(View v) {
                 // Code here executes on main thread after user presses button
                 wType.setText(R.string.weather_update);
             } *//*
        });*/

        // Changed getActivity() for getView()
        Button buttonDoubleCheck = getView().findViewById(R.id.button_double_check);
        buttonDoubleCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("http://yandex.ru/pogoda");
                intent.setData(uri);
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                } else
                    ViewUtilities.makeToast(getActivity().getApplicationContext(), "There is no relevant app");

                Log.d(TAG, "обработка нажатия кнопки Double check with Yandex");
            }
        });

        // Changed getActivity() for getView()
        Button buttonShare = getView().findViewById(R.id.button_share);
        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("mailto:");
                intent.setData(uri);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"a@a.a"}); // Email address
                intent.putExtra(Intent.EXTRA_SUBJECT, "Email subject"); // Email subject
                intent.putExtra(Intent.EXTRA_TEXT, "Email body"); // Email body
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                } else
                    ViewUtilities.makeToast(getActivity().getApplicationContext(), "There is no relevant app");

                Log.d(TAG, "обработка нажатия кнопки Share with friends");
            }
        });

        Button buttonGetWeatherHistory = getView().findViewById(R.id.button_temp_history);
        buttonGetWeatherHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ThirdActivity.class);
                intent.putExtra("cityName", cityName);
                startActivity(intent);
            }
        });

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
