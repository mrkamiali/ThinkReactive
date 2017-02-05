package com.kamran.thinkdagger.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kamran.thinkdagger.R;
import com.kamran.thinkdagger.model.User;

import java.util.ArrayList;

/**
 * Created by Kamran ALi on 2/5/2017.
 */

public class Adapter extends BaseAdapter {
    private Context context;
    private ArrayList<User> userArrayList;

    public Adapter(Context context, ArrayList<User> userArrayList) {
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
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.listview, null);
        }
        User user = userArrayList.get(position);
        //
        TextView textView = (TextView) convertView.findViewById(R.id.nameView);
        TextView emailView = (TextView) convertView.findViewById(R.id.emailView);
        TextView idView = (TextView) convertView.findViewById(R.id.id_view);
        TextView user_Name = (TextView) convertView.findViewById(R.id.username_view);
        //
        textView.setText(user.getName().toString());
        emailView.setText(user.getEmail().toString());
        idView.setText(""+user.getId());
        user_Name.setText(user.getUsername());
        return convertView;
    }
}
