package com.example.lessonone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        final RadioGroup rgr = findViewById(R.id.RGR);
        final CheckBox pr = findViewById(R.id.PR);
        final CheckBox wd = findViewById(R.id.WD);
        final CheckBox hm = findViewById(R.id.HM);
        rgr.clearCheck();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("city", rgr.getCheckedRadioButtonId());
                intent.putExtra("pressure", pr.isChecked());
                intent.putExtra("wind", wd.isChecked());
                intent.putExtra("humidity", hm.isChecked());
                startActivity(intent);
            }
        });

    }
}
