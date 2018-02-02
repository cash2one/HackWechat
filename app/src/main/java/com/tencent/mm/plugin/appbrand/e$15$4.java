package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.e.15;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.version.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class e$15$4 implements Runnable {
    final /* synthetic */ 15 irl;
    final /* synthetic */ a irn;

    e$15$4(15 15, a aVar) {
        this.irl = 15;
        this.irn = aVar;
    }

    public final void run() {
        a aVar = this.irn;
        c cVar = this.irl.irf.iqB;
        x.i("MicroMsg.AppBrand.Version.UpdateState[appversion]", "dispatch(%s), service %s", new Object[]{aVar.jrO, cVar});
        if (cVar != null) {
            Map hashMap = new HashMap(1);
            hashMap.put("state", aVar.jrO);
            new a.a((byte) 0).a(cVar).v(hashMap).afs();
        }
    }
}
