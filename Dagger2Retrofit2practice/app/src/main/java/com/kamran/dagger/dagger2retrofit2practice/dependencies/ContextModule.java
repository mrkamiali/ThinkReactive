package com.kamran.dagger.dagger2retrofit2practice.dependencies;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Kamran ALi on 2/15/2017.
 */
@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    Context context() {
        return context;
    }
}
