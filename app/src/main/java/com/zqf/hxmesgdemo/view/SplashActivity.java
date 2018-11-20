package com.zqf.hxmesgdemo.view;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;

import com.hyphenate.chat.EMClient;
import com.zqf.hxmesgdemo.R;
import com.zqf.hxmesgdemo.app.App;

import cn.droidlover.xdroidmvp.mvp.XActivity;

/**
 * Author：zqf
 * Time：2018/11/20 09:51
 * desc：
 */
public class SplashActivity extends XActivity {
    private Handler handler = new Handler();

    @Override
    public void initData(Bundle savedInstanceState) {
        if (!TextUtils.isEmpty(App.getSpUtil().getString("Hx_userName", ""))) {
            EMClient.getInstance().groupManager().loadAllGroups();
            EMClient.getInstance().chatManager().loadAllConversations();
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!TextUtils.isEmpty(App.getSpUtil().getString("Hx_userName", ""))) {
                    MainActivity.launch(SplashActivity.this);
                } else {
                    RegisterActivity.launch(SplashActivity.this);
                }
            }
        }, 2 * 1000);

        finish();
    }

    @Override
    public int getLayoutId() {
        return R.layout.splash_layout;
    }

    @Override
    public Object newP() {
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            handler = null;
        }
    }
}
