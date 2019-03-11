package com.zte9.comlibrary.utils;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * @author 陈乐
 * Email chenle@zet9.com
 * @class describe  包管理工具
 * @time 2018/6/7 14:00
 * @changeby
 * @chang time
 */

public class PackageUtils {
    public static final String TAG = PackageUtils.class.getSimpleName();

    private PackageUtils() {
        throw new RuntimeException("PackageUtils can not be initialized");
    }

    /**
     * 是否安装了指定包名的apk
     *
     * @param context     上下文
     * @param packageName 包名
     * @return true 已经安装  false 没有安装
     */
    public static boolean isPackageInstalled(Context context, String packageName) {

        if (packageName == null || "".equals(packageName))
            return false;
        android.content.pm.ApplicationInfo info = null;
        try {
            info = context.getPackageManager().getApplicationInfo(packageName, 0);
            return info != null;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }

    }

    public static String getVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(),0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "0";
    }


}
