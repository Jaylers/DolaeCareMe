package com.cmu.jaylerr.dolaecareme.auth.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cmu.jaylerr.dolaecareme.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseAuthFragment extends Fragment {


    public BaseAuthFragment() {
        // Required empty public constructor
    }

    View view;
    View view_descendant;
    View view_elderly;
    ImageView img_descendant;
    ImageView img_elderly;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_base_auth, container, false);
        setViewInjection();
        setOnClick();
        return  view;
    }

    private void setViewInjection(){
        view_descendant = view.findViewById(R.id.relative_descendant);
        view_elderly = view.findViewById(R.id.relative_elderly);
        img_descendant = (ImageView) view.findViewById(R.id.img_descendant);
        img_elderly = (ImageView) view.findViewById(R.id.img_elderly);
    }


    private void setOnClick(){
        view_descendant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DescendantSignInFragment descendantSignInFragment = new DescendantSignInFragment();
                FragmentManager manager = getFragmentManager();
                FragmentTransaction ft = manager.beginTransaction();
                ft.setCustomAnimations(R.anim.fade_in,
                        R.anim.fade_out);
                ft.replace(R.id.frame_fragment_base_auth, descendantSignInFragment);
                ft.commit();
            }
        });

        view_elderly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ElderlySignInFragment elderlySignInFragment = new ElderlySignInFragment();
                FragmentManager manager = getFragmentManager();
                FragmentTransaction ft = manager.beginTransaction();
                ft.setCustomAnimations(R.anim.fade_in,
                        R.anim.fade_out);
                ft.replace(R.id.frame_fragment_base_auth, elderlySignInFragment);
                ft.commit();
            }
        });
    }

}
