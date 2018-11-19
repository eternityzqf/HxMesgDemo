package com.zqf.hxmesgdemo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.zqf.hxmesgdemo.R;
public class MainActivity extends AppCompatActivity {
    //融云使用的测试Token

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
