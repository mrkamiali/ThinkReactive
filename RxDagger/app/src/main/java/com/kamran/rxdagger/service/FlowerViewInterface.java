package com.kamran.rxdagger.service;

import com.kamran.rxdagger.model.FlowerResponse;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Kamran ALi on 2/3/2017.
 */

public interface FlowerViewInterface {

    void onSubscribed(Disposable d);

    void onError(String message);

    void onCompleted();

    void onNext(List<FlowerResponse> flowerResponses);

    Observable<List<FlowerResponse>> getFlowers();
}
