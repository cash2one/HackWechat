package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.g.a.mw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

class g$1 implements Runnable {
    final /* synthetic */ String oGI;
    final /* synthetic */ g oGJ;

    g$1(g gVar, String str) {
        this.oGJ = gVar;
        this.oGI = str;
    }

    public final void run() {
        this.oGJ.FA(this.oGI);
        b mwVar = new mw();
        mwVar.fEU.type = 2;
        a.xef.m(mwVar);
    }
}
