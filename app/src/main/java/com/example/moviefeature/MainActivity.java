package com.example.moviefeature;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabs;
    List<Data> list;
    SliderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.slider);
        tabs = findViewById(R.id.indicator);


        //Array List that store the data--------------->
        list = new ArrayList<>();


        //Data--------------------------------->
        list.add(new Data(R.drawable.spiderman, "Spider-Man"));
        list.add(new Data(R.drawable.jl, "Justice League"));
        list.add(new Data(R.drawable.interstellar, "Interstellar"));
        list.add(new Data(R.drawable.avengers, "Avengers"));
        list.add(new Data(R.drawable.toy, "Toy Story 4"));


        //Initialising and setting adapter to View Pager-------------->
        adapter = new SliderAdapter(list, this);
        viewPager.setAdapter(adapter);


        //Timer to slide automatically--------------->
        Timer timer = new Timer();
        timer.schedule(new sliderTimer(), 4000, 6000);

        //setting tabs according to View Pager
        tabs.setupWithViewPager(viewPager, true);


    }


    //If view pager contains last image them it will move to first image otherwise to next image-------------->
    class sliderTimer extends TimerTask {
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() < list.size() - 1) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });

        }
    }
}