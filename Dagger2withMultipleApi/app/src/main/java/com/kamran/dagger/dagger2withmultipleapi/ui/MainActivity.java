package com.kamran.dagger.dagger2withmultipleapi.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.kamran.dagger.dagger2withmultipleapi.AppController;
import com.kamran.dagger.dagger2withmultipleapi.R;
import com.kamran.dagger.dagger2withmultipleapi.model.User;
import com.kamran.dagger.dagger2withmultipleapi.service.GetUserService;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Inject
    GetUserService getUserService;

    @Inject
    Picasso getPicasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppController.get(this).getApiComponent().inject(this);

        getUserService.getResponseList().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    for (User user : response.body()) {
                        Log.d("Kamran: ", user.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
