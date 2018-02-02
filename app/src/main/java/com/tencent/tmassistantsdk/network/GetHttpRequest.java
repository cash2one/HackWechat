package com.tencent.tmassistantsdk.network;

import android.text.TextUtils;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONObject;

public abstract class GetHttpRequest {
    protected static final String REQUEST_SERVER_URL = "http://appicsh.qq.com/cgi-bin/appstage/yyb_get_userapp_info";
    protected static final String TAG = "NetworkTask";
    protected HttpGet mHttpGet = null;

    protected abstract void onFinished(JSONObject jSONObject, int i);

    protected synchronized boolean sendData(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.mHttpGet == null) {
                new Thread(new 1(this, str)).start();
            }
        }
        return false;
    }
}
