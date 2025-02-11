package com.example.distackoverflowapplication.model;

import com.example.distackoverflowapplication.model.Question;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Results {

    @SerializedName("items")
    @Expose
    List<Question> items;

    public List<Question> getItems() {
        return items;
    }

    public void setItems(List<Question> items) {
        this.items = items;
    }

    public Results() {
    }
}
