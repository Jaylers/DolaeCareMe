package com.cmu.jaylerr.dolaecareme.center.views.togetherview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cmu.jaylerr.dolaecareme.R;
import com.cmu.jaylerr.dolaecareme.utility.actioncenter.LanguageManager;
import com.cmu.jaylerr.dolaecareme.utility.sharedstring.SharedFlag;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class LanguageListFragment extends Fragment {


    public LanguageListFragment() {
        // Required empty public constructor
    }

    View view;
    LanguageManager languageManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_together_language_list, container, false);
        ButterKnife.bind(this, view);
        languageManager = new LanguageManager(getActivity());
        return view;
    }

    @OnClick(R.id.relative_language_en)
    public void languaheEn(){
        languageManager.setLanguage(SharedFlag.flag_language_en);
    }

    @OnClick(R.id.relative_language_th)
    public void languageTh(){
        languageManager.setLanguage(SharedFlag.flag_language_th);
    }

}
