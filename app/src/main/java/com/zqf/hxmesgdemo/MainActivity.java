package com.zqf.hxmesgdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //融云使用的测试Token
    //userId=110&name=test_zqf1,,,,,{"code":200,"userId":"110","token":"2xrJbivh4y2OiP8soOgCBTyVxJlibzMTwREYmTzFlZVxqMt2OUaMYveL2oMerbvx0YVTKaPw7kDOhKkaWirx3Q=="}
    //userId=111&name=test_zqf2,,,,,{"code":200,"userId":"111","token":"rNHfghkYn6ZZ2L9usjb+s6PJl4sd+uBnZECc0O4v3NLR93s/ctJLN4qYuCXtR2D8X1r5FX4h/aRdx92ZD/1ASw=="}
//    private String Token1 = "2xrJbivh4y2OiP8soOgCBTyVxJlibzMTwREYmTzFlZVxqMt2OUaMYveL2oMerbvx0YVTKaPw7kDOhKkaWirx3Q==";
//    private String Token2 = "rNHfghkYn6ZZ2L9usjb+s6PJl4sd+uBnZECc0O4v3NLR93s/ctJLN4qYuCXtR2D8X1r5FX4h/aRdx92ZD/1ASw==";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化连接

    }

//    private void login_user() {
//        EMClient.getInstance().login("hx1", "123", new EMCallBack() {//回调
//            @Override
//            public void onSuccess() {
//                EMClient.getInstance().groupManager().loadAllGroups();
//                EMClient.getInstance().chatManager().loadAllConversations();
//                Log.d("main", "登录聊天服务器成功！");
//                Mesg();
//            }
//
//            @Override
//            public void onProgress(int progress, String status) {
//
//            }
//
//            @Override
//            public void onError(int code, String message) {
//                Log.d("main", "登录聊天服务器失败！");
//            }
//        });
//    }
//
//    private void Mesg() {
//        EMClient.getInstance().chatManager().addMessageListener(msgListener);
//    }
//
//    EMMessageListener msgListener = new EMMessageListener() {
//
//        @Override
//        public void onMessageReceived(List<EMMessage> messages) {
//            //收到消息
//            Log.d("main", messages.toString());
//        }
//
//        @Override
//        public void onCmdMessageReceived(List<EMMessage> messages) {
//            //收到透传消息
//            Log.d("main", "透传" + messages.toString());
//        }
//
//        @Override
//        public void onMessageRead(List<EMMessage> messages) {
//            //收到已读回执
//        }
//
//        @Override
//        public void onMessageDelivered(List<EMMessage> message) {
//            //收到已送达回执
//        }
//
//        @Override
//        public void onMessageRecalled(List<EMMessage> messages) {
//            //消息被撤回
//        }
//
//        @Override
//        public void onMessageChanged(EMMessage message, Object change) {
//            //消息状态变动
//        }
//    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        EMClient.getInstance().chatManager().removeMessageListener(msgListener);
    }
}
