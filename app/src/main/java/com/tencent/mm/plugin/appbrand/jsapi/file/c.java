package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.b;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import org.json.JSONObject;

abstract class c<T extends d> extends l {
    private final T jjs;

    public c(T t) {
        this.jjs = t;
    }

    public final String a(j jVar, JSONObject jSONObject) {
        f$a b = this.jjs.b(jVar, jSONObject);
        com.tencent.mm.plugin.appbrand.q.l.a(jVar, b.values, (b) this);
        return e(b.fnL, b.values);
    }
}
