package com.tencent.xweb.x5.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import java.util.HashMap;
import java.util.Map;

public interface a {
    void a(Context context, com.tencent.xweb.x5.sdk.d.a aVar);

    void a(Context context, String str, ValueCallback<Boolean> valueCallback);

    void a(h hVar);

    boolean a(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback);

    boolean canOpenWebPlus(Context context);

    void clearAllWebViewCache(Context context, boolean z);

    void closeFileReader(Context context);

    void forceSysWebView();

    String getMiniQBVersion(Context context);

    boolean getTBSInstalling();

    int getTbsVersion(Context context);

    void initTbsSettings(Map<String, Object> map);

    boolean isTbsCoreInited();

    void reset(Context context);

    int startMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback);
}
