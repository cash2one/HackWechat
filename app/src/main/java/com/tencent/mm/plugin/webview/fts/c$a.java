package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.bc.m;
import com.tencent.mm.plugin.aj.a.a;
import com.tencent.mm.plugin.aj.a.d;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class c$a implements Comparable {
    final /* synthetic */ c tlU;
    public a tlV;
    ThreadPoolExecutor tlW;
    public a tlX;

    private c$a(c cVar) {
        this.tlU = cVar;
        this.tlW = new ThreadPoolExecutor(0, 10, 120, TimeUnit.SECONDS, new ArrayBlockingQueue(32));
    }

    static /* synthetic */ a a(d dVar) {
        a hVar;
        if (!c.zX(dVar.scene) || m.Rj()) {
            hVar = (dVar.scene == 21 ? 1 : null) != null ? new h(dVar) : new i(dVar);
        } else {
            hVar = new com.tencent.mm.modelappbrand.m(dVar);
        }
        hVar.tjL = dVar.fDl;
        return hVar;
    }

    public final int compareTo(Object obj) {
        return 0;
    }
}
