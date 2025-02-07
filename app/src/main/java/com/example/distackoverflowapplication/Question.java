package com.example.distackoverflowapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Question {

    @SerializedName("question_id")
    @Expose
    int question_id;

    @SerializedName("title")
    @Expose
    String title;

    @SerializedName("is_answered")
    @Expose
    boolean isAnswered;

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }

    public Question() {

    }

    public Question(int question_id, String title) {
        this.question_id = question_id;
        this.title = title;
    }


    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
