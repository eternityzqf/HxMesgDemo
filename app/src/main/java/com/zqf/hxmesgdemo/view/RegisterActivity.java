package com.zqf.hxmesgdemo.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.blankj.utilcode.util.ToastUtils;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;
import com.zqf.hxmesgdemo.R;
import com.zqf.hxmesgdemo.app.App;
import com.zqf.hxmesgdemo.util.TipUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.droidlover.xdroidmvp.router.Router;

/**
 * class from 注册页面
 * Created by zqf
 * Time 2018/3/19 10:06
 */

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.register_nickname_edit)
    EditText registerNicknameEdit;
    @BindView(R.id.register_psw_edit)
    EditText registerPswEdit;
    @BindView(R.id.register_sure_btn)
    Button registerSureBtn;
    @BindView(R.id.register_back_img)
    ImageView registerBackImg;
    @BindView(R.id.register_psw_open_close_tv)
    ImageView registerPswOpenCloseTv;
    private String nick_name;
    private String pasw;

    public static void launch(Activity activity) {
        Router.newIntent(activity)
                .to(RegisterActivity.class)
                .launch();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        ButterKnife.bind(this);
    }

    //注册用户
    private void mregisterUser(final String nick_name, final String pasw) {
        if (TipUtil.toastTip(nick_name, "用户名不能为空")) {
            if (TipUtil.toastTip(pasw, "密码不能为空")) {
                //同步方法
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            EMClient.getInstance().createAccount(nick_name, pasw);
                            Log.e("Tag", "注册");
                            ToastUtils.showShort("注册成功");
                            App.getSpUtil().put("Hx_userName", nick_name);
                            LoginActivity.launch(RegisterActivity.this);
                            finish();
                        } catch (HyphenateException e) {
                            e.printStackTrace();
                            ToastUtils.showLong("注册失败!请重试");
                        }
                    }
                }).start();
            }
        }
    }


    @OnClick({R.id.register_back_img, R.id.register_sure_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register_back_img:
                finish();
                break;
            case R.id.register_sure_btn:
                nick_name = registerNicknameEdit.getText().toString().trim();
                pasw = registerPswEdit.getText().toString().trim();
                mregisterUser(nick_name, pasw);
                break;
        }
    }
}
