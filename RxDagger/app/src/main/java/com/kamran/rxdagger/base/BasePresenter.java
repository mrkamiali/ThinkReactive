package com.kamran.rxdagger.base;

import com.kamran.rxdagger.model.FlowerResponse;

import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Kamran ALi on 2/3/2017.
 */

public abstract class BasePresenter implements Presenter {

    private CompositeDisposable compositeSubscription;
    @Override
    public void onCreate() {

    }

    @Override
    public void onResume() {
        configureSubscription();
    }

    private CompositeDisposable configureSubscription() {
        if (compositeSubscription == null || compositeSubscription.isDisposed()){
            compositeSubscription = new CompositeDisposable();
        }

        return compositeSubscription;

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {
        unSubscribeAll();
    }

    protected void unSubscribeAll() {
        if (compositeSubscription!=null){
            compositeSubscription.dispose();
            compositeSubscription.clear();
        }
    }

    protected <T> void subscribe(Observable<List<T>> observable, Consumer<List<T>> observer){

        Disposable subscribe = observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.computation())
                .subscribe(observer);

        configureSubscription().add(subscribe);
    }
}
