package com.tencent.xweb.x5.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.xweb.x5.a.d;
import com.tencent.xweb.x5.sdk.d.a;
import java.util.HashMap;
import java.util.Map;

public final class e implements a {
    public final void a(Context context, a aVar) {
        QbSdk.preInit(context, new b(aVar));
    }

    public final void clearAllWebViewCache(Context context, boolean z) {
        QbSdk.clearAllWebViewCache(context, z);
    }

    public final void reset(Context context) {
        QbSdk.reset(context);
    }

    public final boolean getTBSInstalling() {
        return QbSdk.getTBSInstalling();
    }

    public final int getTbsVersion(Context context) {
        return QbSdk.getTbsVersion(context);
    }

    public final void a(h hVar) {
        QbSdk.setTbsListener(new a(hVar));
    }

    public final int startMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        return QbSdk.startMiniQBToLoadUrl(context, str, hashMap, valueCallback);
    }

    public final boolean a(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        return QbSdk.startQbOrMiniQBToLoadUrl(context, str, hashMap, new d(valueCallback));
    }

    public final void a(Context context, String str, ValueCallback<Boolean> valueCallback) {
        QbSdk.canOpenFile(context, str, new d(valueCallback));
    }

    public final boolean isTbsCoreInited() {
        return QbSdk.isTbsCoreInited();
    }

    public final void initTbsSettings(Map<String, Object> map) {
        QbSdk.initTbsSettings(map);
    }

    public final boolean canOpenWebPlus(Context context) {
        return QbSdk.canOpenWebPlus(context);
    }

    public final void closeFileReader(Context context) {
        QbSdk.closeFileReader(context);
    }

    public final void forceSysWebView() {
        QbSdk.forceSysWebView();
    }

    public final String getMiniQBVersion(Context context) {
        return QbSdk.getMiniQBVersion(context);
    }
}
