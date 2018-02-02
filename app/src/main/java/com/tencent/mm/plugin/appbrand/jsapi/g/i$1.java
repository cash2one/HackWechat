package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.g.b.b;
import java.util.HashMap;
import java.util.Map;

class i$1 implements b {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ i jpi;

    i$1(i iVar, j jVar, int i) {
        this.jpi = iVar;
        this.iZy = jVar;
        this.gOK = i;
    }

    public final void d(boolean z, String str) {
        if (z) {
            Map hashMap = new HashMap(1);
            hashMap.put("token", str);
            this.iZy.E(this.gOK, this.jpi.e("ok", hashMap));
            return;
        }
        this.iZy.E(this.gOK, this.jpi.e("fail", null));
    }
}
