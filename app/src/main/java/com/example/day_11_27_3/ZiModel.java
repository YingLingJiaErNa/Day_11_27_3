package com.example.day_11_27_3;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
* Created by TMVPHelper on 2017/11/27
*/
public class ZiModel implements ZiContract.Model{
    public OkHttpClient client;

    @Override
    public void getDataFromNet(String url, final Callbacks callbacks) {
        client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
//                App.mActivity.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
                            callbacks.succ(response.body().string());
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
            }
        });
    }
}