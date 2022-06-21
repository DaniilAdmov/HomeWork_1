package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {


    Button yesBtn;
    Button noBtn;
    Button result;
    TextView askTextView;
    Button answerBtn;
    Question[] questions = {
            new Question(R.string.question1, true),
            new Question(R.string.question2, false),
            new Question(R.string.question3, true),
            new Question(R.string.question4, true),
            new Question(R.string.question5, true)
    };

    LinkedList resultArray = new LinkedList();

    int questionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yesBtn = findViewById(R.id.yesBtn);
        noBtn = findViewById(R.id.noBtn);
        askTextView = findViewById(R.id.askTextView);
        answerBtn = findViewById(R.id.answerBtn);
        askTextView.setText(questions[questionIndex].getText());


        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(questions[questionIndex].isAnswer());
            }
        });
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(!questions[questionIndex].isAnswer());
            }

        });


        answerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnswerActivity.class);
                intent.putExtra("answer", questions[questionIndex].isAnswer());
                startActivity(intent);
            }
        });

    }


    private void checkAnswer(boolean isAnswer) {


        if (isAnswer) {
            Toast.makeText(MainActivity.this, "Правильно!", Toast.LENGTH_SHORT).show();
            resultArray.add(questions[questionIndex].getText() + "Ваш ответ - " + questions[questionIndex].isAnswer() + "  Правильный ответ - ДА");
        } else {
            Toast.makeText(MainActivity.this, "Неправильно!", Toast.LENGTH_SHORT).show();
            resultArray.add(questions[questionIndex].getText() + "Ваш ответ - " + questions[questionIndex].isAnswer() + "  Правильный ответ - НЕТ");
        }


        questionIndex = (questionIndex + 1) % questions.length;
        askTextView.setText(questions[questionIndex].getText());
        if (resultArray.size() == questions.length) {
            Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
            intent.putExtra("result", resultArray);
            startActivity(intent);


        }


    }
}

