package com.kamran.dagger.dagger2retrofit2practice.dependencies;

import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by Kamran ALi on 2/15/2017.
 */
@Module(includes = {NetworkModule.class, ContextModule.class})
public class PicassoServiceModule {


    //Picasso
    @Provides
    @CustomScope
    Picasso picasso(Context context, OkHttpClient okHttpClient, OkHttp3Downloader okHttp3Downloader) {
        Picasso picasso = new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build();
        return picasso;
    }

    @Provides
    @CustomScope
    OkHttp3Downloader okHttp3Downloader(OkHttpClient okHttpClient) {
        return new OkHttp3Downloader(okHttpClient);
    }
}

