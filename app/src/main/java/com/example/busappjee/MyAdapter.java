package com.example.busappjee;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private ArrayList<DataClass> dataList;
    private Context context;
    LayoutInflater layoutInflater;

    public MyAdapter(Context context, ArrayList<DataClass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (layoutInflater == null){
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (view == null){
            view = layoutInflater.inflate(R.layout.grid_item, null);
        }

        ImageView gridImage = view.findViewById(R.id.gridImage);
        TextView gridCaption = view.findViewById(R.id.gridCaption);

        // Load the image using Glide
        Glide.with(context).load(dataList.get(i).getImageURL()).into(gridImage);

        // Set a click listener on the image
        gridImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open a new activity with the selected image in full-screen size
                Intent intent = new Intent(context, FullScreenImageActivity.class);
                intent.putExtra("image_url", dataList.get(i).getImageURL());
                context.startActivity(intent);
            }
        });

        gridCaption.setText(dataList.get(i).getCaption());

        return view;
    }

}