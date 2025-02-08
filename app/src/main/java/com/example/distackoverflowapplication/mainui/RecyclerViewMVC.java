package com.example.distackoverflowapplication.mainui;

import com.example.distackoverflowapplication.Question;

import java.util.ArrayList;

public interface RecyclerViewMVC extends ViewListener<RecyclerViewMVC.Listener>{
    public interface Listener{
        void questionClicked(Question question);
    }

    void bindQuestions(ArrayList<Question> questions);

}
