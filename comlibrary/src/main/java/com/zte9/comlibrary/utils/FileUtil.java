package com.zte9.comlibrary.utils;

import android.text.TextUtils;

import java.io.File;


/**
 * Created by 陈乐  on 2018/6/4.
 * Email chenle@zet9.com
 * Description  文件管理类
 * Others
 */
public class FileUtil {

    /**
     * 删除指定文件夹
     * @param filePath  文件夹路径
     * @param deleteThisPath
     */
    public static void deleteFolderFile(String filePath, boolean deleteThisPath) {
        if (!TextUtils.isEmpty(filePath)) {
            try {
                File file = new File(filePath);
                if (file.isDirectory()) {// 处理目录
                    File files[] = file.listFiles();
                    for (int i = 0; i < files.length; i++) {
                        deleteFolderFile(files[i].getAbsolutePath(), true);
                    }
                }
                if (deleteThisPath) {
                    if (!file.isDirectory()) {// 如果是文件，删除
                        file.delete();
                    } else {// 目录
                        if (file.listFiles().length == 0) {// 目录下没有文件或者目录，删除
                            file.delete();
                        }
                    }
                }
            } catch (Exception e) {
                LogUtils.exception("fileUtil","deleteFolderFile","FileUtil deleteFolderFile exception:"+e.toString()+"   filePath:"+filePath+" deleteThisPath"+deleteThisPath);
            }
        }
    }
}
