package com.cmu.jaylerr.dolaecareme.utility.sharedpreference;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.cmu.jaylerr.dolaecareme.utility.sharedstring.SharedKey;

/**
 * Created by jaylerr on 03-Jun-17.
 */

public class SharedSignedUser {
    Activity activity;
    private SharedPreferences.Editor editor;

    public SharedSignedUser(Activity activity) {
        this.activity = activity;
    }

    public void setElderlySignIn(){
        SharedPreferences sharedPref = activity.getSharedPreferences(SharedKey.key_sign_in, Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        editor.putString(SharedKey.key_sign_in_elderly, "user_id");
        editor.apply();
    }

    public void setDescendantSignIn(){
        SharedPreferences sharedPref = activity.getSharedPreferences(SharedKey.key_sign_in, Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        editor.putString(SharedKey.key_sign_in_descendant, "user_id");
        editor.apply();
    }

    public Boolean isElderSignIn(){
        return false;
    }

    public Boolean isDescendantSignIn(){
        return false;
    }
}
