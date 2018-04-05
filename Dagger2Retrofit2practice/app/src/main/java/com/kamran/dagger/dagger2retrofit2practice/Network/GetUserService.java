package com.kamran.dagger.dagger2retrofit2practice.Network;

import com.kamran.dagger.dagger2retrofit2practice.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Kamran ALi on 2/8/2017.
 */

public interface GetUserService {

    @GET("/users")
    Call<List<User>> getUserListResponse();
}
