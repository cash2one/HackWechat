package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.aj.a;
import com.tencent.mm.plugin.appbrand.appcache.aj.a.b;
import com.tencent.mm.plugin.appbrand.appcache.g.2;
import com.tencent.mm.plugin.appbrand.appcache.g.4;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class g$2$1 implements a {
    final /* synthetic */ 2 iDV;

    g$2$1(2 2) {
        this.iDV = 2;
    }

    public final void a(String str, b bVar, a.a aVar) {
        x.i("MicroMsg.LibIncrementalTestCase[incremental]", "MockLibInfo Download Result %s", new Object[]{bVar});
        if (bVar != b.iGB) {
            ag.y(new 4(this.iDV.iDU, "Download MockLibInfo Error: " + bVar.name()));
        } else {
            ag.y(new Runnable(this) {
                final /* synthetic */ g$2$1 iDW;

                {
                    this.iDW = r1;
                }

                public final void run() {
                    this.iDW.iDV.iDU.b(this.iDW.iDV.iDU.iDT);
                    this.iDW.iDV.iDU.Dh(0);
                }
            });
        }
    }
}
