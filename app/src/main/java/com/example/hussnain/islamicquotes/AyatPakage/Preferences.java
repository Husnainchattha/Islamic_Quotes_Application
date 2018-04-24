package com.example.hussnain.islamicquotes.AyatPakage;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public final class Preferences {
   private SharedPreferences preferences;
   private static Preferences instance;

    public static Preferences getInstance(Context context) {
        if (instance == null) {
            instance = new Preferences(context);
        }
        return instance;
    }
    private Preferences(final Context context) {
        preferences= PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void saveTodayTime(int random){
        long timestamp=System.currentTimeMillis();
        preferences.edit()
                .putLong("time",timestamp)
                .putInt("number",random)
                .apply();
    }

    public long getSavedTime(){
        return preferences.getLong("time",0);
    }

    public int getRandomNumber(){
        return preferences.getInt("number",-1);
    }
}
