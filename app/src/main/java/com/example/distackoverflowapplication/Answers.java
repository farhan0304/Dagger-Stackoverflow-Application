package com.example.distackoverflowapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Answers {

    @SerializedName("title")
    @Expose
    String title;


    @SerializedName("body")
    @Expose
    String questionBody;

    public Answers() {
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

    public Answers(String title, String questionBody) {
        this.title = title;
        this.questionBody = questionBody;
    }
}
