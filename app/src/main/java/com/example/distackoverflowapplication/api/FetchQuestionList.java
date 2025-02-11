package com.example.distackoverflowapplication.api;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.distackoverflowapplication.Question;
import com.example.distackoverflowapplication.Results;
import com.example.distackoverflowapplication.mainui.BaseObservable;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchQuestionList extends BaseObservable<FetchQuestionList.Listener> implements Callback<Results> {
    View view;
    QuestionService questionService;

    @Override
    public void onResponse(Call<Results> call, Response<Results> response) {
        Results res = response.body();
        if(res!=null && res.getItems()!=null){
            notifyActivity(res.getItems());

        }
    }

    private void notifyActivity(List<Question> items) {
        for (Listener listener: getListeners()){
            listener.bindQuestionFromApi(items);
        }
    }

    @Override
    public void onFailure(Call<Results> call, Throwable throwable) {
        Log.v("Error","Unable to fetch data from Api");
    }


    public interface Listener{
        void bindQuestionFromApi(List<Question> questions);
    }

    public FetchQuestionList(View view) {
        this.view = view;
        questionService = RetrofitInstance.getRetrofitInstance();
    }

    public void getQuestionList(){
        Call<Results> res = questionService.getItemsList(1,30,"stackoverflow");
        res.enqueue(this);
    }


    @Override
    public View getRootView() {
        return view;
    }

}
