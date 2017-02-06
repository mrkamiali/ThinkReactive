package com.kamran.dagger.dagger2withmultipleapi.dependencies;

import android.content.Context;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * Created by Kamran ALi on 2/6/2017.
 */

@Module(includes = ContextModule.class)
public class NetworkModule {

    @Provides
    @ApiCustomScope
    OkHttpClient okHttpClient(HttpLoggingInterceptor loggingInterceptor, Cache cache){
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();
    }

    @Provides
    @ApiCustomScope
    Cache cache(File cacheFile){
        return  new Cache(cacheFile,10*1000*1000);
    }

    @Provides
    @ApiCustomScope
    File cacheFile(Context context){
        return new File(context.getCacheDir(),"okhttp3 cache");
    }

    @Provides
    @ApiCustomScope
    HttpLoggingInterceptor loggingInterceptor(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return loggingInterceptor;
    }

}

