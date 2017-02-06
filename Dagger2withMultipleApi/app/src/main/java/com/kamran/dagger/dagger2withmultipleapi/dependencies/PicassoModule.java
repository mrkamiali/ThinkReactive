package com.kamran.dagger.dagger2withmultipleapi.dependencies;

import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by Kamran ALi on 2/6/2017.
 */

@Module(includes = {ContextModule.class,NetworkModule.class})
public class PicassoModule {

    @Provides
    @ApiCustomScope
    Picasso picasso(Context context,OkHttp3Downloader okHttp3Downloader) {
        return new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build();
    }

    @Provides
    @ApiCustomScope
    OkHttp3Downloader okHttp3Downloader(OkHttpClient okHttpClient){
        return new OkHttp3Downloader(okHttpClient);
    }
}

