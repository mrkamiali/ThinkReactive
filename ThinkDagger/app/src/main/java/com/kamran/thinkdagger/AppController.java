package com.kamran.thinkdagger;

import android.app.Application;

import com.kamran.thinkdagger.dependencies.ApiComponent;
import com.kamran.thinkdagger.dependencies.DaggerApiComponent;
import com.kamran.thinkdagger.dependencies.DaggerNetworkComponent;
import com.kamran.thinkdagger.dependencies.NetworkComponent;
import com.kamran.thinkdagger.dependencies.NetworkModuleApi;
import com.kamran.thinkdagger.utils.Constants;

/**
 * Created by Kamran ALi on 2/5/2017.
 */

public class AppController extends Application {

    ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        resolveDependencies();
        super.onCreate();
    }

    private void resolveDependencies() {

        mApiComponent = DaggerApiComponent.builder()
                .networkComponent(getNetworkComponent()).build();
    }

    public NetworkComponent getNetworkComponent() {
        return DaggerNetworkComponent.builder()
        .networkModuleApi(new NetworkModuleApi(Constants.BASE_URL)).build();
    }

    public ApiComponent getmApiComponent() {
        return mApiComponent;
    }
}
