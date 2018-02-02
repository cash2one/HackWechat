package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.b.c.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.LinkedBlockingQueue;

class c$c {
    c$a kjA = new c$a(this.kjv);
    LinkedBlockingQueue<Object> kjU = new LinkedBlockingQueue();
    ad kjV = new ad();
    b kjW = null;
    private Runnable kjX = new 1(this);
    final /* synthetic */ c kjv;

    public c$c(c cVar) {
        this.kjv = cVar;
        e.b(this.kjX, "tagRunnable").start();
    }
}
