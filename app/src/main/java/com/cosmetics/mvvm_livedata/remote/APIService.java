package com.cosmetics.mvvm_livedata.remote;

import com.cosmetics.mvvm_livedata.model.LoginData;
import com.cosmetics.mvvm_livedata.model.LoginResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {
    @POST("login")
    Call<LoginResponse> getTicketJSON(@Body Map<String,String> map);
}
