package com.example.distackoverflowapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.distackoverflowapplication.api.FetchQuestionBody;
import com.example.distackoverflowapplication.api.QuestionService;
import com.example.distackoverflowapplication.model.QuestionBody;
import com.example.distackoverflowapplication.secondactivity.QuestionDetailActivityMvc;

import java.util.ArrayList;
import java.util.List;

public class AnswerActivity extends BaseApp implements FetchQuestionBody.Listener {

    QuestionDetailActivityMvc questionDetailActivityMvc;
    FetchQuestionBody fetchQuestionBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        questionDetailActivityMvc = new QuestionDetailActivityMvc(LayoutInflater.from(this),null);
        setContentView(questionDetailActivityMvc.getRootView());

        //Making Retrofit Global
        QuestionService questionService = getApiService();

        fetchQuestionBody = new FetchQuestionBody(questionDetailActivityMvc.getRootView(),questionService);

        int quesId = getIntent().getIntExtra("QuestionId",0);

        fetchQuestionBody.getQuestionBody(quesId);
        

    }

    @Override
    protected void onStart() {
        super.onStart();
        fetchQuestionBody.addNewListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        fetchQuestionBody.removeListener(this);
    }

    @Override
    public void bindQuestionBodyFromApi(List<QuestionBody> questionBodies) {
        questionDetailActivityMvc.bindQuestionBody((ArrayList<QuestionBody>) questionBodies);
    }
}