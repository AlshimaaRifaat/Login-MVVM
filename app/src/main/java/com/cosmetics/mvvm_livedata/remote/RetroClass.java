package com.cosmetics.mvvm_livedata.remote;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.widget.Toast;

import com.cosmetics.mvvm_livedata.model.LoginData;
import com.cosmetics.mvvm_livedata.model.LoginResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//bmsabet Presenter

public class RetroClass {



    private static final String ROOTURL ="http://omelqoura.com/api/";

    private static Retrofit getRetroInstance()
    {

        Gson gson =     new GsonBuilder().setLenient().create();

        return new Retrofit.Builder().baseUrl(ROOTURL).addConverterFactory(GsonConverterFactory.create(gson)).build();
    }



    public static APIService getAPIService()
    {

        return getRetroInstance().create(APIService.class);

    }

    public LiveData<LoginData> getTicketLiveData(String email,String password,String lang)
    {
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("email",email);
        hashMap.put("password",password);
        hashMap.put("lang","en");
        final MutableLiveData<LoginData> ticketMutableLiveData =new MutableLiveData<>();
        APIService apiService=RetroClass.getAPIService();
        apiService.getTicketJSON(hashMap).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
              if(response.isSuccessful()) {
                  LoginData tic = response.body().getData(); //.....................
                  ticketMutableLiveData.setValue(tic);
              }
                //showToast(""+response.body().toString());

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
        return  ticketMutableLiveData;
    }


}
