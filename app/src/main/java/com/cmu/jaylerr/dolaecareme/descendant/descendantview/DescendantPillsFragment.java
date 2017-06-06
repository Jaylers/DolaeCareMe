package com.cmu.jaylerr.dolaecareme.descendant.descendantview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cmu.jaylerr.dolaecareme.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DescendantPillsFragment extends Fragment {


    public DescendantPillsFragment() {
        // Required empty public constructor
    }

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_descendant_pills, container, false);
        return view;
    }

}
