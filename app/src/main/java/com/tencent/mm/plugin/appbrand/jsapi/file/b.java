package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.q.l;
import com.tencent.mm.sdk.f.e;
import org.json.JSONObject;

abstract class b<T extends d> extends a {
    final T jjs;

    public b(T t) {
        this.jjs = t;
    }

    public final void a(final j jVar, final JSONObject jSONObject, final int i) {
        e.post(new Runnable(this) {
            final /* synthetic */ b jjt;

            public final void run() {
                f$a b = this.jjt.jjs.b(jVar, jSONObject);
                l.a(jVar, b.values, this.jjt);
                jVar.E(i, this.jjt.e(b.fnL, b.values));
            }
        }, "AppBrandFileApi#" + getName());
    }
}
