package com.kamran.rxdagger;

import android.app.Application;

import com.kamran.rxdagger.dependencies.ApiComponent;
import com.kamran.rxdagger.dependencies.DaggerApiComponent;
import com.kamran.rxdagger.dependencies.DaggerNetworkComponent;
import com.kamran.rxdagger.dependencies.NetworkComponent;
import com.kamran.rxdagger.dependencies.NetwrokModule;
import com.kamran.rxdagger.model.Constant;

/**
 * Created by Kamran ALi on 2/3/2017.
 */

public class AppController extends Application {

    private ApiComponent apiComponent;
    @Override
    public void onCreate() {
        resolveDependency();
        super.onCreate();

    }

    private void resolveDependency() {
         apiComponent = DaggerApiComponent.builder()
                .networkComponent(getNetwokComponent()).build();
    }

    public NetworkComponent getNetwokComponent() {
        NetworkComponent networkComponent = DaggerNetworkComponent.builder()
                .netwrokModule(new NetwrokModule(Constant.BASE_URL)).build();
        return networkComponent;
    }

    public ApiComponent getApiComponent() {
        return apiComponent;
    }
}
