package com.example.kamranali.rxandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private Button mSearchButton;
    private EditText mQueryEditText;
    private Observable<String> stringObservable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSearchButton = (Button) findViewById(R.id.myButton);
        mQueryEditText = (EditText) findViewById(R.id.myEditText);
        Model model = new Model();
        Observable.create(model)
                .map(new Function<User, User>() {
                    @Override
                    public User apply(User user) throws Exception {

                        return new User(user.getName()+""+System.currentTimeMillis(),user.getEmail());
                    }
                }).subscribe(new Observer<User>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(User user) {
Log.d("Kamran",user.toString());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        Observable.fromIterable(DataGenerator.getArrayList())
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(User user) {

                        try {
                            Thread.sleep(1000);
                            model.add(user);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

//        Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
//                TextWatcher textWatcher = new TextWatcher() {
//                    @Override
//                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//                    }
//
//                    @Override
//                    public void onTextChanged(CharSequence s, int start, int before, int count) {
//                        emitter.onNext(s.toString());
//                    }
//
//                    @Override
//                    public void afterTextChanged(Editable s) {
//
//                    }
//                };
//                mQueryEditText.addTextChangedListener(textWatcher);
//            }
//        }).filter(new Predicate<String>() {
//            @Override
//            public boolean test(String s) throws Exception {
//                return s.length()>4;
//            }
//        }).subscribe(new Observer<String>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.d("Kamran",""+d.toString());
//            }
//
//            @Override
//            public void onNext(String s) {
//                Log.d("Kamran ","onnext "+s.toString());
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
    }

    @Override
    protected void onStart() {
        super.onStart();


    }
}
