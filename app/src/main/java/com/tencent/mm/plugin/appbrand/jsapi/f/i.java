package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.j.f;
import com.tencent.mm.plugin.appbrand.j.g;
import com.tencent.mm.plugin.appbrand.j.h;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class i extends a {
    public static final int CTRL_INDEX = 273;
    public static final String NAME = "operateUploadTask";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiOperateUploadTask", "JsApiOperateUploadTask");
        if (jSONObject == null) {
            jVar.E(i, e("fail:data is null", null));
            x.e("MicroMsg.JsApiOperateUploadTask", "data is null");
            return;
        }
        String optString = jSONObject.optString("uploadTaskId");
        if (bh.ov(optString)) {
            x.e("MicroMsg.JsApiOperateUploadTask", "uploadTaskId is null");
            jVar.E(i, e("fail:uploadTaskId is null or nil", null));
            return;
        }
        String optString2 = jSONObject.optString("operationType");
        if (bh.ov(optString2)) {
            x.e("MicroMsg.JsApiOperateUploadTask", "operationType is null");
            jVar.E(i, e("fail:operationType is null or nil", null));
        } else if (optString2.equals("abort")) {
            f tv = h.aiC().tv(jVar.mAppId);
            if (tv == null) {
                x.i("MicroMsg.JsApiOperateUploadTask", "upload is null");
                jVar.E(i, e("fail:no task", null));
                return;
            }
            g tu = tv.tu(optString);
            if (tu == null) {
                x.i("MicroMsg.JsApiOperateUploadTask", "uploadInfo is null %s", new Object[]{optString});
                jVar.E(i, e("fail:no task", null));
                return;
            }
            tv.a(tu);
            jVar.E(i, e("ok", null));
            Map hashMap = new HashMap();
            hashMap.put("uploadTaskId", optString);
            hashMap.put("state", "fail");
            hashMap.put("errMsg", "abort");
            optString2 = new JSONObject(hashMap).toString();
            com.tencent.mm.plugin.appbrand.jsapi.f a = new e.a().a(jVar);
            a.mData = optString2;
            a.afs();
            x.d("MicroMsg.JsApiOperateUploadTask", "abortTask finish %s", new Object[]{optString});
        } else {
            jVar.E(i, e("fail:unknown operationType", null));
        }
    }
}
