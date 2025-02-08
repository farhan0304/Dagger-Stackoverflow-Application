package com.example.distackoverflowapplication.mainui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.distackoverflowapplication.Question;
import com.example.distackoverflowapplication.QuestionAdapter;
import com.example.distackoverflowapplication.QuestionItemClickListener;
import com.example.distackoverflowapplication.R;

import java.util.ArrayList;

public class RecyclerViewMVCImpl extends BaseView<RecyclerViewMVC.Listener> implements RecyclerViewMVC {

    private RecyclerView recyclerView;
    private QuestionAdapter questionAdapter;

    public RecyclerViewMVCImpl(LayoutInflater layoutInflater, ViewGroup container) {
        setRootView(layoutInflater.inflate(R.layout.activity_main,container,false));
        recyclerView = getRootView().findViewById(R.id.recyclerView);
        questionAdapter = new QuestionAdapter(new ArrayList<>());
        recyclerView.setAdapter(questionAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), new LinearLayoutManager(getContext()).getOrientation()));
        questionAdapter.setQuestionItemClickListener(new QuestionItemClickListener() {
            @Override
            public void itemClick(Question question) {
                for (RecyclerViewMVC.Listener listener : getListeners() ){
                    listener.questionClicked(question);
                }
            }
        });
    }


    @Override
    public void bindQuestions(ArrayList<Question> questions) {
        questionAdapter.updateQuestionArray(questions);
    }
}
