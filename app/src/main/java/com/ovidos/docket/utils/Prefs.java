package com.ovidos.docket.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

/**
 * Created by omral on 11.05.2017.
 */

public class Prefs {

    private static final String TOKEN = "com.ovidos.docket.token";
    private static final String PREFS = "com.ovidos.docket.prefs";

    public static void setToken(Context context, String token) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).edit();
        editor.putString(TOKEN, encrypt(token)).apply();
    }

    public static String getToken(Context context) {
        if (context == null){
            return null;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        return decrypt(sharedPreferences.getString(TOKEN, null));
    }

    public static String encrypt(String input) {
        if (input != null) {
            return Base64.encodeToString(input.getBytes(), Base64.DEFAULT);
        }
        return null;
    }

    public static String decrypt(String input) {
        if (input != null) {
            return new String(Base64.decode(input, Base64.DEFAULT));
        }
        return null;
    }
}
