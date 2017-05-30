package com.ovidos.docket.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by omral on 11.05.2017.
 */

public class Prefs {

    private static final String TOKEN = "com.ovidos.docket.token";
    private static final String PREFS = "com.ovidos.docket.prefs";
    private static final String NOTIFICATION_STATUS = "com.ovidos.muhip.notification_status";

    public static void setToken(Context context, String token) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).edit();
        editor.putString(TOKEN, token).apply();
    }

    public static String getToken(Context context) {
        if (context == null){
            return null;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        return sharedPreferences.getString(TOKEN, null);
    }
}
