package com.tencent.mm.plugin.appbrand.r.b;

import com.tencent.mm.plugin.appbrand.r.b.a.b;
import com.tencent.mm.plugin.appbrand.r.e.a;

public class c extends b {
    public final int a(a aVar) {
        if (d(aVar) == 13) {
            return b.jTK;
        }
        return b.jTL;
    }

    public final com.tencent.mm.plugin.appbrand.r.e.b a(com.tencent.mm.plugin.appbrand.r.e.b bVar) {
        super.a(bVar);
        bVar.put("Sec-WebSocket-Version", "13");
        return bVar;
    }

    public a alT() {
        return new c();
    }
}
