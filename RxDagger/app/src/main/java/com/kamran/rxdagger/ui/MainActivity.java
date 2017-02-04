package com.kamran.rxdagger.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kamran.rxdagger.AppController;
import com.kamran.rxdagger.R;
import com.kamran.rxdagger.base.FlowerPresenter;
import com.kamran.rxdagger.model.FlowerResponse;
import com.kamran.rxdagger.service.FloweService;
import com.kamran.rxdagger.service.FlowerViewInterface;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;


public class MainActivity extends AppCompatActivity implements FlowerViewInterface{

    @Inject
    FloweService mService;
    private FlowerPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new FlowerPresenter(MainActivity.this);
        mPresenter.onCreate();
        ((AppController) getApplication())
                .getApiComponent()
                .inject(MainActivity.this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
        mPresenter.fetchFlower();
    }

    @Override
    public void onSubscribed(Disposable d) {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onNext(List<FlowerResponse> flowerResponses) {

    }

    @Override
    public Observable<List<FlowerResponse>> getFlowers() {
        return mService.getFlowerListResponse();
    }
}
