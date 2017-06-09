package com.cmu.jaylerr.dolaecareme.descendant.descendantview;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.cmu.jaylerr.dolaecareme.R;
import com.cmu.jaylerr.dolaecareme.center.views.togetherview.HeartInfoFragment;
import com.cmu.jaylerr.dolaecareme.center.views.togetherview.RemindFragment;
import com.cmu.jaylerr.dolaecareme.utility.actioncenter.CallMobile;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class DescendantOverViewFragment extends Fragment {

    public DescendantOverViewFragment() {
        // Required empty public constructor
    }

    View view;
    @BindView(R.id.frame_frag_camera) FrameLayout camera_frame;
    @BindView(R.id.btn_des_camera_control) Button camera_control;
    @BindView(R.id.linear_overview_top_menu_group) LinearLayout top_group;
    @BindView(R.id.linear_overview_bottom_menu_group) LinearLayout bot_group;
    String elderly_mobile_number = "1175";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_descendant_over_view, container, false);
        ButterKnife.bind(this, view);
        setCamera();
        return view;
    }

    @OnClick(R.id.btn_des_camera_full) public void onFullScreen(){
        Intent intent = new Intent(getActivity(), CameraActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_des_camera_control) public void onCameraControl(){
        if (camera_frame.isShown()){
            camera_control.setText(getString(R.string.message_play));
            camera_frame.setVisibility(View.GONE);
        }else {
            camera_control.setText(getString(R.string.message_pause));
            camera_frame.setVisibility(View.VISIBLE);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @OnClick(R.id.img_des_call) public void onCall(){
        CallMobile callMobile = new CallMobile(getActivity());
        callMobile.Call(elderly_mobile_number);
    }

    @OnClick(R.id.relative_descendant_heart_group) public void onHeart(){
        openHeart();
    }

    @OnClick(R.id.relative_descendant_remind_group) public void onRemind(){
        openRemind();
    }

    @OnClick(R.id.relative_descendant_analysis_group) public void onAnalysis(){
        openAnalysis();
    }

    private void setCamera(){
        DescendantCameraFragment descendantCameraFragment = new DescendantCameraFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(R.anim.fade_in,
                R.anim.fade_out);
        ft.replace(R.id.frame_frag_camera, descendantCameraFragment);
        ft.commit();
    }

    private void openHeart(){
        HeartInfoFragment heartInfoFragment = new HeartInfoFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(R.anim.fade_in,
                R.anim.fade_out);
        ft.replace(R.id.frame_descendant_main_content, heartInfoFragment);
        ft.commit();
    }

    private void openRemind(){
        RemindFragment remindFragment = new RemindFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(R.anim.fade_in,
                R.anim.fade_out);
        ft.replace(R.id.frame_descendant_main_content, remindFragment);
        ft.commit();
    }

    private void openAnalysis(){

    }

}
