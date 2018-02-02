package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.launching.k.b;
import com.tencent.mm.plugin.appbrand.p.h;
import java.util.concurrent.CountDownLatch;

class n$1 implements b {
    final /* synthetic */ CountDownLatch iFB;
    final /* synthetic */ h jxQ;
    final /* synthetic */ n jxR;

    n$1(n nVar, h hVar, CountDownLatch countDownLatch) {
        this.jxR = nVar;
        this.jxQ = hVar;
        this.iFB = countDownLatch;
    }

    public final void b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        this.jxQ.jRK = wxaPkgWrappingInfo;
        this.iFB.countDown();
    }
}
