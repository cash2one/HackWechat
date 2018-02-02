package com.tencent.mm.plugin.appbrand.i;

import com.tencent.mm.plugin.appbrand.p.h;
import com.tencent.mm.sdk.platformtools.ak.a;
import java.util.concurrent.CountDownLatch;

class c$2 implements a {
    final /* synthetic */ h iUk;
    final /* synthetic */ CountDownLatch jBe;

    c$2(h hVar, CountDownLatch countDownLatch) {
        this.iUk = hVar;
        this.jBe = countDownLatch;
    }

    public final boolean uF() {
        this.iUk.jRK = new c.a();
        this.jBe.countDown();
        return false;
    }
}
