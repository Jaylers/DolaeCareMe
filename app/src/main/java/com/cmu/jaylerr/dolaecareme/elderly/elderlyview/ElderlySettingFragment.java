package com.cmu.jaylerr.dolaecareme.elderly.elderlyview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cmu.jaylerr.dolaecareme.R;
import com.cmu.jaylerr.dolaecareme.center.views.togetherview.LanguageListFragment;
import com.cmu.jaylerr.dolaecareme.utility.actioncenter.ApplicationManager;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ElderlySettingFragment extends Fragment {


    public ElderlySettingFragment() {
        // Required empty public constructor
    }

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_elderly_setting, container, false);
        ButterKnife.bind(this. view);

        return view;
    }

    @OnClick(R.id.relative_elderly_setting_language) public void signOut(){
        doSignOut();
    }

    @OnClick(R.id.relative_elderly_setting_language) public void languageSetting(){
        doLanguage();
    }

    private void doLanguage(){
        LanguageListFragment languageListFragment = new LanguageListFragment();
        FragmentManager manager = getFragmentManager();
        android.support.v4.app.FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(R.anim.slide_in_from_right,
                R.anim.slide_out_to_left);
        ft.replace(R.id.frame_elderly_main_content, languageListFragment);
        ft.commit();
    }

    private void doSignOut(){
        ApplicationManager applicationManager = new ApplicationManager(getActivity());
        applicationManager.signOut();
    }

}
