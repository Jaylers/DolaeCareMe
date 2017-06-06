package com.cmu.jaylerr.dolaecareme.center.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.cmu.jaylerr.dolaecareme.R;
import com.cmu.jaylerr.dolaecareme.utility.actioncenter.LanguageManager;
import com.cmu.jaylerr.dolaecareme.utility.sharedstring.SharedFlag;

/**
 * A simple {@link Fragment} subclass.
 */
public class LanguageListFragment extends Fragment {


    public LanguageListFragment() {
        // Required empty public constructor
    }

    View view;
    RelativeLayout relat_th;
    RelativeLayout relat_en;
    LanguageManager languageManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_language_list, container, false);
        languageManager = new LanguageManager(getActivity());
        setInjectionView();
        setOnClick();
        return view;
    }

    private void setInjectionView(){
        relat_en = (RelativeLayout) view.findViewById(R.id.relative_language_en);
        relat_th = (RelativeLayout) view.findViewById(R.id.relative_language_th);
    }

    private void setOnClick(){
        relat_en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                languageManager.setLanguage(SharedFlag.flag_language_en);
            }
        });

        relat_th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                languageManager.setLanguage(SharedFlag.flag_language_th);
            }
        });
    }

}
