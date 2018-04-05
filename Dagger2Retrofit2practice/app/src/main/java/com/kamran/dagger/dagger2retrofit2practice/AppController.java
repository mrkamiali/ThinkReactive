package com.kamran.dagger.dagger2retrofit2practice;

import android.app.Activity;
import android.app.Application;

import com.kamran.dagger.dagger2retrofit2practice.Network.GetUserService;
import com.kamran.dagger.dagger2retrofit2practice.dependencies.ContextModule;
import com.kamran.dagger.dagger2retrofit2practice.dependencies.UserServiceComponent;
import com.kamran.dagger.dagger2retrofit2practice.dependencies.NetworkComponent;
import com.squareup.picasso.Picasso;

import timber.log.Timber;

/**
 * Created by Kamran ALi on 2/8/2017.
 */

public class AppController extends Application {

    private GetUserService getUserService;
    private Picasso picasso;

    private UserServiceComponent userServiceComponent;

    public static AppController get(Activity activity) {
        return (AppController) activity.getApplication();
    }

    @Override
    public void onCreate() {
        resolveDependenices();
        super.onCreate();

        //Activity
        //GetUserService
        //Retrofit                       picasso
        //OkHttpClient                  OkHttp3Downloader
        //loggingInterceptor
        //Timber

        Timber.plant(new Timber.DebugTree());

        Timber.d("COntext " + getGetUserService());
        Timber.d("COntext " + picasso);


    }

    private void resolveDependenices() {
        userServiceComponent = DaggerUserServiceComponent
                .builder()
                .networkComponent(getnetworkComponent())
                .build();
    }

    public GetUserService getGetUserService() {
        return getUserService;
    }

    public Picasso getPicasso() {
        return picasso;
    }

    public UserServiceComponent getUserServiceComponent() {
        return userServiceComponent;
    }

    public NetworkComponent getnetworkComponent() {
        NetworkComponent networkComponent = DaggerNetworkComponent
                .builder()
                .contextModule(new ContextModule(this))
                .build();
        return networkComponent;
    }
}
