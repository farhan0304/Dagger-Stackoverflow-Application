package com.example.distackoverflowapplication.model;

import com.example.distackoverflowapplication.model.QuestionBody;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result2 {

    @SerializedName("items")
    @Expose
    List<QuestionBody> items;

    public Result2() {
    }

    public List<QuestionBody> getItems() {
        return items;
    }

    public void setItems(List<QuestionBody> items) {
        this.items = items;
    }
}
