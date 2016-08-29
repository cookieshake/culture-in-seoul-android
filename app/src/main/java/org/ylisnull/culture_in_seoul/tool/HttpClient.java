package org.ylisnull.culture_in_seoul.tool;


import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpClient {
    OkHttpClient okHttpClient;

    public HttpClient() {
        this.okHttpClient = new OkHttpClient();
    }

    public String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = this.okHttpClient.newCall(request).execute();
        return response.body().string();
    }
}
