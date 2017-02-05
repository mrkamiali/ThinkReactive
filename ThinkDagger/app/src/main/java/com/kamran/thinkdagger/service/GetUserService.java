package com.kamran.thinkdagger.service;

import com.kamran.thinkdagger.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetUserService {

    @GET("/users")
    Call<List<User>> getResponse();

}