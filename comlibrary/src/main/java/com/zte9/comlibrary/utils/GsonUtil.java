package com.zte9.comlibrary.utils;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Response;

/**
 * @author wk
 * @version 创建时间：2017年7月19日 上午11:06:30 类说明
 */
public class GsonUtil {

    private static Gson gson = null;

    static {
        if (gson == null) {
            gson = new Gson();
        }
    }


    /**
     * 将gsonString转成泛型bean
     *
     * @param gsonString
     * @param cls
     * @return
     */
    public static <T> T GsonToBean(String gsonString, Class<T> cls) {
        T t = null;
        if (gson != null) {
            t = gson.fromJson(gsonString, cls);
        }
        return t;
    }

    public static <T> T GsonToBean(Response response, Class<T> cls) {
        try {
            T t = null;
            if (gson != null) {
                t = gson.fromJson(response.body().string(), cls);
            }
            return t;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
