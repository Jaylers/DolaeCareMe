package com.cmu.jaylerr.dolaecareme.descendant.descendantview;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.cmu.jaylerr.dolaecareme.R;
import com.cmu.jaylerr.dolaecareme.center.views.togetherview.HeartInfoFragment;
import com.cmu.jaylerr.dolaecareme.center.views.togetherview.RemindFragment;
import com.cmu.jaylerr.dolaecareme.utility.alarm.AlarmReceiverActivity;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class DescendantMainActivity extends AppCompatActivity {

    @BindView(R.id.message) TextView mTextMessage;
    @BindView(R.id.img_main_user_profile) CircleImageView profile_img;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    doHome();
                    return true;
                case R.id.navigation_heart:
                    doHeart();
                    return true;
                case R.id.navigation_activity:
                    mTextMessage.setText(R.string.title_activity);
                    doActivity();
                    return true;
                case R.id.navigation_remind:
                    mTextMessage.setText(R.string.title_remind);
                    doRemind();
                    return true;
                case R.id.navigation_settings:
                    mTextMessage.setText(R.string.title_settings);
                    doSetting();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descendant_main);
        ButterKnife.bind(this);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        doHome();
        setOnClick();
    }

    private void setOnClick(){

    }

    private void doAlert(){
        //Create an offset from the current time in which the alarm will go off.
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 5);

        //Create a new PendingIntent and add it to the AlarmManager
        Intent intent = new Intent(this, AlarmReceiverActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                12345, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarmManager = (AlarmManager)getSystemService(Activity.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                pendingIntent);
    }
    private void doHome(){
        mTextMessage.setText(R.string.title_home);
        DescendantOverViewFragment descendantOverViewFragment = new DescendantOverViewFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(R.anim.fade_in,
                R.anim.fade_out);
        ft.replace(R.id.frame_descendant_main_content, descendantOverViewFragment);
        ft.commit();
    }

    private void doHeart(){
        mTextMessage.setText(R.string.title_heart);
        HeartInfoFragment heartInfoFragment = new HeartInfoFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(R.anim.fade_in,
                R.anim.fade_out);
        ft.replace(R.id.frame_descendant_main_content, heartInfoFragment);
        ft.commit();
    }

    private void doActivity(){
        ActivityFragment activityFragment = new ActivityFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(R.anim.fade_in,
                R.anim.fade_out);
        ft.replace(R.id.frame_descendant_main_content, activityFragment);
        ft.commit();
    }

    private void doRemind(){
        RemindFragment remindFragment = new RemindFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(R.anim.fade_in,
                R.anim.fade_out);
        ft.replace(R.id.frame_descendant_main_content, remindFragment);
        ft.commit();
    }

    private void doSetting(){
        DescendantSettingFragment descendantSettingFragment = new DescendantSettingFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(R.anim.fade_in,
                R.anim.fade_out);
        ft.replace(R.id.frame_descendant_main_content, descendantSettingFragment);
        ft.commit();
    }

}
