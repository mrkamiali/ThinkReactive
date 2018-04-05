package com.kamran.dagger.dagger2retrofit2practice.dependencies;

import com.kamran.dagger.dagger2retrofit2practice.MainActivity;
import com.kamran.dagger.dagger2retrofit2practice.Network.GetUserService;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import dagger.Component;

/**
 * Created by Kamran ALi on 2/10/2017.
 */
@Component(modules = UserServiceModule.class, dependencies = NetworkComponent.class)
@CustomScope
public interface UserServiceComponent {

    @Inject
    GetUserService getUserService();

    @Inject
    Picasso picasso();

}
