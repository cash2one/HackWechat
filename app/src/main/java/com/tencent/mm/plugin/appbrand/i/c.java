package com.tencent.mm.plugin.appbrand.i;

import com.tencent.mm.ae.a.a;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.u;
import com.tencent.mm.plugin.appbrand.p.h;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.CountDownLatch;

public final class c {
    public static <T extends bdf> a<T> c(b bVar) {
        if (bVar == null) {
            return null;
        }
        h hVar = new h();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        u.a(bVar, new 1(hVar, countDownLatch));
        new ak(com.tencent.mm.bz.a.cll().getLooper(), new 2(hVar, countDownLatch), false).J(20000, 20000);
        try {
            countDownLatch.await();
            return (a) hVar.jRK;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SynchronousCgiCall", e, "latch await exp ", new Object[0]);
            return null;
        }
    }

    public static <T extends bdf> a<T> a(com.tencent.mm.ae.a<T> aVar) {
        h hVar = new h();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        aVar.JV().f(new 3(hVar, countDownLatch));
        try {
            countDownLatch.await();
            return (a) hVar.jRK;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SynchronousCgiCall", e, "semaphore await exp ", new Object[0]);
            return null;
        }
    }
}
