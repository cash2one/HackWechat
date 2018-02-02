package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.g.b.a;
import java.util.Map;

class c$1 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ c jpb;

    c$1(c cVar, j jVar, int i) {
        this.jpb = cVar;
        this.iZy = jVar;
        this.gOK = i;
    }

    public final void a(int i, String str, Map<String, Object> map) {
        switch (i) {
            case 1:
                this.iZy.E(this.gOK, this.jpb.e("ok", null));
                return;
            default:
                this.iZy.E(this.gOK, this.jpb.e("fail", null));
                return;
        }
    }
}
