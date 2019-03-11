package com.zte9.comlibrary.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by 陈乐
 * Email chenle@zet9.com  加载图片的工具
 * Description
 * Others
 */
public class PictureUtil {
    public static final String TAG = PictureUtil.class.getSimpleName();

    /**
     * 加载没有默认图片
     *
     * @param context   上下文
     * @param url
     * @param imageView
     */
    public static void loadImage(Context context, String url, ImageView imageView) {
        try {
            Glide.with(context)
                    .load(url)
                    .dontAnimate()
                    .centerCrop()
                    .into(imageView);
        } catch (Exception e) {
            LogUtils.exception(TAG,"loadImage",e.toString());
        }

    }

    public static void loadImage(Context context, int resourceID, ImageView imageView) {
        try {
            Glide.with(context)
                    .load(resourceID)
                    .placeholder(resourceID)
                    .dontAnimate()
                    .into(imageView);
        } catch (Exception e) {
            LogUtils.exception(TAG,"loadImage",e.toString());
        }

    }

    /**
     * 加载含有默认的图片
     *
     * @param context
     * @param url
     * @param imageView
     * @param defaultImage
     */
    public static void loadImgWithDefault(Context context, String url, ImageView imageView, int defaultImage) {
        try {
            Glide.with(context)
                    .load(url)
                    .error(defaultImage)
                    .centerCrop()
                    .dontAnimate()
                    .into(imageView);
        } catch (Exception e) {
            LogUtils.exception(TAG,"loadImgWithDefault",e.toString());
        }
    }

    /**
     * 加载含有占位图片的图片
     *
     * @param context
     * @param url
     * @param imageView
     * @param defaultImage
     */
    public static void loadImage(Context context, String url, ImageView imageView, int defaultImage) {
        try {
            Glide.with(context)
                    .load(url)
                    .placeholder(defaultImage)
                    .error(defaultImage)
                    .centerCrop()
                    .dontAnimate()
                    .into(imageView);
        } catch (Exception e) {
            LogUtils.exception(TAG,"loadImage",e.toString());
        }

    }

    /**
     * 加载图片不缓存
     *
     * @param context
     * @param url
     * @param imageView
     * @param defaultImage
     */
    public static void loadImgNoCache(Context context, String url, ImageView imageView, int defaultImage) {

        try {
            Glide.clear(imageView);
            Glide.with(context)
                    .load(url)
                    .skipMemoryCache(true)
                    .centerCrop()
                    .dontAnimate()
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .error(defaultImage)
                    .into(imageView);
        } catch (Exception e) {
            LogUtils.exception(TAG,"loadImgNoCache",e.toString());
        }
    }


}
