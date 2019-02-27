package com.zte9.music;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";

    private String[]            titles    = new String[]{"热推", "MV", "演唱会", "KTV", "儿歌", "广场舞"};
    private Button              mBtnShow;
    private TabLayout           mTabLayout;
    private ViewPager           mViewPager;
    private ImageView           mIvBg;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private FmPagerAdapter      pagerAdapter;
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 100) {
                Log.i(TAG, "handleMessage " + SystemClock.currentThreadTimeMillis());
                initData();
            }
        }
    };

    Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            Log.i(TAG, "runnable start" + SystemClock.currentThreadTimeMillis());
            try {
                Thread.sleep(2000);
                Log.i(TAG, "runnable after sleep" + SystemClock.currentThreadTimeMillis());
                mHandler.sendEmptyMessage(100);
            } catch (Exception e) {

            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Log.i(TAG, "postAtTime" + SystemClock.currentThreadTimeMillis());
        mHandler.postAtTime(mRunnable, 800);
        //        initData();

    }

    private void initData() {
        TabFragment fragment;
        Bundle bundle;
        for (int i = 0; i < titles.length; i++) {
            bundle = new Bundle();
            bundle.putString("content", titles[i]);
            fragment = new TabFragment();
            fragment.setArguments(bundle);
            fragments.add(fragment);
            mTabLayout.addTab(mTabLayout.newTab());
        }

        mTabLayout.setupWithViewPager(mViewPager, false);
        pagerAdapter = new FmPagerAdapter(fragments, getSupportFragmentManager());
        mViewPager.setAdapter(pagerAdapter);

        for (int i = 0; i < titles.length; i++) {
            mTabLayout.getTabAt(i).setText(titles[i]);
        }
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.i(TAG, "position:" + tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        mIvBg.setVisibility(View.GONE);
    }

    private void initView() {
        mBtnShow = (Button) findViewById(R.id.btn_show);
        mTabLayout = (TabLayout) findViewById(R.id.tablayout);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mIvBg = (ImageView) findViewById(R.id.iv_bg);
    }


}
