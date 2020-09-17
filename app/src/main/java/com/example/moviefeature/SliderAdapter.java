package com.example.moviefeature;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class SliderAdapter extends PagerAdapter {

    List<Data> data;
    Context context;


    //Constructor----------->
    public SliderAdapter(List<Data> data, Context context) {
        this.data = data;
        this.context = context;
    }



    //Instantiating the layout------------------->
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slider_item_view, null);
        ImageView image = view.findViewById(R.id.movie_poster);
        TextView textView = view.findViewById(R.id.movie_title);
        image.setImageResource(data.get(position).getPoster());
        textView.setText(data.get(position).getTitle());

        container.addView(view);
        return view;
    }


    //Count------------->
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
