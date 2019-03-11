package com.zte9.comlibrary.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 陈乐  on 2019/3/11.
 * Email chenle@zet9.com
 * Description
 * Others
 */
public abstract class BaseFragment extends Fragment {

    protected View mRootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            this.mRootView = inflater.inflate(getLayoutRsId(), container, false);
        } else {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (parent != null) {
                parent.removeView(mRootView);
            }
        }
        return mRootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initOthers();
        loadData();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * 加载数据
     */
    protected abstract void loadData();

    /**
     * 初始化其他的比如监听器已经adapter等
     */
    protected abstract void initOthers();


    /**
     * 查找控件和焦点初始化
     *
     * @param view fragment的 根布局
     */
    protected abstract void initView(View view);


    /**
     * 获取布局
     *
     * @return 布局资源id
     */
    protected abstract int getLayoutRsId();


}
