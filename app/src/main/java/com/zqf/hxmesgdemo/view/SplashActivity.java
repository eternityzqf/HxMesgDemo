package com.zqf.hxmesgdemo.view;

import android.os.Bundle;

import com.zqf.hxmesgdemo.R;

import cn.droidlover.xdroidmvp.mvp.XActivity;

/**
 * Author：zqf
 * Time：2018/11/20 09:51
 * desc：
 */
public class SplashActivity extends XActivity {
    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.splash_layout;
    }

    @Override
    public Object newP() {
        return null;
    }
}
