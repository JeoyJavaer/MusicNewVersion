package com.zte9.comlibrary.http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.zte9.library.BaseApp;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

/**
 *   @author wxch
 *   @desc OkHttp3的获取类
 *   @date 2017/5/4 0004 下午 4:03
*/
public class OkHttp3Utils {

    private static OkHttpClient mOkHttpClient;

    //设置缓存目录
    //private static File cacheDirectory = new File(BaseApp.getInstance().getApplicationContext().getCacheDir().getAbsolutePath(), "MyCache");
    //private static Cache cache = new Cache(cacheDirectory, 10 * 1024 * 1024);
    private static long SIZE_OF_CACHE = 10 * 1024 * 1024; // 10 MiB
    //String cacheFile = BaseApp.getContextObject().getCacheDir()+"/http";
    //private static String cacheFile = BaseApp.getInstance().getApplicationContext().getCacheDir().getAbsolutePath()+"MyCache";
    //private static Cache cache = new Cache(new File(cacheFile), SIZE_OF_CACHE);

    /**
     * 获取OkHttpClient对象
     *
     * @return
     */
    public static OkHttpClient getOkHttpClient(String cacheFile) {
        Cache cache = new Cache(new File(cacheFile), SIZE_OF_CACHE);

        if (null == mOkHttpClient) {
            //同样okhttp3后也使用build设计模式
            mOkHttpClient = new OkHttpClient.Builder()
                //设置一个自动管理cookies的管理器
//                .cookieJar(new CookiesManager())
                //添加拦截器
                .addInterceptor(CachingControlInterceptor.REWRITE_RESPONSE_INTERCEPTOR_OFFLINE)
                    //添加网络连接器
                .addNetworkInterceptor(CachingControlInterceptor.REWRITE_RESPONSE_INTERCEPTOR)
                //.addNetworkInterceptor(new CookiesInterceptor(MyApplication.getInstance().getApplicationContext()))
                //设置请求读写的超时时间
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
//                .cache(cache)
                .build();
        }
        return mOkHttpClient;
    }

    /**
     * 自动管理Cookies
     */
    private static class CookiesManager implements CookieJar {
        private final PersistentCookieStore cookieStore = new PersistentCookieStore(BaseApp.getContext());

        @Override
        public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
            if (cookies != null && cookies.size() > 0) {
                for (Cookie item : cookies) {
                    cookieStore.add(url, item);
                }
            }
        }

        @Override
        public List<Cookie> loadForRequest(HttpUrl url) {
            List<Cookie> cookies = cookieStore.get(url);
            return cookies;
        }
    }

    /**
     * 判断网络是否可用
     *
     * @param context Context对象
     */
    public static Boolean isNetworkReachable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo current = cm.getActiveNetworkInfo();
        if (current == null) {
            return false;
        }
        return (current.isAvailable());
    }
}
