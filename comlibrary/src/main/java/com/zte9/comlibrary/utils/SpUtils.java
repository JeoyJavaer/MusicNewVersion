package com.zte9.comlibrary.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.zte9.library.BaseApp;

/**
 * Created by 陈乐  on 2018/3/29.
 * Email chenle@zet9.com
 * Description   sp 工具
 * Others
 */

public class SpUtils {

    public static final String TAG = SpUtils.class.getSimpleName();

    private SpUtils() {
        throw new RuntimeException("SpUtils can not be initialized");
    }


    private static SharedPreferences getSp(Context context) {
        SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        return sp;
    }

    private static void putInt(Context context, String key, Integer value) {
        getSp(context).edit().putInt(key, value).apply();
    }

    public static void putInt(String key, Integer value) {
        putInt(BaseApp.getContext(), key, value);

    }

    private static void putLong(Context context, String key, Long value) {
        getSp(context).edit().putLong(key, value).apply();
    }

    public static void putLong(String key, Long value) {
        putLong(BaseApp.getContext(), key, value);

    }


    private static void putBoolean(Context context, String key, Boolean value) {
        getSp(context).edit().putBoolean(key, value).apply();
    }

    public static void putBoolean(String key, Boolean value) {
        putBoolean(BaseApp.getContext(), key, value);
    }


    private static void putString(Context context, String key, String value) {
        getSp(context).edit().putString(key, value).apply();
    }

    public static void putString(String key, String value) {
        putString(BaseApp.getContext(), key, value);
    }

    private static Boolean getBoolean(Context context, String key) {

        return getSp(context).getBoolean(key, false);

    }

    public static Boolean getBoolean(String key) {
        return getBoolean(BaseApp.getContext(), key);
    }

    private static String getString(Context context, String key) {

        return getSp(context).getString(key, "");
    }

    public static String getString(String key) {
        return getString(BaseApp.getContext(), key);
    }

    private static Integer getInt(Context context, String key) {

        return getSp(context).getInt(key, 0);

    }


    public static Integer getInt(String key) {
        return getInt(BaseApp.getContext(), key);
    }


    private static Long getLong(Context context, String key) {

        return getSp(context).getLong(key, 0);

    }

    public static Long getLong(String key) {
        return getLong(BaseApp.getContext(), key);
    }

}
