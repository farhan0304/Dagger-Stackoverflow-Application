package com.example.distackoverflowapplication.api;

import com.example.distackoverflowapplication.Result2;
import com.example.distackoverflowapplication.Results;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface QuestionService {

    @GET("2.3/questions")
    Call<Results> getItemsList(@Query("page") int page, @Query("pagesize") int pageSize, @Query("site") String site);

    @GET("2.3/questions/{id}?site=stackoverflow&filter=withbody")
    Call<Result2> getAnswersItemsList(@Path("id") int id);
}
