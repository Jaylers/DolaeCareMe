package com.cmu.jaylerr.dolaecareme.descendant.descendantview;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.cmu.jaylerr.dolaecareme.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DescendantCameraFragment extends Fragment {


    public DescendantCameraFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.video_des_camera) VideoView videoView;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_descendant_camera, container, false);
        ButterKnife.bind(this. view);
        startVideo();
        return view;
    }

    private void startVideo(){
        try {
            MediaController mediaController = new MediaController(getActivity());
            mediaController.setAnchorView(videoView);
            Uri uri=Uri.parse("rtsp://r7---sn-4g57kue6.googlevideo.com/Ck0LENy73wIaRAmk3cJBg-iaXhMYDSANFC3u0pRWMOCoAUIJbXYtZ29vZ2xlSARSBXdhdGNoYIaluaTkzciOVooBCzVxRjNraG5XcXdnDA==/D693A8E7577C3A29E60C292B42C9C87D7C25A565.762A63DC4CA0A028DA83256C6A79E5F160CBEDA3/yt6/1/video.3gp");
            videoView.setMediaController(mediaController);
            videoView.setVideoURI(uri);
            videoView.requestFocus();
            videoView.start();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
