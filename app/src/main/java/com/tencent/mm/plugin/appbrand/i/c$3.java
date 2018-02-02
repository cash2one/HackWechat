package com.tencent.mm.plugin.appbrand.i;

import com.tencent.mm.ae.a$a;
import com.tencent.mm.plugin.appbrand.p.h;
import com.tencent.mm.vending.c.a;
import java.util.concurrent.CountDownLatch;

class c$3 implements a<Void, a$a<T>> {
    final /* synthetic */ CountDownLatch iFB;
    final /* synthetic */ h iUk;

    c$3(h hVar, CountDownLatch countDownLatch) {
        this.iUk = hVar;
        this.iFB = countDownLatch;
    }

    public final /* synthetic */ Object call(Object obj) {
        this.iUk.jRK = (a$a) obj;
        this.iFB.countDown();
        return zBS;
    }
}
