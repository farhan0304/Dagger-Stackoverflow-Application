package com.example.distackoverflowapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.example.distackoverflowapplication.api.FetchQuestionList;
import com.example.distackoverflowapplication.api.Repository;
import com.example.distackoverflowapplication.mainui.RecyclerViewMVC;
import com.example.distackoverflowapplication.mainui.RecyclerViewMVCImpl;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewMVC.Listener, FetchQuestionList.Listener {

    RecyclerViewMVCImpl recyclerViewMVC;
    FetchQuestionList fetchQuestionList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recyclerViewMVC = new RecyclerViewMVCImpl(LayoutInflater.from(this),null);
        setContentView(recyclerViewMVC.getRootView());

        fetchQuestionList = new FetchQuestionList(recyclerViewMVC.getRootView());

        fetchQuestionList.getQuestionList();
    }

    @Override
    protected void onStart() {
        super.onStart();
        recyclerViewMVC.addNewListener(this);
        fetchQuestionList.addNewListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        recyclerViewMVC.removeListener(this);
        fetchQuestionList.removeListener(this);
    }

    @Override
    public void questionClicked(Question question) {
        Intent i = new Intent(this,AnswerActivity.class);
        i.putExtra("QuestionId",question.getQuestion_id());
        startActivity(i);
    }

    @Override
    public void bindQuestionFromApi(List<Question> questions) {
        recyclerViewMVC.bindQuestions((ArrayList<Question>) questions);
    }
}