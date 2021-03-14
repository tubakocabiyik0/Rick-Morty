package com.example.nested_api.service;

import com.example.nested_api.model.ResultList;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetApi {
    @GET("episode")
    Observable<ResultList> getModel();
    //Call<ResultList> getModel();
}
