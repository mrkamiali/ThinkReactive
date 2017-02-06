package com.kamran.dagger.dagger2withmultipleapi.service;

import com.kamran.dagger.dagger2withmultipleapi.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetUserService {

    @GET("/users")
    Call<List<User>> getResponseList();

}