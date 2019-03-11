package com.zte9.comlibrary;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.zte9.comlibrary.utils.DensityUtil;
import com.zte9.comlibrary.utils.ToastUtil;


/**
 * Created by 陈乐  on
 * Email chenle@zet9.com
 * Description
 * Others
 */
public class BaseApp extends Application {

    @SuppressLint("StaticFieldLeak")
    private static      Context sContext;
    public static final String  TAG = BaseApp.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        ToastUtil.initAppCtx(this);
        DensityUtil.init(this);
    }


    public static Context getContext() {
        return sContext;
    }
}
