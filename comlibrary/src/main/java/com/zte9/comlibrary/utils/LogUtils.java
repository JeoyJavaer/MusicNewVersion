package com.zte9.comlibrary.utils;

import android.util.Log;

import com.zte9.library.BaseApp;
import com.zte9.library.BuildConfig;


/**
 * @author 陈乐
 * Email chenle@zet9.com
 * @class describe  用于日志输出
 * @time 2018/6/7 9:35
 * @changeby
 * @chang time
 */

public class LogUtils {

    private LogUtils() {
        throw new RuntimeException("LogUtils cannot be initialized");
    }


    public static void v(String msg) {
        Log.v(BaseApp.TAG,msg);
    }

    public static void v(String tag, String msg) {
        Log.v(tag,msg);
    }

    /**
     * 只有debug模式下才会有日志输出
     * @param msg  日志信息
     */
    public static void d(String msg) {
        if (BuildConfig.ISDEBUG) {
            Log.d(BaseApp.TAG,msg);
        }

    }

    /**
     *  只有debug模式下才会有日志输出
     * @param tag  标记
     * @param msg  信息
     */
    public static void d(String tag, String msg) {
        if (BuildConfig.ISDEBUG) {
            Log.d(tag,msg);
        }
    }


    public static void i(String msg) {
       Log.i(BaseApp.TAG,msg);
    }


    public static void i(String tag, String msg) {
        Log.i(tag,msg);
    }


    public static void w(String msg) {
        Log.w(BaseApp.TAG,msg);
    }

    public static void w(String tag, String msg) {
        Log.w(tag,msg);
    }


    public static void e(String msg) {
        Log.e(BaseApp.TAG,msg);
    }

    public static void e(String tag, String msg) {
        Log.e(tag,msg);
    }

    /**
     * 用于异常发生时的日志输出
     * @param tag  标签
     * @param methodName  发生异常的方法名
     * @param msg  异常信息
     */
    public static void exception(String tag, String methodName, String msg) {
        Log.e(tag,"%s occur exception:%s"+methodName+ msg);
    }
}
