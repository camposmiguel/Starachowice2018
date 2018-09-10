package com.miguelcr.a02_customlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

class StudentAdapter extends ArrayAdapter<Student> {
    Context ctx;
    int template;
    List<Student> values;

    public StudentAdapter(@NonNull Context context, int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
        ctx = context;
        template = resource;
        values = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(template,parent,false);

        // 1. Get all the view components from the template
        ImageView ivPhoto = v.findViewById(R.id.imageViewProfile);
        TextView tvName = v.findViewById(R.id.textViewName);
        TextView tvAge = v.findViewById(R.id.textViewAge);
        TextView tvLocation = v.findViewById(R.id.textViewLocation);

        // 2. Get the current student info
        Student current = values.get(position);
        String photo = current.getPhotoUrl();
        String name = current.getName();
        int age = current.getAge();
        String location = current.getLocation();

        // 3. Insert into the view components the student info
        tvName.setText(name);
        tvAge.setText(String.valueOf(age)); // convert int to string
        tvLocation.setText(location);

        Picasso.get().load(photo).into(ivPhoto);

        return v;
    }
}
