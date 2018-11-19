package com.zqf.hxmesgdemo.util;

import android.text.TextUtils;

import com.blankj.utilcode.util.ToastUtils;

/**
 * class from
 * Created by zqf
 * Time 2018/5/17 9:38
 */

public class TipUtil {

    //判断getText的值是否
    public static boolean toastTip(String params, String tip_msg) {
        if (TextUtils.isEmpty(params) || params.equals("null")) {
            ToastUtils.showShort(tip_msg);
        } else {
            return true;
        }
        return false;
    }
}
