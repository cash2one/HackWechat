package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.plugin.appbrand.appusage.h.c.1;
import com.tencent.mm.sdk.platformtools.x;

class h$c$1$1 implements a {
    final /* synthetic */ double hyn;
    final /* synthetic */ float iJE;
    final /* synthetic */ float iJF;
    final /* synthetic */ 1 iJG;

    h$c$1$1(1 1, float f, float f2, double d) {
        this.iJG = 1;
        this.iJE = f;
        this.iJF = f2;
        this.hyn = d;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        x.d("MicroMsg.AppBrandPushNewOrRedDotLogic", "locationReport, errType %d, errCode %d, errMsg %s, longitude %f, latitude %f, accuracy %f", Integer.valueOf(i), Integer.valueOf(i2), str, Float.valueOf(this.iJE), Float.valueOf(this.iJF), Double.valueOf(this.hyn));
        return 0;
    }
}
