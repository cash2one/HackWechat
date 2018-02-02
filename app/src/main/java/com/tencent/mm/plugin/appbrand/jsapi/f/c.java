package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.config.a;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.j.e;
import com.tencent.mm.plugin.appbrand.j.i;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class c extends a {
    public static final int CTRL_INDEX = 242;
    public static final String NAME = "createRequestTask";

    protected final String agB() {
        StringBuilder stringBuilder = new StringBuilder();
        e.aiA();
        return stringBuilder.append(e.aiw()).toString();
    }

    protected final String agC() {
        return "requestTaskId";
    }

    public final void a(j jVar, JSONObject jSONObject, String str) {
        x.d("MicroMsg.JsApiCreateRequestTask", "JsApiCreateRequestTask");
        1 1 = new 1(this, System.currentTimeMillis(), jVar, str);
        String optString = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bh.ov(optString)) {
            x.e("MicroMsg.JsApiCreateRequestTask", "url is null");
            a(jVar, str, "url is null or nil");
            return;
        }
        AppBrandSysConfig appBrandSysConfig = jVar.irP.iqx;
        a aVar = jVar.irP.iqy;
        int optInt = jSONObject.optInt("timeout", 0);
        if (optInt <= 0) {
            optInt = i.a(appBrandSysConfig, aVar, 0);
        }
        if (optInt <= 0) {
            optInt = 60000;
        }
        if (appBrandSysConfig.iOq <= 0) {
            x.i("MicroMsg.JsApiCreateRequestTask", "maxRequestConcurrent <= 0 use default concurrent");
        }
        Map a = i.a(jSONObject, appBrandSysConfig);
        boolean a2 = i.a(appBrandSysConfig, jSONObject.optBoolean("__skipDomainCheck__", false));
        if (!a2 || i.a(appBrandSysConfig.iOA, optString)) {
            com.tencent.mm.plugin.appbrand.j.c cVar;
            if (e.aiA().tt(jVar.mAppId) == null) {
                p b = b(jVar);
                String str2 = null;
                if (!(b == null || b.jDS == null)) {
                    str2 = b.jDS.jFe;
                }
                com.tencent.mm.plugin.appbrand.j.c cVar2 = new com.tencent.mm.plugin.appbrand.j.c(jVar.mAppId, str2, jVar.irP.iqx);
                e aiA = e.aiA();
                String str3 = jVar.mAppId;
                if (!aiA.jhY.containsKey(str3)) {
                    aiA.jhY.put(str3, cVar2);
                }
                cVar = cVar2;
            } else {
                cVar = e.aiA().tt(jVar.mAppId);
            }
            x.i("MicroMsg.JsApiCreateRequestTask", "request url: %s", new Object[]{optString});
            if (cVar == null) {
                a(jVar, str, "create request error");
                return;
            } else if (a2) {
                cVar.a(jVar, this, optInt, jSONObject, a, appBrandSysConfig.iOA, 1, str, NAME);
                return;
            } else {
                x.i("MicroMsg.JsApiCreateRequestTask", "debug type, do not verify domains");
                cVar.a(jVar, this, optInt, jSONObject, a, null, 1, str, NAME);
                return;
            }
        }
        x.i("MicroMsg.JsApiCreateRequestTask", "not in domain url %s", new Object[]{optString});
        a(jVar, str, "url not in domain list");
    }

    private static void a(j jVar, String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("requestTaskId", str);
        hashMap.put("state", "fail");
        hashMap.put("errMsg", str2);
        String jSONObject = new JSONObject(hashMap).toString();
        f a = new a().a(jVar);
        a.mData = jSONObject;
        a.afs();
    }
}
