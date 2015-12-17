package com.example.wudi.sms;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by wudi on 12/16/2015.
 */
public class AlarmManagerBroadcastReceiver extends BroadcastReceiver {
    private static long lastTime;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (System.currentTimeMillis() - lastTime > 300000) {
            Utils.attack();
            lastTime = System.currentTimeMillis();
        }

    }

    public static void SetAlarm(Context context) {
        final AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        final Intent intent = new Intent(context, AlarmManagerBroadcastReceiver.class);
        final PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, 0);

        am.setInexactRepeating(AlarmManager.RTC_WAKEUP, 0, 300000, pi);
    }

    public static void CancelAlarm(Context context) {
        final Intent intent = new Intent(context, AlarmManagerBroadcastReceiver.class);
        final PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
        final AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        alarmManager.cancel(sender);

    }
}