package com.kamran.dagger.dagger2retrofit2practice.dependencies;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.kamran.dagger.dagger2retrofit2practice.utils.Constants;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by Kamran ALi on 2/15/2017.
 */
@Module(includes = ContextModule.class)
public class NetworkModule {

    @Provides
    Retrofit retrofit(OkHttpClient okHttpClient
            , RxJava2CallAdapterFactory rxJava2CallAdapterFactory
            , GsonConverterFactory gsonConverterFactory) {

        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .addConverterFactory(gsonConverterFactory)
                .client(okHttpClient)
                .build();

    }

    @Provides
    RxJava2CallAdapterFactory rxJava2CallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    GsonConverterFactory gsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    //okhttpCLient
    @Provides
    OkHttpClient okHttpClient(HttpLoggingInterceptor loggingInterceptor, Cache cache) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();
        return okHttpClient;
    }

    //HttpLoggingInterceptor
    @Provides
    HttpLoggingInterceptor loggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        });
        return loggingInterceptor;
    }

    //Cache
    @Provides
    Cache cache(File cacheFile) {
        Cache cache = new Cache(cacheFile, 10 * 1000 * 1000); //10mb
        return cache;
    }

    //FILE
    @Provides
    File cacheFile(Context context) {
        File cacheFile = new File(context.getCacheDir(), "okhttpCache");
        cacheFile.mkdir();
        return cacheFile;
    }

}

