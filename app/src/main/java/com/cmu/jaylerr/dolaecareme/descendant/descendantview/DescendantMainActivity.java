package com.cmu.jaylerr.dolaecareme.descendant.descendantview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.cmu.jaylerr.dolaecareme.R;
import com.cmu.jaylerr.dolaecareme.auth.views.AuthActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class DescendantMainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private CircleImageView profile_img;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_heart:
                    mTextMessage.setText(R.string.title_heart);
                    return true;
                case R.id.navigation_walk:
                    mTextMessage.setText(R.string.title_walk);
                    return true;
                case R.id.navigation_sleep:
                    mTextMessage.setText(R.string.title_sleep);
                    return true;
                case R.id.navigation_settings:
                    mTextMessage.setText(R.string.title_settings);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descendant_main);
        setInjectionView();
        setOnClick();
        doHome();
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void setInjectionView(){
        profile_img = (CircleImageView) findViewById(R.id.img_main_user_profile);
    }

    private void setOnClick(){
        profile_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DescendantMainActivity.this, AuthActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void doHome(){
        DescendantOverViewFragment descendantOverViewFragment = new DescendantOverViewFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(R.anim.fade_in,
                R.anim.fade_out);
        ft.replace(R.id.frame_descendant_main_content, descendantOverViewFragment);
        ft.commit();
    }

}
