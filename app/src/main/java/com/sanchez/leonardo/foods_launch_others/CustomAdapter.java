package com.sanchez.leonardo.foods_launch_others;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by k.key on 22/03/2017.
 */

class CustomAdapter extends ArrayAdapter<String> {
    public CustomAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }
/*
    private int[] img_ids;
    CustomAdapter(Context context, String[] foods,int[] imgid) {
        super(context, R.layout.custom_row ,foods);
        this.img_ids=imgid;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater buckysInflater = LayoutInflater.from(getContext());
        View customView = buckysInflater.inflate(R.layout.custom_row, parent, false);

        String singleFoodItem = getItem(position);
        ;
        TextView buckysText = (TextView) customView.findViewById(R.id.name);
        //ImageView buckysImage = (ImageView) customView.findViewById(R.id.txt_value);

        buckysText.setText(singleFoodItem);
        Drawable myDrawable = getContext().getResources().getDrawable(img_ids[position]);
        //buckysImage.setImageDrawable(myDrawable);
        return customView;
    }*/
}


