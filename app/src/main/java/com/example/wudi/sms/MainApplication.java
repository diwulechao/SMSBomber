package com.example.wudi.sms;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.igexin.sdk.PushService;

/**
 * Created by wudi on 12/16/2015.
 */
public class MainApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        Utils.init();

        if (!TextUtils.isEmpty(Utils.getNumber(context))) {

            AlarmManagerBroadcastReceiver.SetAlarm(context);

            Intent intent = new Intent(context, PushService.class);
            startService(intent);

            Intent intent2 = new Intent(context, com.baidu.android.pushservice.PushService.class);
            startService(intent2);
        }
    }
}
