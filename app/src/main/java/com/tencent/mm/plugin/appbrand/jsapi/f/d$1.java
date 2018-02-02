package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.mm.plugin.appbrand.b.a;
import com.tencent.mm.plugin.appbrand.b.b$a;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class d$1 implements b$a {
    final /* synthetic */ j iZy;
    final /* synthetic */ String jbj;
    final /* synthetic */ com.tencent.mm.plugin.appbrand.j.j joy;
    final /* synthetic */ d joz;

    d$1(d dVar, com.tencent.mm.plugin.appbrand.j.j jVar, String str, j jVar2) {
        this.joz = dVar;
        this.joy = jVar;
        this.jbj = str;
        this.iZy = jVar2;
    }

    public final void a(a aVar) {
        if (aVar == a.SUSPEND || aVar == a.DESTROYED) {
            com.tencent.mm.plugin.appbrand.j.j jVar = this.joy;
            com.tencent.mm.plugin.appbrand.r.a.a tA = this.joy.tA(this.jbj);
            if (tA != null) {
                try {
                    x.i("MicroMsg.AppBrandNetworkWebSocket", "try to close socket");
                    tA.close();
                } catch (Exception e) {
                    x.e("MicroMsg.AppBrandNetworkWebSocket", "send error" + e.toString());
                    com.tencent.mm.plugin.appbrand.j.j.c(tA);
                }
                jVar.b(tA);
            }
            Map hashMap = new HashMap();
            hashMap.put("reason", "interrupted");
            hashMap.put("socketTaskId", this.jbj);
            hashMap.put("state", "close");
            String jSONObject = new JSONObject(hashMap).toString();
            f a = new d.a().a(this.iZy);
            a.mData = jSONObject;
            a.afs();
        }
    }
}
