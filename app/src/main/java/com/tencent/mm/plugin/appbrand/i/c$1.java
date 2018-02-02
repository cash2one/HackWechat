package com.tencent.mm.plugin.appbrand.i;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.plugin.appbrand.p.h;
import com.tencent.mm.protocal.c.bdf;
import java.util.concurrent.CountDownLatch;

class c$1 implements a {
    final /* synthetic */ h iUk;
    final /* synthetic */ CountDownLatch jBe;

    c$1(h hVar, CountDownLatch countDownLatch) {
        this.iUk = hVar;
        this.jBe = countDownLatch;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        this.iUk.jRK = com.tencent.mm.ae.a.a.a(i, i2, str, (bdf) bVar.hmh.hmo, kVar, null);
        this.jBe.countDown();
        return 0;
    }
}
