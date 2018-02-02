package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.q.l;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import org.json.JSONObject;

abstract class d implements f {
    e jju = this;

    abstract f$a a(j jVar, String str, JSONObject jSONObject);

    d() {
    }

    static {
        e$a.init();
    }

    public final f$a b(j jVar, JSONObject jSONObject) {
        String o = o(jSONObject);
        if (bh.ov(o)) {
            return new f$a("fail invalid path", new Object[0]);
        }
        if (jVar.irP.mFinished) {
            return new f$a("fail:interrupted", new Object[0]);
        }
        f$a a = a(jVar, o, jSONObject);
        l.a(jVar, a.values, this.jju);
        return a;
    }

    protected String o(JSONObject jSONObject) {
        String optString = jSONObject.optString(DownloadInfoColumns.FILEPATH, null);
        if (bh.ov(optString)) {
            optString = jSONObject.optString("dirPath", null);
        }
        if (bh.ov(optString)) {
            return jSONObject.optString("path", null);
        }
        return optString;
    }
}
