package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.bc.m;
import com.tencent.mm.plugin.aj.a.a;
import com.tencent.mm.plugin.aj.a.d;

class l$a implements Comparable {
    public a tlV;
    final /* synthetic */ l tmZ;
    public a tnd;

    private l$a(l lVar) {
        this.tmZ = lVar;
    }

    static /* synthetic */ a c(d dVar) {
        a hVar = (!l.Aa(dVar.scene) || m.Rj()) ? l.Ab(dVar.scene) ? new h(dVar) : new i(dVar) : new com.tencent.mm.modelappbrand.m(dVar);
        hVar.tjL = dVar.fDl;
        return hVar;
    }

    public final void b(d dVar) {
        if (this.tnd != null) {
            this.tnd.kpn = true;
        }
        this.tnd = new a(this, (byte) 0);
        this.tnd.hjF = dVar;
        l.a(this.tmZ, dVar);
        this.tnd.run();
    }

    public final int compareTo(Object obj) {
        return 0;
    }
}
