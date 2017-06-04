package com.cmu.jaylerr.dolaecareme.descendant.descendantview;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cmu.jaylerr.dolaecareme.R;
import com.cmu.jaylerr.dolaecareme.utility.actioncenter.ContactAction;

/**
 * A simple {@link Fragment} subclass.
 */
public class DescendantOverViewFragment extends Fragment {


    public DescendantOverViewFragment() {
        // Required empty public constructor
    }

    View view;
    ImageView video_camera;
    ImageView img_des_call;
    String elderly_mobile_number = "1175";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_descendant_over_view, container, false);
        setInjectionView();
        setOnClick();
        return view;
    }

    private void setInjectionView(){
        video_camera = (ImageView) view.findViewById(R.id.video_camera);
        video_camera.setScaleType(ImageView.ScaleType.FIT_XY);
        img_des_call = (ImageView) view.findViewById(R.id.img_des_call);
    }

    private void setOnClick(){
        img_des_call.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                ContactAction contactAction = new ContactAction(getActivity());
                contactAction.Call(elderly_mobile_number);
            }
        });
    }

    private void doHome(){

    }

}
