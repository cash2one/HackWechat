package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.launching.z.b;
import com.tencent.mm.plugin.appbrand.p.h;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;

class z$b$1 extends o {
    final /* synthetic */ CountDownLatch iFB;
    final /* synthetic */ h iUk;
    final /* synthetic */ b jyl;

    z$b$1(b bVar, int i, h hVar, CountDownLatch countDownLatch) {
        this.jyl = bVar;
        this.iUk = hVar;
        this.iFB = countDownLatch;
        super(i);
    }

    final String ahW() {
        return String.format(Locale.US, "NonIncremental %d", new Object[]{Integer.valueOf(z.a(this.jyl.jyj))});
    }

    final void c(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        this.iUk.jRK = wxaPkgWrappingInfo;
        this.iFB.countDown();
    }
}
