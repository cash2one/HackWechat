package com.tencent.mm.sdk.f;

import java.util.concurrent.atomic.AtomicInteger;
import junit.framework.Assert;

final class b {
    private ThreadGroup hDc;
    private final AtomicInteger xjQ = new AtomicInteger(1);
    private com.tencent.mm.sdk.f.e.b xjR;

    static class a extends Thread {
        private g xjS;

        a(ThreadGroup threadGroup, g gVar, String str) {
            super(threadGroup, gVar, str);
            this.xjS = gVar;
        }

        public final void start() {
            super.start();
        }

        public final void run() {
            super.run();
        }
    }

    b(com.tencent.mm.sdk.f.e.b bVar) {
        this.xjR = bVar;
        this.hDc = new ThreadGroup("MM_FREE_THREAD_GROUP");
    }

    final Thread a(Runnable runnable, String str, int i) {
        Assert.assertNotNull("newThread arg name is null!", str);
        if (runnable != null) {
            Thread aVar = new a(this.hDc, new g(runnable, str, i, false, this.xjR), "mmt_f" + str);
            aVar.setPriority(i);
            return aVar;
        }
        Thread aVar2 = new a(this.hDc, null, "mmt_f" + str);
        aVar2.setPriority(i);
        return aVar2;
    }
}
