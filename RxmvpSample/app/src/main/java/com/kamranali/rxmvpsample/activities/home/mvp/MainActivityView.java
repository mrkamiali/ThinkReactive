package com.kamranali.rxmvpsample.activities.home.mvp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toolbar;

import com.kamranali.rxmvpsample.MainActivity;
import com.kamranali.rxmvpsample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kamranali on 07/03/2017.
 */

public class MainActivityView extends FrameLayout {

    @BindView(R.id.edit_username)
    EditText usernameEditText;

    @BindView(R.id.btn_username_lookup)
    Button userLookButton;



    public MainActivityView(Activity activity) {
        super(activity);
        ButterKnife.bind(this);

    }
}
