package com.zqf.hxmesgdemo.view;

import android.app.Activity;
import android.os.Bundle;

import com.zqf.hxmesgdemo.R;

import cn.droidlover.xdroidmvp.mvp.XActivity;
import cn.droidlover.xdroidmvp.router.Router;

/**
 * Author：zqf
 * Time：2018/11/20 10:11
 * desc：
 */
public class LoginActivity extends XActivity {
    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.login_layout;
    }

    @Override
    public Object newP() {
        return null;
    }

    public static void launch(Activity activity) {
        Router.newIntent(activity)
                .to(LoginActivity.class)
                .launch();
    }
}
