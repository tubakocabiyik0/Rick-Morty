package com.example.nested_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.TextView;

import com.example.nested_api.adapter.AdapterC;
import com.example.nested_api.model.ResultList;
import com.example.nested_api.model.Results;
import com.example.nested_api.service.GetApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    GetApi getApi;
    RecyclerView recyclerView;
    List<Results> resultLists;
    AdapterC adapterC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())//Use Gson
                .build();
        getApi = retrofit.create(GetApi.class);
        recyclerView = findViewById(R.id.re);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        resultLists = new ArrayList<>();
        loadData();
    }

    private void loadData() {
        Call<ResultList> call = getApi.getModel();
        call.enqueue(new Callback<ResultList>() {
            @Override
            public void onResponse(Call<ResultList> call, Response<ResultList> response) {
                if (response.isSuccessful()) {
                    List<Results> lists;
                    lists = (List<Results>) response.body().getResults();
                    resultLists = lists;
                    adapterC = new AdapterC(resultLists,MainActivity.this);
                    recyclerView.setAdapter(adapterC);
                    adapterC.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<ResultList> call, Throwable t) {

            }
        });


    }
}