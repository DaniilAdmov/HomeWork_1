package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {
    TextView answerTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        boolean answer = getIntent().getBooleanExtra("answer", true);
        answerTextView = findViewById(R.id.answerTextView);
        answerTextView.setText(answer?"Да":"Нет");

    }
}