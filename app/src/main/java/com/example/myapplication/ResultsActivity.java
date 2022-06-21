package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        ArrayList<String> arrayResult = (ArrayList<String>) getIntent().getSerializableExtra("result");

       textView = findViewById(R.id.resultAnswerView);
        textView.setText(arrayResult.toString());


    }
}