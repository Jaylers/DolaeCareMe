package com.cmu.jaylerr.dolaecareme.elderly.elderlyview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cmu.jaylerr.dolaecareme.R;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ElderlyOverViewFragment extends Fragment {


    public ElderlyOverViewFragment() {
        // Required empty public constructor
    }

    View view;
    @BindView(R.id.img_main_elderly_sos) ImageView img_main_elderly_sos;
    @BindView(R.id.img_heart_rate_line) ImageView img_heart_rate_line;
    @BindView(R.id.img_pills_morning) ImageView img_pills_morning;
    @BindView(R.id.img_pills_noon) ImageView img_pills_noon;
    @BindView(R.id.img_pills_evening) ImageView img_pills_evening;
    @BindView(R.id.img_pills_night) ImageView img_pills_night;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_eldely_over_view, container, false);
        ButterKnife.bind(this, view);

        setOptionView();
        setPillsToDay();
        setOnClick();
        return view;
    }

    private void setOptionView(){
        img_heart_rate_line.setScaleType(ImageView.ScaleType.FIT_XY);

    }

    private void setOnClick(){
        img_pills_morning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img_pills_morning.setVisibility(View.INVISIBLE);
            }
        });

        img_pills_noon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img_pills_noon.setVisibility(View.INVISIBLE);
            }
        });

        img_pills_evening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img_pills_evening.setVisibility(View.INVISIBLE);
            }
        });

        img_pills_night.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img_pills_night.setVisibility(View.INVISIBLE);
            }
        });

    }

    private void setPillsToDay(){
        if (rand()==0) img_pills_morning.setVisibility(View.VISIBLE);
        if (rand()==0) img_pills_noon.setVisibility(View.VISIBLE);
        if (rand()==0) img_pills_evening.setVisibility(View.VISIBLE);
        if (rand()==0) img_pills_night.setVisibility(View.VISIBLE);
    }

    private int rand(){
        Random r = new Random();
        return r.nextInt(2 - 0) + 0;
    }

}
