package com.example.distackoverflowapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuestionBody {

    @SerializedName("title")
    @Expose
    String title;


    @SerializedName("body")
    @Expose
    String questionBody;

    public QuestionBody() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestionBody() {
        return questionBody;
    }

    public void setQuestionBody(String questionBody) {
        this.questionBody = questionBody;
    }

    public QuestionBody(String title, String questionBody) {
        this.title = title;
        this.questionBody = questionBody;
    }
}
