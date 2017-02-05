package com.kamran.thinkdagger.ui.home;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.kamran.thinkdagger.AppController;
import com.kamran.thinkdagger.R;
import com.kamran.thinkdagger.adapter.Adapter;
import com.kamran.thinkdagger.model.User;
import com.kamran.thinkdagger.service.GetUserService;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Inject
    GetUserService getUserService;

    private ArrayList<User> userArrayList;
    private ListView listView;
    private Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userArrayList= new ArrayList<>();

        listView = (ListView) findViewById(R.id.myListView);
        adapter = new Adapter(this,userArrayList);
        listView.setAdapter(adapter);

        resolveDependency();

        getUserService.getResponse().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                if (response.isSuccessful()) {
                    for (User user : response.body()) {
                        userArrayList.add(user);
                        adapter.notifyDataSetChanged();
                        Log.e("Kamran:", user.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }

    private void resolveDependency() {
        ((AppController) getApplication())
                .getmApiComponent()
                .inject(this);
    }
}
