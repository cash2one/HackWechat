package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.j.c;
import com.tencent.mm.plugin.appbrand.j.c.a;
import com.tencent.mm.plugin.appbrand.j.e;
import com.tencent.mm.plugin.appbrand.jsapi.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.q.l;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class c$1 implements a {
    final /* synthetic */ j iZy;
    final /* synthetic */ long jov;
    final /* synthetic */ String jow;
    final /* synthetic */ c jox;

    c$1(c cVar, long j, j jVar, String str) {
        this.jox = cVar;
        this.jov = j;
        this.iZy = jVar;
        this.jow = str;
    }

    public final void sC(String str) {
        int i;
        String str2 = "MicroMsg.JsApiCreateRequestTask";
        String str3 = "onRequestResult, time: %d, data size: %d";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(System.currentTimeMillis() - this.jov);
        if (str == null) {
            i = 0;
        } else {
            i = str.length();
        }
        objArr[1] = Integer.valueOf(i);
        x.d(str2, str3, objArr);
        c tt = e.aiA().tt(this.iZy.mAppId);
        if (tt == null || !tt.to(this.jow)) {
            c.c(this.iZy, this.jow, str);
            return;
        }
        x.d("MicroMsg.JsApiCreateRequestTask", "request abort %s", new Object[]{this.jow});
    }

    public final void a(String str, Object obj, int i, JSONObject jSONObject) {
        int length;
        if (obj != null && (obj instanceof ByteBuffer)) {
            length = ((ByteBuffer) obj).array().length;
        } else if (obj == null || !(obj instanceof String)) {
            length = 0;
        } else {
            length = ((String) obj).length();
        }
        x.d("MicroMsg.JsApiCreateRequestTask", "onRequestResult, time: %d, data size: %d, code %s,reqrestId %s", new Object[]{Long.valueOf(System.currentTimeMillis() - this.jov), Integer.valueOf(length), Integer.valueOf(i), this.jow});
        Map hashMap = new HashMap();
        hashMap.put("requestTaskId", this.jow);
        if (str.equalsIgnoreCase("ok")) {
            hashMap.put("state", "success");
            hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, obj);
        } else {
            hashMap.put("state", "fail");
        }
        hashMap.put("statusCode", Integer.valueOf(i));
        if (jSONObject != null) {
            hashMap.put("header", jSONObject);
        }
        b com_tencent_mm_plugin_appbrand_jsapi_f_c_a = new c$a();
        if ((obj != null && (obj instanceof String)) || l.a(this.iZy, hashMap, com_tencent_mm_plugin_appbrand_jsapi_f_c_a)) {
            String jSONObject2 = new JSONObject(hashMap).toString();
            f a = com_tencent_mm_plugin_appbrand_jsapi_f_c_a.a(this.iZy);
            a.mData = jSONObject2;
            a.afs();
        }
    }
}
