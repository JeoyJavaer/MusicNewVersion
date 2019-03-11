package com.zte9.comlibrary.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.zte9.comlibrary.R;

import java.util.Timer;
import java.util.TimerTask;


public class ToastUtil {

    private static Context sAppCtx;
    private static Toast   toast;

    public static void initAppCtx(Context context) {
        sAppCtx = context.getApplicationContext();
    }

    /**
     * 自定义Toast显示
     *
     * @param text
     */
    @SuppressLint("InflateParams")
    public static void show(CharSequence text) {
        View view = LayoutInflater.from(sAppCtx).inflate(R.layout.toast_view, null);
        if (view != null) {
            TextView textView = (TextView) view.findViewById(R.id.toast_text);
            textView.setText(text);
        }
        if (toast == null) {
            toast = Toast.makeText(sAppCtx, text, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
        }
        toast.setView(view);
        toast.show();
    }

    @SuppressLint("InflateParams")
    public static void showTime(CharSequence text, int duration) {
        View view = LayoutInflater.from(sAppCtx).inflate(R.layout.toast_view, null);
        if (view != null) {
            TextView textView = (TextView) view.findViewById(R.id.toast_text);
            textView.setText(text);
        }
        Toast tempToast = Toast.makeText(sAppCtx, text, duration);
        tempToast.setGravity(Gravity.CENTER, 0, 0);
        tempToast.setView(view);
        tempToast.show();

    }

    /**
     * 自定义Toast显示
     *
     * @param text
     */
    @SuppressLint("InflateParams")
    public static void showLong(CharSequence text) {
        View view = LayoutInflater.from(sAppCtx).inflate(R.layout.toast_view,
                null);
        if (view != null) {
            TextView textView = (TextView) view.findViewById(R.id.toast_text);
            textView.setText(text);
        }
        if (toast == null) {
            toast = Toast.makeText(sAppCtx, text, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
        }
        toast.setView(view);
        toast.show();
    }

    public static void showMyToast(final Toast tast, final int cnt) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                tast.show();
            }
        }, 0, 3000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                tast.cancel();
                timer.cancel();
            }
        }, cnt);

    }

}
