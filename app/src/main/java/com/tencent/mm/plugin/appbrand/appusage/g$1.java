package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ak.a;

class g$1 implements a {
    final /* synthetic */ PBool iJn;
    final /* synthetic */ PBool iJo;

    g$1(PBool pBool, PBool pBool2) {
        this.iJn = pBool;
        this.iJo = pBool2;
    }

    public final boolean uF() {
        if (!this.iJn.value) {
            this.iJo.value = true;
            g.a(null);
        }
        return false;
    }
}
