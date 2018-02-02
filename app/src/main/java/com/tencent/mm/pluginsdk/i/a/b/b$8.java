package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.g.a.bc;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

class b$8 implements Runnable {
    final /* synthetic */ String icE;
    final /* synthetic */ int vgF;
    final /* synthetic */ boolean vgG;
    final /* synthetic */ int vgr;
    final /* synthetic */ int vgs;
    final /* synthetic */ b vgv;

    b$8(b bVar, int i, int i2, String str, int i3, boolean z) {
        this.vgv = bVar;
        this.vgr = i;
        this.vgs = i2;
        this.icE = str;
        this.vgF = i3;
        this.vgG = z;
    }

    public final void run() {
        b bcVar = new bc();
        bcVar.fpl.fpm = this.vgr;
        bcVar.fpl.fpn = this.vgs;
        bcVar.fpl.filePath = this.icE;
        bcVar.fpl.fpo = this.vgF;
        bcVar.fpl.fpp = this.vgG;
        a.xef.m(bcVar);
    }
}
