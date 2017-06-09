package com.cmu.jaylerr.dolaecareme.center.views.auth;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.cmu.jaylerr.dolaecareme.R;
import com.cmu.jaylerr.dolaecareme.center.background.Connection;
import com.cmu.jaylerr.dolaecareme.center.views.togetherview.LanguageListFragment;
import com.cmu.jaylerr.dolaecareme.descendant.descendantview.DescendantMainActivity;
import com.cmu.jaylerr.dolaecareme.elderly.elderlyview.ElderlyMainActivity;
import com.cmu.jaylerr.dolaecareme.utility.actioncenter.LanguageManager;
import com.cmu.jaylerr.dolaecareme.utility.sharedpreference.SharedSignedUser;
import com.cmu.jaylerr.dolaecareme.utility.sharedstring.SharedFlag;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AuthActivity extends AppCompatActivity {

    @BindView(R.id.txt_auth_message) TextView message;
    @BindView(R.id.btn_retry) Button btn_retry;
    @BindView(R.id.progressBar) ProgressBar progressBar;
    SharedSignedUser sharedSignedUser;
    Connection connection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ButterKnife.bind(this);

        LanguageManager languageManager = new LanguageManager(AuthActivity.this);
        languageManager.setApplicationLanguage();
        sharedSignedUser = new SharedSignedUser(AuthActivity.this);
        connection = new Connection(AuthActivity.this);
        checkConnection();
    }

    private void checkConnection(){
        if (connection.isConnection()){
            doAuthentication();
            progressBar.setVisibility(View.INVISIBLE);
            message.setVisibility(View.GONE);
        }else {
            progressBar.setVisibility(View.INVISIBLE);
            message.setVisibility(View.VISIBLE);
            btn_retry.setVisibility(View.VISIBLE);
            message.setText(getString(R.string.err_message_connection_failure));
        }
    }

    @OnClick(R.id.btn_retry) public void onRetry(){
        btn_retry.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        message.setText(getString(R.string.err_message_connecting));
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                checkConnection();
            }
        },1500);
    }

    private void doAuthentication(){
        if (isSigned()){
            signIn();
        }else {
            openBaseAuth();
        }
    }

    private void signIn(){
        if (sharedSignedUser.getStateSignIn().equals(SharedFlag.flag_descendant)){
            Intent intent = new Intent(AuthActivity.this, DescendantMainActivity.class);
            startActivity(intent);
            finish();
        }else if (sharedSignedUser.getStateSignIn().equals(SharedFlag.flag_elderly)){
            Intent intent = new Intent(AuthActivity.this, ElderlyMainActivity.class);
            startActivity(intent);
            finish();
        }else {
            openBaseAuth();
        }
    }

    private void openBaseAuth(){
        BaseAuthFragment baseAuthFragment = new BaseAuthFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(R.anim.fade_in,
                R.anim.fade_out);
        ft.replace(R.id.frame_fragment_base_auth, baseAuthFragment);
        ft.commit();
    }

    private Boolean isSigned(){
        if (sharedSignedUser.getStateSignIn().equals(SharedFlag.flag_unknown)){
            return false;
        }else return true;
    }

    private int confirm = 0;
    @Override
    public void onBackPressed() {
        Fragment currentFragment = getSupportFragmentManager()
                .findFragmentById(R.id.frame_fragment_base_auth);

        BaseAuthFragment baseAuthFragment = new BaseAuthFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        if (currentFragment instanceof BaseAuthFragment){
            if (confirm>=1){
                confirm = 0;
                finish();
            }else {
                confirm++;
                Toast toast = Toast.makeText(getApplicationContext(),
                        getString(R.string.app_message_confirm_to_close_app),
                        Toast.LENGTH_SHORT);
                toast.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        confirm = 0;
                    }
                },2000);
            }
        }else if (currentFragment instanceof LanguageListFragment){
            ft.setCustomAnimations(R.anim.slide_down_in,
                    R.anim.slide_down_out);
            ft.replace(R.id.frame_fragment_base_auth, baseAuthFragment);
            ft.commit();
        }else {
            ft.setCustomAnimations(R.anim.fade_in,
                    R.anim.fade_out);
            ft.replace(R.id.frame_fragment_base_auth, baseAuthFragment);
            ft.commit();
        }
    }
}
