package com.zqf.hxmesgdemo.view;

import android.app.Activity;
import android.os.Bundle;

import com.hyphenate.easeui.ui.EaseBaseActivity;
import com.zqf.hxmesgdemo.R;

import cn.droidlover.xdroidmvp.router.Router;

public class MainActivity extends EaseBaseActivity {
    //融云使用的测试Token

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public static void launch(Activity activity) {
        Router.newIntent(activity)
                .to(MainActivity.class)
                .launch();
    }
}
