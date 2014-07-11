package com.devahoy.learn30androidlibraries.day3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class GridAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ShotList mShots;

    public GridAdapter(Context context, ShotList shots) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mShots = shots;
    }

    public int getCount() {
        return mShots.getShots().size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, 200));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(4, 4, 4, 4);
        } else {
            imageView = (ImageView) convertView;
        }

        Picasso.with(mContext)
                .load(mShots.getShots().get(position).getImageUrl())
                .into(imageView);

        return imageView;
    }

}
