package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.aa.a;
import com.tencent.mm.plugin.appbrand.appcache.aa.d;
import com.tencent.mm.plugin.appbrand.p.h;
import com.tencent.mm.pluginsdk.i.a.d.l;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.concurrent.CountDownLatch;

class aa$a$2 extends aa$a$a {
    final /* synthetic */ h iFA;
    final /* synthetic */ CountDownLatch iFB;
    final /* synthetic */ a iFC;
    final /* synthetic */ ak iFD;

    aa$a$2(a aVar, d dVar, ak akVar, h hVar, CountDownLatch countDownLatch) {
        this.iFC = aVar;
        this.iFD = akVar;
        this.iFA = hVar;
        this.iFB = countDownLatch;
        super(dVar);
    }

    final void b(l lVar) {
        if (this.iFD != null) {
            this.iFD.TG();
        }
        this.iFA.jRK = lVar;
        this.iFB.countDown();
    }
}
