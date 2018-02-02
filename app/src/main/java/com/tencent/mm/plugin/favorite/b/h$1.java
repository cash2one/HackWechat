package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.protocal.c.uq;

class h$1 implements Runnable {
    final /* synthetic */ String hVU;
    final /* synthetic */ f mpD;
    final /* synthetic */ uq mpE;
    final /* synthetic */ h mry;

    h$1(h hVar, String str, f fVar, uq uqVar) {
        this.mry = hVar;
        this.hVU = str;
        this.mpD = fVar;
        this.mpE = uqVar;
    }

    public final void run() {
        if (h.Al(this.hVU)) {
            j.b(this.mpD, this.mpE, true);
        }
    }

    public final String toString() {
        return super.toString() + "|mAttachThumb";
    }
}
