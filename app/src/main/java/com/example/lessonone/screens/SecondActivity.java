package com.example.lessonone.screens;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

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
        f1.setArguments(getIntent().getExtras());
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        // Changed add for replace to avoid overlapping of previous and current fragments
        ft.replace(R.id.frag_output, f1);
        ft.commit();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
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
