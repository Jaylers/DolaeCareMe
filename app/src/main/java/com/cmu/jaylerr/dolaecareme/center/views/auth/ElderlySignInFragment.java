package com.cmu.jaylerr.dolaecareme.center.views.auth;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.cmu.jaylerr.dolaecareme.R;
import com.cmu.jaylerr.dolaecareme.elderly.elderlyview.ElderlyMainActivity;
import com.cmu.jaylerr.dolaecareme.utility.sharedpreference.SharedSignedUser;
import com.cmu.jaylerr.dolaecareme.utility.sharedstring.SharedFlag;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ElderlySignInFragment extends Fragment {


    public ElderlySignInFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.edt_elderly_username) EditText edt_username;
    @BindView(R.id.edt_elderly_serial_number) EditText edt_serial_number;
    SharedSignedUser sharedSignedUser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view;
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_elderly_sign_in, container, false);
        ButterKnife.bind(this, view);
        sharedSignedUser = new SharedSignedUser(getActivity());

        return view;
    }

    @OnClick(R.id.btn_elderly_create) public void onCreateClicked(){
        if (isSignInForm()){
            sharedSignedUser.setStateSignIn(SharedFlag.flag_elderly);
            Intent intent = new Intent(getActivity(), ElderlyMainActivity.class);
            startActivity(intent);
            getActivity().finish();
        }
    }

    @OnClick(R.id.txt_eld_back) public void onBack(){
        BaseAuthFragment baseAuthFragment = new BaseAuthFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(R.anim.fade_in,
                R.anim.fade_out);
        ft.replace(R.id.frame_fragment_base_auth, baseAuthFragment);
        ft.commit();
    }

    private Boolean isSignInForm(){
        if (edt_username.getText().toString().isEmpty()){
            edt_username.setError(getString(R.string.err_message_required));
            return false;
        }else if (edt_serial_number.getText().toString().isEmpty()){
            edt_serial_number.setError(getString(R.string.err_message_required));
            return false;
        }else return true;
    }

}
