package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.launching.z.a;
import com.tencent.mm.plugin.appbrand.p.h;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;

class z$a$1 extends o {
    final /* synthetic */ CountDownLatch iFB;
    final /* synthetic */ h iUk;
    final /* synthetic */ a jyk;

    z$a$1(a aVar, int i, h hVar, CountDownLatch countDownLatch) {
        this.jyk = aVar;
        this.iUk = hVar;
        this.iFB = countDownLatch;
        super(i);
    }

    final String ahW() {
        return String.format(Locale.US, "Incremental %d|%d", new Object[]{Integer.valueOf(a.a(this.jyk)), Integer.valueOf(a.b(this.jyk))});
    }

    final void c(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        this.iUk.jRK = wxaPkgWrappingInfo;
        this.iFB.countDown();
    }
}
