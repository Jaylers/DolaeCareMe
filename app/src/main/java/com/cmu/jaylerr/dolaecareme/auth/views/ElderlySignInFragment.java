package com.cmu.jaylerr.dolaecareme.auth.views;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cmu.jaylerr.dolaecareme.R;
import com.cmu.jaylerr.dolaecareme.elderly.elderlyview.ElderlyMainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ElderlySignInFragment extends Fragment {


    public ElderlySignInFragment() {
        // Required empty public constructor
    }

    Button btn_create;
    EditText edt_username;
    EditText edt_serial_number;
    TextView txt_back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view;
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_elderly_sign_in, container, false);
        btn_create = (Button) view.findViewById(R.id.btn_elderly_create);
        edt_username = (EditText) view.findViewById(R.id.edt_elderly_username);
        edt_serial_number = (EditText) view.findViewById(R.id.edt_elderly_serial_number);
        txt_back = (TextView) view.findViewById(R.id.txt_back);

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSignInForm()){
                    Intent intent = new Intent(getActivity(), ElderlyMainActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
            }
        });

        txt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseAuthFragment baseAuthFragment = new BaseAuthFragment();
                FragmentManager manager = getFragmentManager();
                FragmentTransaction ft = manager.beginTransaction();
                ft.setCustomAnimations(R.anim.fade_in,
                        R.anim.fade_out);
                ft.replace(R.id.frame_fragment_base_auth, baseAuthFragment);
                ft.commit();
            }
        });

        return view;
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
