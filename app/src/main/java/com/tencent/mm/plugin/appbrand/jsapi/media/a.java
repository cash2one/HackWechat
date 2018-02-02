package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import org.json.JSONObject;

abstract class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    abstract boolean l(Context context, String str, String str2);

    abstract boolean su(String str);

    a() {
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString(DownloadInfoColumns.FILEPATH, "");
        if (bh.ov(optString)) {
            jVar.E(i, e("fail filePath invalid", null));
        } else {
            c.Dm().F(new 1(this, jVar, optString, i));
        }
    }
}
