package com.cmu.jaylerr.dolaecareme.descendant.descendantview;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmu.jaylerr.dolaecareme.R;
import com.cmu.jaylerr.dolaecareme.center.views.heart.HeartInfoFragment;
import com.cmu.jaylerr.dolaecareme.utility.actioncenter.CallMobile;

/**
 * A simple {@link Fragment} subclass.
 */
public class DescendantOverViewFragment extends Fragment {


    public DescendantOverViewFragment() {
        // Required empty public constructor
    }

    View view;
    private TextView mTextMessage;
    ImageView video_camera;
    ImageView img_des_call;
    RelativeLayout relative_descendant_heart_group;
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
        mTextMessage = (TextView) getActivity().findViewById(R.id.message);
        video_camera = (ImageView) view.findViewById(R.id.video_camera);
        video_camera.setScaleType(ImageView.ScaleType.FIT_XY);
        img_des_call = (ImageView) view.findViewById(R.id.img_des_call);
        relative_descendant_heart_group = (RelativeLayout) view.findViewById(R.id.relative_descendant_heart_group);
    }

    private void setOnClick(){
        img_des_call.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                CallMobile callMobile = new CallMobile(getActivity());
                callMobile.Call(elderly_mobile_number);
            }
        });

        relative_descendant_heart_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHeart();
            }
        });
    }

    private void openHeart(){
        mTextMessage.setText(R.string.title_heart);
        HeartInfoFragment heartInfoFragment = new HeartInfoFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(R.anim.fade_in,
                R.anim.fade_out);
        ft.replace(R.id.frame_descendant_main_content, heartInfoFragment);
        ft.commit();
    }

    private void doHome(){
        mTextMessage.setText(R.string.title_home);
    }

}
