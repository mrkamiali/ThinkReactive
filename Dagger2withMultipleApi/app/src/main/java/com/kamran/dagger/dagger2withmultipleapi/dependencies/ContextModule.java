package com.kamran.dagger.dagger2withmultipleapi.dependencies;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Kamran ALi on 2/6/2017.
 */

@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApiCustomScope
    Context context(){
        return context;
    }
}

