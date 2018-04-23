package com.example.android.testproject;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);
        textView.setText("Wow!");
        textView.setAllCaps(true);
        textView.setTextColor(Color.parseColor("#AFEEEE"));
        textView.setBackgroundColor(Color.BLACK);
        textView.setTextSize(50);

        setContentView(textView);
    }
}
