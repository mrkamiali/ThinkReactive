package com.kamran.rxdagger.base;

import com.kamran.rxdagger.model.FlowerResponse;
import com.kamran.rxdagger.service.FlowerViewInterface;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Kamran ALi on 2/3/2017.
 */

public class FlowerPresenter extends BasePresenter implements Consumer<List<FlowerResponse>> {
    private FlowerViewInterface mViewInterface;

    public FlowerPresenter(FlowerViewInterface mViewInterface) {
        this.mViewInterface = mViewInterface;
    }

    @Override
    public void onSubscribe(Disposable d) {

        mViewInterface.onSubscribed(d);
    }

    @Override
    public void onNext(List<FlowerResponse> flowerResponses) {
        mViewInterface.onNext(flowerResponses);
    }

    @Override
    public void onError(Throwable e) {
        mViewInterface.onError(e.getMessage());
    }

    @Override
    public void onComplete() {
        mViewInterface.onCompleted();
    }

    public void fetchFlower() {
        unSubscribeAll();
        subscribe(mViewInterface.getFlowers(), FlowerPresenter.this);
    }
}
