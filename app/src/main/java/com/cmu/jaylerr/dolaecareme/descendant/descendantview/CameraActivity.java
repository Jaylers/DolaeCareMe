package com.cmu.jaylerr.dolaecareme.descendant.descendantview;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.cmu.jaylerr.dolaecareme.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CameraActivity extends AppCompatActivity {

    @BindView(R.id.frame_activity_camera_control) FrameLayout camera_frame;
    @BindView(R.id.btn_activity_camera_control) Button camera_control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        ButterKnife.bind(this);

        DescendantCameraFragment descendantCameraFragment = new DescendantCameraFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(R.anim.fade_in,
                R.anim.fade_out);
        ft.replace(R.id.frame_activity_camera_control, descendantCameraFragment);
        ft.commit();
    }

    @OnClick(R.id.btn_activity_camera_full) public void onCloseScreen(){
        finish();
    }

    @OnClick(R.id.btn_activity_camera_control) public void onCameraControl(){
        if (camera_frame.isShown()){
            camera_control.setText(getString(R.string.message_play));
            camera_frame.setVisibility(View.INVISIBLE);
        }else {
            camera_control.setText(getString(R.string.message_pause));
            camera_frame.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
