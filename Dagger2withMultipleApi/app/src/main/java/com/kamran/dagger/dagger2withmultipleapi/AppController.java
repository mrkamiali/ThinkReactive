package com.kamran.dagger.dagger2withmultipleapi;

import android.app.Activity;
import android.app.Application;

import com.kamran.dagger.dagger2withmultipleapi.dependencies.ApiComponent;
import com.kamran.dagger.dagger2withmultipleapi.dependencies.ContextModule;
import com.kamran.dagger.dagger2withmultipleapi.dependencies.DaggerApiComponent;
import com.kamran.dagger.dagger2withmultipleapi.service.GetUserService;
import com.squareup.picasso.Picasso;

import timber.log.Timber;


/**
 * Created by Kamran ALi on 2/6/2017.
 */

public class AppController extends Application {

    private GetUserService getUserService;
    private Picasso picasso;
    private ApiComponent apiComponent;


    public static AppController get(Activity activity) {
        return (AppController) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());
        resolveDependencies();



    }

    private void resolveDependencies() {
        apiComponent = DaggerApiComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    public ApiComponent getApiComponent() {
        return apiComponent;
    }

    public GetUserService getUserService() {
        return getUserService;
    }

    public Picasso getPicasso() {
        return picasso;
    }
}
