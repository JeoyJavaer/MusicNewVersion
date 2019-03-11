package com.zte9.comlibrary.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 陈乐  on 2019/3/11.
 * Email chenle@zet9.com
 * Description
 * Others
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        initView();
        initOthers();
        loadData();
    }

    /**
     * 加载数据
     */
    protected abstract void loadData();

    /**
     * 初始化其他东西
     */
    protected abstract void initOthers();

    /**
     * 初始化控件已经焦点
     */
    protected abstract void initView();

    /**
     * 获取布局的id
     *
     * @return 布局id
     */
    @LayoutRes
    protected abstract int getLayoutResourceId();


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
