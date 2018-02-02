package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.j.b;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends a {
    public static final int CTRL_INDEX = 270;
    public static final String NAME = "operateDownloadTask";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiOperateDownloadTask", "JsApiOperateDownloadTask");
        if (jSONObject == null) {
            jVar.E(i, e("fail:data is null", null));
            x.e("MicroMsg.JsApiOperateDownloadTask", "data is null");
            return;
        }
        String optString = jSONObject.optString("downloadTaskId");
        if (bh.ov(optString)) {
            x.e("MicroMsg.JsApiOperateDownloadTask", "downloadTaskId is null");
            jVar.E(i, e("fail:downloadTaskId is null or nil", null));
            return;
        }
        String optString2 = jSONObject.optString("operationType");
        if (bh.ov(optString2)) {
            x.e("MicroMsg.JsApiOperateDownloadTask", "operationType is null");
            jVar.E(i, e("fail:operationType is null or nil", null));
        } else if (optString2.equals("abort")) {
            com.tencent.mm.plugin.appbrand.j.a tq = b.aix().tq(jVar.mAppId);
            if (tq == null) {
                jVar.E(i, e("fail:no task", null));
                x.w("MicroMsg.JsApiOperateDownloadTask", "download is null");
                return;
            }
            com.tencent.mm.plugin.appbrand.j.a.b tn = tq.tn(optString);
            if (tn == null) {
                jVar.E(i, e("fail:no task", null));
                x.w("MicroMsg.JsApiOperateDownloadTask", "downloadWorker is null %s", new Object[]{optString});
                return;
            }
            tq.a(tn);
            jVar.E(i, e("ok", null));
            Map hashMap = new HashMap();
            hashMap.put("downloadTaskId", optString);
            hashMap.put("state", "fail");
            hashMap.put("errMsg", "abort");
            optString2 = new JSONObject(hashMap).toString();
            com.tencent.mm.plugin.appbrand.jsapi.f a = new b.a().a(jVar);
            a.mData = optString2;
            a.afs();
            x.d("MicroMsg.JsApiOperateDownloadTask", "abortTask finish %s", new Object[]{optString});
        } else {
            jVar.E(i, e("fail:unknown operationType", null));
        }
    }
}
