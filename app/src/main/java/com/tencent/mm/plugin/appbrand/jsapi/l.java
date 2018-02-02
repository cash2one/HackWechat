package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.p;
import org.json.JSONObject;

public class l extends e {
    public Thread jck;

    public String a(c cVar, JSONObject jSONObject) {
        if (cVar instanceof j) {
            this.jck = Thread.currentThread();
            return a((j) cVar, jSONObject);
        } else if (cVar instanceof p) {
            return a((p) cVar);
        } else {
            return "";
        }
    }

    public String a(j jVar, JSONObject jSONObject) {
        return "";
    }

    public String a(p pVar) {
        return "";
    }
}
