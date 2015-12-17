package com.example.wudi.sms;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.example.wudi.sms.sites.CFChina;
import com.example.wudi.sms.sites.Dib66;
import com.example.wudi.sms.sites.Dtd;
import com.example.wudi.sms.sites.Guangxin;
import com.example.wudi.sms.sites.Hepanda;
import com.example.wudi.sms.sites.Huanghe;
import com.example.wudi.sms.sites.Hurbao;
import com.example.wudi.sms.sites.IAttack;
import com.example.wudi.sms.sites.Junrong;
import com.example.wudi.sms.sites.Phtfdata;
import com.example.wudi.sms.sites.Qian88;
import com.example.wudi.sms.sites.Qianhezi;
import com.example.wudi.sms.sites.Rjs;
import com.example.wudi.sms.sites.Yueyuedai;
import com.example.wudi.sms.sites.Zhiwang;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wudi on 12/16/2015.
 */
public class Utils {

    private static List<IAttack> attacks;

    public static void init() {
        if (attacks != null) return;
        attacks = new ArrayList<>();
        attacks.add(new CFChina());
        attacks.add(new Hepanda());
        attacks.add(new Huanghe());
        attacks.add(new Hurbao());
        attacks.add(new Junrong());
        attacks.add(new Phtfdata());
        attacks.add(new Qianhezi());
        attacks.add(new Rjs());
        attacks.add(new Yueyuedai());
        attacks.add(new Zhiwang());
        attacks.add(new Guangxin());
        attacks.add(new Qian88());
        attacks.add(new Dib66());
        attacks.add(new Dtd());
    }

    public static void attack() {
        if (TextUtils.isEmpty(getNumber(MainApplication.context))) return;
        for (IAttack attack : attacks) {
            try {
                attack.attack();
                Log.d("hello", attack.getClass().getSimpleName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String getNumber(Context context) {
        SharedPreferences my = context.getSharedPreferences("test",
                Activity.MODE_PRIVATE);

        return my.getString("number", "");
    }
}
