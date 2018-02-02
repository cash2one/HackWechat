package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.g.a.e;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;

public final class d {
    private static final c<e> iqs = new 1();

    static /* synthetic */ void ub() {
        com.tencent.mm.plugin.appbrand.q.c.Dm().F(af.iGd);
        com.tencent.mm.plugin.appbrand.q.c.Dm().F(com.tencent.mm.plugin.appbrand.appstorage.d.iGd);
    }

    public static void setup() {
        a.xef.a(iqs);
    }

    public static void release() {
        a.xef.c(iqs);
    }
}
