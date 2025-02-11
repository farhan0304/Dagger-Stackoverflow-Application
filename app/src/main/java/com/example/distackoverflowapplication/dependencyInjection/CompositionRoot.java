package com.example.distackoverflowapplication.dependencyInjection;

import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatActivity;

import com.example.distackoverflowapplication.api.Constants;
import com.example.distackoverflowapplication.api.QuestionService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CompositionRoot{

    private Retrofit retrofit;
    private QuestionService questionService;

    @UiThread
    public Retrofit getRetrofit() {
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    @UiThread
    public QuestionService getQuestionService(){
        if(questionService == null){
            questionService = getRetrofit().create(QuestionService.class);
        }
        return questionService;
    }

}
