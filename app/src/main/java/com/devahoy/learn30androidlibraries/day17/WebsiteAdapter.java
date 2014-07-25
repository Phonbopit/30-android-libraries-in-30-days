package com.devahoy.learn30androidlibraries.day17;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.devahoy.learn30androidlibraries.R;

import java.util.ArrayList;

public class WebsiteAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Website> mWebsites;

    public WebsiteAdapter(Context context, ArrayList<Website> sites) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mWebsites = sites;
    }

    public int getCount() {
        return mWebsites.size();
    }

    public Object getItem(int position) {
        return mWebsites.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.day17_list_item, parent, false);

            holder.title = (TextView) convertView.findViewById(R.id.website_title);
            holder.buttonVisit = (Button) convertView.findViewById(R.id.button_visit);
            holder.logo = (ImageView) convertView.findViewById(R.id.website_logo);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        final Website website = mWebsites.get(position);

        holder.title.setText(website.getTitle());
        holder.logo.setImageResource(website.getImageResourceId());

        holder.buttonVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(website.getUrl()));
                mContext.startActivity(intent);
            }
        });

        return convertView;
    }

    static class ViewHolder {
        TextView title;
        Button buttonVisit;
        ImageView logo;
    }
}
