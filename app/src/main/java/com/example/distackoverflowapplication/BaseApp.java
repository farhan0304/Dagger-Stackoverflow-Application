package com.example.distackoverflowapplication;

import androidx.appcompat.app.AppCompatActivity;

import com.example.distackoverflowapplication.api.QuestionService;

public class BaseApp extends AppCompatActivity {

    public QuestionService getApiService(){
        return ((MyApplication) getApplication()).getCompositionRoot().getQuestionService();
    }

}
