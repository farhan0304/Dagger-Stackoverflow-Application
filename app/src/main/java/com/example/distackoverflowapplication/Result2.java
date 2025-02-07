package com.example.distackoverflowapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result2 {

    @SerializedName("items")
    @Expose
    List<Answers> items;

    public Result2() {
    }

    public List<Answers> getItems() {
        return items;
    }

    public void setItems(List<Answers> items) {
        this.items = items;
    }
}
