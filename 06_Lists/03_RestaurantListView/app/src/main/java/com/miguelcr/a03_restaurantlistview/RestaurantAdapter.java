package com.miguelcr.a03_restaurantlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

class RestaurantAdapter extends ArrayAdapter<Restaurant> {
    Context ctx;
    int template;
    List<Restaurant> values;

    public RestaurantAdapter(@NonNull Context context, int resource, @NonNull List<Restaurant> objects) {
        super(context, resource, objects);
        ctx = context;
        template = resource;
        values = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(template,parent,false);

        Restaurant current = values.get(position);

        ImageView ivPhoto = v.findViewById(R.id.imageViewPhoto);
        TextView tvName = v.findViewById(R.id.textViewName);
        TextView tvAddress = v.findViewById(R.id.textViewAddress);
        RatingBar rbRating = v.findViewById(R.id.ratingBar);

        String name =  current.getName();
        String address = current.getAddress();
        String photo = current.getPhoto();
        float rate = current.getRate();

        tvName.setText(name);
        tvAddress.setText(address);
        rbRating.setRating(rate);

        Picasso.get().load(photo).into(ivPhoto);

        return v;
    }
}
