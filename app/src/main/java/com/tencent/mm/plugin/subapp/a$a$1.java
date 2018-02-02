package com.tencent.mm.plugin.subapp;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class a$a$1 implements a {
    final /* synthetic */ int rVr;
    final /* synthetic */ a.a rVs;

    a$a$1(a.a aVar, int i) {
        this.rVs = aVar;
        this.rVr = i;
    }

    public final boolean uF() {
        if (!this.rVs.rVh) {
            x.d("MicroMsg.SubCoreSubapp", "timmer get, delay:%d", new Object[]{Integer.valueOf(this.rVr)});
            this.rVs.a(a.a.a.rVw);
        }
        return false;
    }
}
