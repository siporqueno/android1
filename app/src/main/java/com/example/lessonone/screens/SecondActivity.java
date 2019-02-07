package com.example.lessonone.screens;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.lessonone.R;
import com.example.lessonone.utils.ViewUtilities;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = SecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ViewUtilities.makeToast(getApplicationContext(), "SECOND onCreate");
        Log.d(TAG, "SECOND onCreate");

        // Create fragment
        OutputFragment f1 = new OutputFragment();
        // getFragmentManager().beginTransaction().add(R.id.frag_output, f1).commit();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.frag_output, f1);
        ft.commit();

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
