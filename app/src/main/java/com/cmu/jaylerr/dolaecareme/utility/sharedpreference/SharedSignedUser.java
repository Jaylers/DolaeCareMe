package com.cmu.jaylerr.dolaecareme.utility.sharedpreference;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.cmu.jaylerr.dolaecareme.utility.sharedstring.SharedFlag;
import com.cmu.jaylerr.dolaecareme.utility.sharedstring.SharedKey;

/**
 * Created by jaylerr on 03-Jun-17.
 */

public class SharedSignedUser {
    Activity activity;
    private SharedPreferences account;
    private SharedPreferences.Editor editor;

    public SharedSignedUser(Activity activity) {
        this.activity = activity;
        account = activity.getSharedPreferences(SharedKey.key_sign_in, Context.MODE_PRIVATE);
        editor = account.edit();
    }

    public void setStateSignIn(String state){
        editor.putString(SharedKey.key_sign_in_state, state);
        editor.apply();
    }

    public String getStateSignIn(){
        return account.getString(SharedKey.key_sign_in_state, SharedFlag.flag_unknown);
    }
}
