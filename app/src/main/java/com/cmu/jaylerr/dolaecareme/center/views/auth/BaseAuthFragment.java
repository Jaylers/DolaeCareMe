package com.cmu.jaylerr.dolaecareme.center.views.auth;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cmu.jaylerr.dolaecareme.R;
import com.cmu.jaylerr.dolaecareme.center.views.togetherview.LanguageListFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseAuthFragment extends Fragment {


    public BaseAuthFragment() {
        // Required empty public constructor
    }

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_together_base_auth, container, false);
        ButterKnife.bind(this, view);

        return  view;
    }

    @OnClick(R.id.relative_descendant)
    public void relateDescendant(){
        descendantSignIn();
    }

    @OnClick(R.id.img_descendant)
    public void imgDescendant(){
        descendantSignIn();
    }

    @OnClick(R.id.relative_elderly)
    public void relateElderly(){
        elderlySignIn();
    }

    @OnClick(R.id.img_elderly)
    public void imgElderly(){
        elderlySignIn();
    }

    @OnClick(R.id.txt_language_setting)
    public void language(){
        languageSetting();
    }

    private void descendantSignIn(){
        DescendantSignInFragment descendantSignInFragment = new DescendantSignInFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(R.anim.fade_in,
                R.anim.fade_out);
        ft.replace(R.id.frame_fragment_base_auth, descendantSignInFragment);
        ft.commit();
    }

    private void elderlySignIn(){
        ElderlySignInFragment elderlySignInFragment = new ElderlySignInFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(R.anim.fade_in,
                R.anim.fade_out);
        ft.replace(R.id.frame_fragment_base_auth, elderlySignInFragment);
        ft.commit();
    }

    private void languageSetting(){
        LanguageListFragment lang = new LanguageListFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(R.anim.slide_up_in_from_buttom,
                R.anim.slide_up_out);
        ft.replace(R.id.frame_fragment_base_auth, lang);
        ft.commit();
    }

}
