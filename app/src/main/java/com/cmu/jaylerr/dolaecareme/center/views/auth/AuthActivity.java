package com.cmu.jaylerr.dolaecareme.center.views.auth;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.cmu.jaylerr.dolaecareme.R;
import com.cmu.jaylerr.dolaecareme.center.views.togetherview.LanguageListFragment;
import com.cmu.jaylerr.dolaecareme.descendant.descendantview.DescendantMainActivity;
import com.cmu.jaylerr.dolaecareme.elderly.elderlyview.ElderlyMainActivity;
import com.cmu.jaylerr.dolaecareme.utility.actioncenter.LanguageManager;
import com.cmu.jaylerr.dolaecareme.utility.sharedpreference.SharedSignedUser;
import com.cmu.jaylerr.dolaecareme.utility.sharedstring.SharedFlag;

public class AuthActivity extends AppCompatActivity {

    SharedSignedUser sharedSignedUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        LanguageManager languageManager = new LanguageManager(AuthActivity.this);
        languageManager.setApplicationLanguage();
        sharedSignedUser = new SharedSignedUser(AuthActivity.this);

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
