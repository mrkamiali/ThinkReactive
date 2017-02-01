package com.example.kamranali.rxandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kamran ALi on 1/24/2017.
 */

public class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<User> userArrayList;

    public MyAdapter(Context context, ArrayList<User> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }

    @Override
    public int getCount() {
        return userArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return userArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView== null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.listview_xml, null);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.nameView);
        TextView emailView = (TextView) convertView.findViewById(R.id.emailView);
        User user = userArrayList.get(position);
        textView.setText(user.getName().toString());
        emailView.setText(user.getEmail().toString());
        return convertView;
    }
}
