package com.kamran.thinkdagger.dependencies;

import com.kamran.thinkdagger.service.GetUserService;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Kamran ALi on 2/5/2017.
 */


@Module
public class ApiModule {

    @Provides
    @CustomScope
    GetUserService getUserService(Retrofit retrofit){
        return retrofit.create(GetUserService.class);
    }
}
