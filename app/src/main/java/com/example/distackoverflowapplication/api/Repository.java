package com.example.distackoverflowapplication.api;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.distackoverflowapplication.Answers;
import com.example.distackoverflowapplication.Question;
import com.example.distackoverflowapplication.Result2;
import com.example.distackoverflowapplication.Results;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    QuestionService questionService;
    ArrayList<Question> questionList = new ArrayList<>();

    MutableLiveData<List<Question>> mutableLiveData = new MutableLiveData<>();

    ArrayList<Answers> answerList = new ArrayList<>();

    MutableLiveData<List<Answers>> answerLiveData = new MutableLiveData<>();
    public Repository() {

    }

    public MutableLiveData<List<Question>> getMutableLiveData() {
        questionService = RetrofitInstance.getRetrofitInstance();
        Call<Results> call = questionService.getItemsList(1,30,"stackoverflow");
        call.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                Results res = response.body();
                if(res!=null && res.getItems()!=null){
                    questionList = (ArrayList<Question>) res.getItems();
                    mutableLiveData.setValue(res.getItems());
                }
            }

            @Override
            public void onFailure(Call<Results> call, Throwable throwable) {
                Log.v("Error","Unable to fetch data from Api");
            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<List<Answers>> getAnswerLiveData(int questionId){
        questionService = RetrofitInstance.getRetrofitInstance();
        Call<Result2> call = questionService.getAnswersItemsList(questionId,"desc","activity","stackoverflow");
        call.enqueue(new Callback<Result2>() {
            @Override
            public void onResponse(Call<Result2> call, Response<Result2> response) {
                Result2 res = response.body();
                if(res!=null && res.getItems()!=null && res.getItems().size()!=0){
                    answerList = (ArrayList<Answers>) res.getItems();
                    answerLiveData.setValue(res.getItems());
                }else{
                    answerList.add(new Answers(false,0,"default license"));
                    answerLiveData.setValue(answerList);
                }
            }

            @Override
            public void onFailure(Call<Result2> call, Throwable throwable) {
                Log.v("APIERROR","Unable to fetch Answer");
            }
        });
        return answerLiveData;
    }
}
