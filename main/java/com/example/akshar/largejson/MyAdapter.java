package com.example.akshar.largejson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Akshar on 8/31/2017.
 */

public class MyAdapter extends BaseAdapter {
    ArrayList<Mybean>arrayList;
    Context context;

    public MyAdapter(Context context,ArrayList<Mybean> arrayList ) {
        this.arrayList = arrayList;
        this.context = context;
    }



    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=layoutInflater.inflate(R.layout.my_layout,null);
        TextView txtname,txtdob,txtcountery;
        ImageView imageView;

        txtname=(TextView)convertView.findViewById(R.id.txtname);
        txtdob=(TextView)convertView.findViewById(R.id.txtdob);
        txtcountery=(TextView)convertView.findViewById(R.id.txtcountery);
             imageView=(ImageView)convertView.findViewById(R.id.id122);


        Mybean mybean  =arrayList.get(position);
        txtcountery.setText("Countery"+mybean.getContry());
        txtname.setText("mobile"+mybean.getName());
        txtdob.setText("mobile"+mybean.getDob());
        Picasso.with(context).load(mybean.getImages122()).into(imageView);
        return convertView;
    }
}
