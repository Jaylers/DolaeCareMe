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
import com.cmu.jaylerr.dolaecareme.descendant.descendantview.DescendantMainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class DescendantSignInFragment extends Fragment {


    public DescendantSignInFragment() {
        // Required empty public constructor
    }

    View view;
    EditText edt_des_user;
    EditText edt_eld_user;
    EditText edt_eld_gmail;
    EditText edt_eld_serial;
    Button btn_create;
    TextView txt_back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_descendant_sign_in, container, false);
        edt_des_user = (EditText) view.findViewById(R.id.edt_des_username);
        edt_eld_user = (EditText) view.findViewById(R.id.edt_elderly_username);
        edt_eld_gmail = (EditText) view.findViewById(R.id.edt_elderly_gmail_account);
        edt_eld_serial = (EditText) view.findViewById(R.id.edt_machine_serial_number);
        btn_create = (Button) view.findViewById(R.id.btn_frag_des_create);
        txt_back = (TextView) view.findViewById(R.id.txt_back);


        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSignInForm()){
                    Intent intent = new Intent(getActivity(), DescendantMainActivity.class);
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
        if (edt_des_user.getText().toString().isEmpty()){
            edt_des_user.setError(getString(R.string.err_message_required));
            return false;
        }else if (edt_eld_user.getText().toString().isEmpty()){
            edt_eld_user.setError(getString(R.string.err_message_required));
            return false;
        }else if (edt_eld_gmail.getText().toString().isEmpty()){
            edt_eld_gmail.setError(getString(R.string.err_message_required));
            return false;
        }else if (edt_eld_serial.getText().toString().isEmpty()){
            edt_eld_serial.setError(getString(R.string.err_message_required));
            return false;
        }else return true;
    }

}
