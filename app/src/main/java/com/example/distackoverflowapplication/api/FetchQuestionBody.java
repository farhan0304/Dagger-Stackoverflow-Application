package com.example.distackoverflowapplication.api;

import android.util.Log;
import android.view.View;

import com.example.distackoverflowapplication.model.QuestionBody;
import com.example.distackoverflowapplication.model.Result2;
import com.example.distackoverflowapplication.mainui.BaseObservable;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FetchQuestionBody extends BaseObservable<FetchQuestionBody.Listener>  implements Callback<Result2> {

    View view;
    QuestionService questionService;

    @Override
    public View getRootView() {
        return view;
    }

    @Override
    public void onResponse(Call<Result2> call, Response<Result2> response) {
        Result2 res = response.body();
        if(res!=null && res.getItems()!=null){
            notifyActivity(res.getItems());

        }
    }

    private void notifyActivity(List<QuestionBody> items) {
        for (Listener listener: getListeners()){
            listener.bindQuestionBodyFromApi(items);
        }
    }

    @Override
    public void onFailure(Call<Result2> call, Throwable throwable) {
        Log.v("Error","Unable to fetch data from Api");

    }

    public interface Listener{
        void bindQuestionBodyFromApi(List<QuestionBody> questionBodies);
    }

    public FetchQuestionBody(View view,QuestionService questionService) {
        this.view = view;
        this.questionService = questionService;
    }

    public void getQuestionBody(int questionId){
        Call<Result2> call = questionService.getAnswersItemsList(questionId);
        call.enqueue(this);
    }

}
