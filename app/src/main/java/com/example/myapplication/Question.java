package com.example.myapplication;

public class Question {
    private int text;
    private boolean answer;

    public Question(int text, boolean answer) {
        this.text = text;
        this.answer = answer;
    }

    public int getText() { return text;}
    public boolean isAnswer() { return answer;}

}
