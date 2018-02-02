package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.plugin.appbrand.q.f.a;
import java.util.HashMap;
import java.util.Map;

class a$b$1 implements a {
    final /* synthetic */ j iZy;
    final /* synthetic */ b jqr;

    a$b$1(b bVar, j jVar) {
        this.jqr = bVar;
        this.iZy = jVar;
    }

    public final boolean g(Object... objArr) {
        float[] fArr = (float[]) objArr[0];
        Map hashMap = new HashMap();
        hashMap.put("x", Float.valueOf((-fArr[0]) / 10.0f));
        hashMap.put("y", Float.valueOf((-fArr[1]) / 10.0f));
        hashMap.put("z", Float.valueOf((-fArr[2]) / 10.0f));
        this.jqr.jqq.v(hashMap);
        return c.agI().a(this.jqr.jqq, this.iZy);
    }
}
