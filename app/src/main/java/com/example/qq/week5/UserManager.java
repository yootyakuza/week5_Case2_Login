package com.example.qq.week5;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/**
 * Created by qq on 11/2/2561.
 */

public class UserManager {

    private final String Key_username = "username";
    private final String Key_password = "password";
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;

    public UserManager(Context context){
        sharedPref = context.getSharedPreferences("YutShared",Context.MODE_PRIVATE);
        editor = sharedPref.edit();
    }

    public boolean checkLoginValidate(String username, String password){
        String realUsername = sharedPref.getString(Key_username,"");
        String realPassword = sharedPref.getString(Key_password,"");

        if((!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) && username.equalsIgnoreCase(realUsername) && password.equalsIgnoreCase(realPassword)){
            return true;
        }
        return false;
    }

    public boolean registerUser(String username, String password){

        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            return false;
        }

        editor.putString(Key_username,username);
        editor.putString(Key_password,password);
        return editor.commit();
    }
}
