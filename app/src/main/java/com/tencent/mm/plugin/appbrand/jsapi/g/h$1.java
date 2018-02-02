package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Map;

class h$1 implements b$a {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ h jph;

    h$1(h hVar, j jVar, int i) {
        this.jph = hVar;
        this.iZy = jVar;
        this.gOK = i;
    }

    public final void a(int i, String str, Map<String, Object> map) {
        switch (i) {
            case 1:
                this.iZy.E(this.gOK, this.jph.e("ok", null));
                return;
            case 2:
                if (bh.ov(str)) {
                    this.iZy.E(this.gOK, this.jph.e("fail", null));
                    return;
                }
                this.iZy.E(this.gOK, this.jph.e(String.format("fail %s", new Object[]{str}), null));
                return;
            default:
                this.iZy.E(this.gOK, this.jph.e("cancel", null));
                return;
        }
    }
}
