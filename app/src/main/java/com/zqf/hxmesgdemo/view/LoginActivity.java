package com.zqf.hxmesgdemo.view;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyphenate.EMCallBack;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.zqf.hxmesgdemo.R;
import com.zqf.hxmesgdemo.app.App;
import com.zqf.hxmesgdemo.util.TipUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.droidlover.xdroidmvp.mvp.XActivity;
import cn.droidlover.xdroidmvp.router.Router;

/**
 * Author：zqf
 * Time：2018/11/20 10:11
 * desc：
 */
public class LoginActivity extends XActivity {


    @BindView(R.id.title_back_img)
    ImageView titleBackImg;
    @BindView(R.id.title_name_tv)
    TextView titleNameTv;
    @BindView(R.id.login_nickname_edit)
    EditText loginNicknameEdit;
    @BindView(R.id.login_psw_edit)
    EditText loginPswEdit;
    @BindView(R.id.login_sure_btn)
    Button loginSureBtn;

    @Override
    public void initData(Bundle savedInstanceState) {
        if (!TextUtils.isEmpty(App.getSpUtil().getString("Hx_userName", ""))) {
            loginNicknameEdit.setText(App.getSpUtil().getString("Hx_userName"));
        }
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

    //登录环信
    private void LoginHx(String nick, String psw) {
        EMClient.getInstance().login(nick, psw, new EMCallBack() {//回调
            @Override
            public void onSuccess() {
                EMClient.getInstance().groupManager().loadAllGroups();
                EMClient.getInstance().chatManager().loadAllConversations();
                Log.e("Tag", "登录聊天服务器成功！");
                MainActivity.launch(LoginActivity.this);
                Mesg();
                finish();
            }

            @Override
            public void onProgress(int progress, String status) {

            }

            @Override
            public void onError(int code, String message) {
                Log.e("Tag", "登录聊天服务器失败！");
            }
        });
    }


    @OnClick({R.id.title_back_img, R.id.login_sure_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back_img:
                finish();
                break;
            case R.id.login_sure_btn:
                Log.e("Tag", "登录");
                String nick = loginNicknameEdit.getText().toString();
                String psw = loginPswEdit.getText().toString();
                if (TipUtil.toastTip(nick, "请输入用户名!")) {
                    if (TipUtil.toastTip(psw, "请输入密码¬!")) {
                        LoginHx(nick, psw);
                    }
                }
                break;
        }
    }

    private void Mesg() {
        EMClient.getInstance().chatManager().addMessageListener(msgListener);
    }

    EMMessageListener msgListener = new EMMessageListener() {

        @Override
        public void onMessageReceived(List<EMMessage> messages) {
            //收到消息
            Log.e("Tag", messages.toString());
        }

        @Override
        public void onCmdMessageReceived(List<EMMessage> messages) {
            //收到透传消息
            Log.e("Tag", "透传" + messages.toString());
        }

        @Override
        public void onMessageRead(List<EMMessage> messages) {
            //收到已读回执
        }

        @Override
        public void onMessageDelivered(List<EMMessage> message) {
            //收到已送达回执
        }

        @Override
        public void onMessageRecalled(List<EMMessage> messages) {
            //消息被撤回
        }

        @Override
        public void onMessageChanged(EMMessage message, Object change) {
            //消息状态变动
        }
    };
}
