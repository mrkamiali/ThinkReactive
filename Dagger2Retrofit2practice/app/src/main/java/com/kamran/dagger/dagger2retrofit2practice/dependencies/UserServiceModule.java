package com.kamran.dagger.dagger2retrofit2practice.dependencies;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.kamran.dagger.dagger2retrofit2practice.Network.GetUserService;
import com.kamran.dagger.dagger2retrofit2practice.utils.Constants;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kamran ALi on 2/15/2017.
 */

@Module
public class UserServiceModule {

    @Provides
    @CustomScope
    GetUserService getUserService (Retrofit retrofit){
        return retrofit.create(GetUserService.class);
    }

    @Provides
    @CustomScope
    Retrofit retrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

}

