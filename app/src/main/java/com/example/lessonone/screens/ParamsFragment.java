package com.example.lessonone.screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;

import com.example.lessonone.R;
import com.example.lessonone.utils.ViewUtilities;

public class ParamsFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    public void onClick(View view) {

    }

    // При создании фрагмента, укажем его макет
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_params, container, false);
        return view;
    }

    // Активити создана, можно к ней обращаться. Выполним начальные действия
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        ViewUtilities.makeToast(getContext(), "onCreate");
        Log.d(TAG, "onCreate");
        Button buttonGetWeather = getActivity().findViewById(R.id.button_get_weather);
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
        });

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
