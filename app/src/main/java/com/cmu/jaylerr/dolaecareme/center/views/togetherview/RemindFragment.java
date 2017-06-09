package com.cmu.jaylerr.dolaecareme.center.views.togetherview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cmu.jaylerr.dolaecareme.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RemindFragment extends Fragment {


    public RemindFragment() {
        // Required empty public constructor
    }

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_together_remind, container, false);
        setInjectionView();
        setOnClick();
        setDoctor();
        setPills();
        return view;
    }

    private void setDoctor(){
        DoctorFragment doctorFragment = new DoctorFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(R.anim.fade_in,
                R.anim.fade_out);
        ft.replace(R.id.frame_fragment_remind_doctor, doctorFragment);
        ft.commit();
    }

    private void setPills(){
        PillsFragment pillsFragment = new PillsFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(R.anim.fade_in,
                R.anim.fade_out);
        ft.replace(R.id.frame_fragment_remind_pills, pillsFragment);
        ft.commit();
    }

    private void setInjectionView(){

    }

    private void setOnClick(){

    }

}
